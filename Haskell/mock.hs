
--fn :: [Char] -> Int -> (Char -> Bool) -> [Bool]
fn :: [a] -> Int -> (a -> b) -> [b]
--fn :: [Char] -> Int -> (Char -> t) -> [t]
fn xs n p = map p (take n xs)

stest str a n
   | count < n = "There aren't enough!"
   | count == n = "ok"
   | otherwise = "There are too many!"
     where
     count = length [ c | c <- str, c == a ]

fn' ::  Fractional a => a -> a -> a
fn' a b = 100 * a / b

fn'' :: Float -> Float -> Float
fn'' a b = a - 2 * b

fnn x [] = []
fnn x (True:ys) = x : fnn x ys
fnn x _ = []

fnn' [] _ = []
fnn' _ [] = []
fnn' (x:xs) (y:ys) = (x + y) : fnn' xs ys

hasMark :: String -> [(String,Int)] -> Bool
hasMark _ [] = False
hasMark name ((n,_):rest)
   | name == n = True
   | otherwise = hasMark name rest

--f xs
--  | n == 0 = 0
--  | otherwise = (p xs) * s
--    where
--    n = fromIntegral (length xs)
--    s = sum xs / n

qqq xs = let mn = minimum xs; tot = sum xs; n = fromIntegral (length xs)
               in (tot - mn) /n

greeting :: IO Int
greeting = do
                  putStrLn "Greetings! What is your name?"
                  inpStr <- getLine
                  putStrLn (inpStr ++ "! Nice name :) I'm sending back its length...")
                  return (length inpStr)

congratulations :: [(String, Int)] -> [String]
congratulations [] = []
congratulations ((name,mark):rest)
   | mark > 40 = name : congratulations rest
   | otherwise = congratulations rest



--getLine'     :: IO String
--getLine'     =  do c <- getChar
--                  if c == '\n'
--                       then return ""
--                       else do l <- getLine'
--                               return (c:l)

