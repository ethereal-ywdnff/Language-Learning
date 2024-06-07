{-- Stub for the grading assignment. Fill it in, making sure you use good
 -- functional style, and add comments (including replacing those that are
 -- already here).
--}

module Enigma where
  import Data.Char  -- to use functions on characters
  import Data.Maybe -- breakEnigma uses Maybe type
  -- add extra imports if needed, but only standard library functions!

{- Part 1: Simulation of the Enigma -}

  type Rotor = (String, Int)
  type Reflector = [(Char, Char)]
  type Offsets = (Int, Int, Int)
  type Stecker = [(Char, Char)]
  
  data Enigma = SimpleEnigma Rotor Rotor Rotor Reflector Offsets
                | SteckeredEnigma Rotor Rotor Rotor Reflector Offsets Stecker

  encodeMessage :: String -> Enigma -> String
  encodeMessage [] _ = []
  encodeMessage (s:str) (SimpleEnigma rotor1 rotor2 rotor3 reflector offsets) =
    simpleChr : encodeMessage str (SimpleEnigma rotor1 rotor2 rotor3 reflector modifiedOffsets)
      where simpleChr = encodeChr s offsets rotor1 rotor2 rotor3 reflector
            modifiedOffsets = modifyOffsets offsets rotor1 rotor2 rotor3
  encodeMessage (s:str) (SteckeredEnigma rotor1 rotor2 rotor3 reflector offsets stecker) =
    steckerChr : encodeMessage str (SteckeredEnigma rotor1 rotor2 rotor3 reflector modifiedOffsets stecker)
      where steckerChr = steckering (encodeChr (steckering s stecker) offsets rotor1 rotor2 rotor3 reflector) stecker
            modifiedOffsets = modifyOffsets offsets rotor1 rotor2 rotor3

  -- encode a single character
  encodeChr :: Char -> Offsets -> Rotor -> Rotor -> Rotor -> Reflector -> Char
  encodeChr c offsets (rotor1, i1) (rotor2, i2) (rotor3, i3) reflector =
    encodeBack reflectedChr offsets (rotor1, i1) (rotor2, i2) (rotor3, i3)
      where encodeFrontChr = encodeFront c offsets (rotor1, i1) (rotor2, i2) (rotor3, i3)
            reflectedChr = reflect encodeFrontChr reflector

  -- encode a character based on a rotor(front side)
  frontRotor :: Char -> Int -> [Char] -> Char
  frontRotor c a rotor = posLetter $ alphaPos (rotor !! (mod (alphaPos c + a) 26)) - (mod a 26)
  -- encode a character based on all three rotors(front side)
  encodeFront :: Char -> Offsets -> Rotor -> Rotor -> Rotor -> Char
  encodeFront c (x, y, z) (rotor1, i1) (rotor2, i2) (rotor3, i3) =
    if rotor3 !! (mod26 z) == posLetter i1 && rotor2 !! (mod26 y) == posLetter i2
      then frontRotor (frontRotor (frontRotor c (mod26 z) rotor3) (mod26 y) rotor2) (mod26 x) rotor1
    else if rotor3 !! (mod26 z) == posLetter i1
           then frontRotor (frontRotor (frontRotor c (mod26 z) rotor3) (mod26 y) rotor2) x rotor1
         else frontRotor (frontRotor (frontRotor c (mod26 z) rotor3) y rotor2) x rotor1

  -- encode a character based on a rotor(back side)
  backRotor :: Char -> Int -> [Char] -> Char
  backRotor c a rotor = posLetter $ pos (rotateLetter a c) rotor - (mod a 26)
  -- encode a character based on all three rotors(back side)
  encodeBack :: Char -> Offsets -> Rotor -> Rotor -> Rotor -> Char
  encodeBack c (x, y, z) (rotor1, i1) (rotor2, i2) (rotor3, i3) =
    if rotor3 !! (mod26 z) == posLetter i1 && rotor2 !! (mod26 y) == posLetter i2
      then backRotor (backRotor (backRotor c (mod26 x) rotor1) (mod26 y) rotor2) (mod26 z) rotor3
    else if rotor3 !! (mod26 z) == posLetter i1
           then backRotor (backRotor (backRotor c x rotor1) (mod26 y) rotor2) (mod26 z) rotor3
         else backRotor (backRotor (backRotor c x rotor1) y rotor2) (mod26 z) rotor3

  -- swap letter based on the reflector
  reflect :: Char -> Reflector -> Char
  reflect c ((r1, r2):reflector)
    | c == r1 = r2
    | c == r2 = r1
    | otherwise = reflect c reflector

  -- swap letter based on the plugboard,
  -- and letters not in the pairs remain unchanged
  steckering :: Char -> Stecker -> Char
  steckering c [] = c
  steckering c ((p1, p2):plugboard)
    | c == p1 = p2
    | c == p2 = p1
    |otherwise = steckering c plugboard

  -- modify the offset, otherwise characters in a string will be decoded by the same offsets all the time
  modifyOffsets :: Offsets -> Rotor -> Rotor -> Rotor -> Offsets
  modifyOffsets (x, y, z) (rotor1, i1) (rotor2, i2) (rotor3, i3) =
    if rotor3 !! (mod26 z) == posLetter i1 && rotor2 !! (mod26 y) == posLetter i2
      then (mod26 x, mod26 y, mod26 z)
    else if rotor3 !! (mod26 z) == posLetter i1
           then (x, mod26 y, mod26 z)
         else (x, y, mod26 z)

  -- The position of a character in the rotor
  pos :: (Eq a, Num b) => a -> [a] -> b
  pos c str = pos' c str 0
              where
                pos' _ [] _ = -1
                pos' c (s:str) n
                  | c == s = n
                  | otherwise = pos' c str (n + 1)

  -- given a int number, return the remainder of that number plus 1 divided by 26
  mod26 :: Int -> Int
  mod26 a = (a + 1) `mod` 26


{- Part 2: Finding the Longest Menu -}

  type Menu = [Int]
  type Crib = [(Char, Char)]

  longestMenu :: Crib -> Menu
  longestMenu [] = []
  longestMenu crib = constructMenu crib (findLongest (menuList crib 0))

  -- generate all the menus and store their length in a list
  menuList :: Crib -> Int -> [Int]
  menuList crib n =
    if n < length crib
      then length (constructMenu crib n) : menuList crib (n + 1)
    else []

  -- find the longest one and returns the index of that position with the longest menu
  findLongest :: Ord a => [a] -> Int
  findLongest list = findLongest' list 0
                      where
                        findLongest' list n
                          | list !! n == maximum list = n
                          | otherwise = findLongest' list (n + 1)

  -- construct a menu
  constructMenu :: Crib -> Int -> Menu
  constructMenu crib n =
    if n < length crib
      then if isPositive (position (snd (crib !! n)) crib)
             then n : constructMenu (modifyCrib n crib) (position (snd (crib !! n)) crib)
           else [n]
    else []
      where cc = crib

  -- given a plain character and the crib, return the index of that character in the crib
  --                                       return -1 if that character is not in the crib
  position :: Char -> Crib -> Int
  position m crib = position' m crib 0
                      where
                        position' _ [] _ = -1
                        position' m ((c1, c2) : crib) n
                          | m == c1 = n
                          | otherwise = position' m crib (n + 1)

  -- check whether the given number is positive
  isPositive :: (Ord a, Num a) => a -> Bool
  isPositive a = if a >= 0 then True else False

  -- modify the pairs that have been iterated
  modifyCrib :: Int -> Crib -> Crib
  modifyCrib n crib = modifyCrib' n crib 0
                      where
                        modifyCrib' n ((c1, c2):crib) a =
                          if n == a
                            then ('a', 'a') : crib
                          else (c1, c2) : modifyCrib' n crib (a + 1)



{- Part 3: Simulating the Bombe -}
  
  breakEnigma :: Crib -> Maybe (Offsets, Stecker)
  breakEnigma _ = Nothing

{- Useful definitions and functions -}

   -- substitution cyphers for the Enigma rotors
   -- as pairs of (wirings, knock-on position)
   -- knock-on position is where it will cause the next left wheel to
   -- advance when it moves past this position
 
        --"ABCDEFGHIJKLMNOPQRSTUVWXYZ"
  rotor1=("EKMFLGDQVZNTOWYHXUSPAIBRCJ",17::Int)
  rotor2=("AJDKSIRUXBLHWTMCQGZNPYFVOE",5::Int)
  rotor3=("BDFHJLCPRTXVZNYEIWGAKMUSQO",22::Int)
  rotor4=("ESOVPZJAYQUIRHXLNFTGKDCMWB",10::Int)
  rotor5=("VZBRGITYUPSDNHLXAWMJQOFECK",0::Int)

  {- the standard Enigma reflector (Reflector B)
    swapped A<->Y, B<->R, C<->U,D<->H, E<->Q, F<->S, G<->L, 
            I<->P, J<->X, K<->N, M<->O, T<->Z,V<->W
  -}
  reflectorB= [('A','Y'),
              ('B','R'),
              ('C','U'),
              ('D','H'),
              ('E','Q'),
              ('F','S'),
              ('G','L'),
              ('I','P'),
              ('J','X'),
              ('K','N'),
              ('M','O'),
              ('T','Z'),
              ('V','W')]

  {- alphaPos: given an uppercase letter, returns its index in the alphabet
     ('A' = position 0; 'Z' = position 25)
   -}
  alphaPos :: Char -> Int
  alphaPos c = (ord c) - ord 'A'
  -- given an index in the alphabet, returns an uppercase letter
  posLetter :: Int -> Char
  posLetter i = chr ( ord 'A' + (mod i 26) )
  -- given an int and an uppercase letter, return an uppercase letter that
  -- index is the addition of given int and given uppercase letter’s index
  rotateLetter :: Int -> Char -> Char
  rotateLetter i ch = posLetter (alphaPos ch + i)