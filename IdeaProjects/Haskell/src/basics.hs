
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

    firstword :: String -> String
    firstword "" = ""
    firstword (' ':x:s) = ""
    firstword (x :xs) = x : firstword xs

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


    findFirsts :: [(String, Int)] -> [String]
    findFirsts result_list = [ name | (name, mark ) <- result_list, mark >= 70]