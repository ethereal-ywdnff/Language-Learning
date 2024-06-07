
{-
  A really simple introductory Haskell program
  Emma Norling, September 2020
-}

module Basics where
    add :: Integer -> Integer -> Integer -- type definition
    add x y =  x + y -- equation

    -- No type definition provided - ghc will infer the types
    double x = x + x -- equation only!

    inc :: Int -> Int
    inc x = x+1 -- equation to return the input + 1

    -- Again, no type definition. This lead to a problem illustrated in the lecture.
    inc2 = (+ 1) -- another way of doing the same thing

    double2 x = x * 2

    firstWord :: String -> String
    firstWord input
      = takeWhile (/= ' ') (dropWhile (== ' ') input)

    first :: String -> String
    first x = head(words x)

    halve :: [a] -> ([a],[a])
    halve x | even len = (take half x, drop half x)
            | otherwise = error "Cannnot halve a list of odd length"
       where len = length x
             half = len `div` 2

    halve2 :: [a] -> ([a], [a])
    halve2 []  = ([], [])
    halve2 [x] = ([x], [])  -- necessary case for input lists that contains an odd number of elements
    halve2 (x : y : zs) = (x : xs, y : ys)
      where
        (xs, ys) = halve zs

    halve3 xs = (take n xs, drop n xs)
      where n = (length xs) `div` 2


    findFirsts :: [(String, Int)] -> [String]
    findFirsts result_list = [ name | (name, mark ) <- result_list, mark >= 70]

    euclidean :: (Int, Int) -> (Int, Int) -> Float
    euclidean (x1, y1) (x2, y2)
        = sqrt (fromIntegral ((x2-x1)^2 + (y2-y1)^2))

    report :: Float -> Float -> Float -> Float -> String
    report m1 m2 m3 m4
     | av >= 70 = "H1"
     | av >= 60 = "H2.1"
     | av >= 50 = "H2.2"
     | av >= 45 = "H3"
     | av >= 40 = "Pass"
     | otherwise = "Fail"
     where
     av = (m1+m2+m3+m4)/4
    report2 :: Float -> Float -> Float -> Float -> String
    report2 m1 m2 m3 m4 =
      if av >= 70 then "H1"
        else if av >= 60 then "H2.1"
          else if av >= 50 then "H2.2"
            else if av >= 45 then "H3"
              else if av >= 40 then "Pass"
                else "Fail"
      where av = (m1+m2+m3+m4)/4

    oddItems :: [Int] -> [Int]
    oddItems [] = []
    oddItems (x:xs) =
      if odd x then x:oddItems xs
        else oddItems xs
    oddItems' :: [Int] -> [Int]
    oddItems' list = filter odd list

    report4 :: [(Float,Int)] -> String
    report4 marks
     | av >= 70 = "H1"
     | av >= 60 = "H2.1"
     | av >= 50 = "H2.2"
     | av >= 45 = "H3"
     | av >= 40 = "Pass"
     | otherwise = "Fail"
     where
      av = sum (map weighted marks) / fromIntegral (sum (map snd marks))
      weighted mark = fst mark * fromIntegral (snd mark)