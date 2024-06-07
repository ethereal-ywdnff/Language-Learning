--import Data.Sequence

fac n = aux n 1
  where
    aux n acc
      | n <= 1 = acc
      | otherwise = aux(n-1)(n*acc)

-- evens :: [Int] -> [Int]
evens[] = []
evens (x:xs)
  | mod x 2 == 0 = x : evens xs
  | otherwise = evens xs


f'' :: Num a => a -> a -> a -> a
f'' = \x -> \y -> \z -> x * y * z

filter1 :: (a -> Bool) -> [a] -> [a]
filter1 p xs = [ x | x <- xs, p x]

count e = foldr (\x acc -> if e == x then acc + 1 else acc) 0

isAll e = foldr (\x -> (&&) $ e == x ) True
isAll' e = foldr (\x acc ->  e == x && acc) True

map1 f = foldr ((:) . f) []

rev :: [a] -> [a]
rev = foldl(\acc x -> x : acc) []
--rev = foldl(flip(:)) []

prefixes :: [a] -> [[a]]
prefixes = foldr (\x acc -> [x] : (map ((:) x) acc)) []

snoc :: a -> [a] -> [a]
snoc x [] = [x]
snoc x (y:ys) = y: snoc x ys

de :: Eq a => a -> [a] -> [a]
de b [] = []
de b (x:xs) = if b == x then de b xs else x : de b xs

g' :: Num a => a -> a -> a -> a
g' = \w x y  -> w + y * x

month :: Int -> String
month 1 = "31 days"
month 2 = "28 days"
month 3 = "31 days"

tail' [] = []
tail' [x] = [x]
tail' (x:xs:ys) = xs: tail' ys

xor, and', or :: Bool -> Bool -> Bool
xor b1 b2 = not (b1 == b2)
and' True b1 = b1
and' False _ = False
or False b2 = b2
or True _ = True

nand, nor :: Bool -> Bool -> Bool
nand True True = False
nand _ _ = True
nor False False = True
nor _ _ = False
not1, not2 :: Bool -> Bool
not1 b = nand b b
not2 b = nor b b

h xs ys = zipWith ( \ x y -> (x+y)/2 ) xs ys
g xs y = map ( \ a -> 2*a + y) xs
g'' xs y = map f xs where f a = 2*a + y

fn :: Ord a => [a] -> a
fn [] = error "empty list input."
fn [x] = x
fn (x:xs)
   | x < mx = x
   | otherwise = mx
     where mx = fn xs

insert :: Ord a => a -> [a] -> [a]
insert x [] = [x]
insert x (y:ys)
  | x < y = x:y:ys
  | otherwise = y:insert x ys
--insertionSort :: Ord a => [a] -> [a] -> [a]
--insertionSort xs []      = xs
--insertionSort xs (y:ys) = insertionSort (insert y xs) ys
insertionSort :: Ord a => [a] -> [a]
insertionSort []     = []
insertionSort (x:xs) = insert x (insertionSort xs)


swaps :: Ord a => [a] -> [a]
swaps [] = []
swaps [x] = [x]
swaps (x1:x2:xs)
  | x1 > x2 = x2 : swaps (x1 : xs)
  | otherwise = x1 : swaps (x2 : xs)
fix :: Eq a => (a -> a) -> a -> a
fix f x = if x == x' then x else fix f x'
  where x' = f x
--bubbleSort :: Ord => [a] -> [a]
--bubbleSort xs = fix swaps xs
bubbleSort :: Ord a => [a] -> [a]
bubbleSort xs | swaps xs == xs = xs
               | otherwise = bubbleSort (swaps xs)

--map' [] = []
--map' (x:xs) = f x : map' xs
map' f [] = []
map' f (x:xs) = f x : map' f xs

apply :: (a -> a) -> Int -> a -> a
apply f 1 x = x
apply f n x = apply f (n - 1) (f x)

skip :: Eq a => a -> [a] -> [a]
skip x [] = [x]
skip x (y:ys) | x == y = (y:ys)
              | otherwise = x:y:ys
compress :: Eq a => [a] -> [a]
compress = foldr skip []

safeHead :: [a] -> Maybe a
safeHead [] = Nothing
safeHead (x:xs) = Just x

data BoolExp = TRUE | FALSE | IF BoolExp BoolExp BoolExp deriving (Show, Eq)
eval' :: [BoolExp] -> Bool
eval' [TRUE]  = True
eval' [FALSE] = False
eval' ((IF TRUE  b1 b2):xs) = eval' (b1:xs)
eval' ((IF FALSE b1 b2):xs) = eval' (b2:xs)
eval' (l@(IF con b1 b2):xs) = eval' (con:l:xs)
eval' (TRUE:(IF con b1 b2):xs)  = eval' (b1:xs)
eval' (FALSE:(IF con b1 b2):xs) = eval' (b2:xs)

data List a = Nil a | Cons a (List a) deriving (Eq, Show)
lhead :: List a -> a
lhead (Nil a) = a
lhead (Cons a _) = a

data Shape = Triangle Int Int Int | Circle Int
isValidShape :: Shape -> Bool
isValidShape s  |Circle r<-s, r>0=True
                | Triangle a b c <- s,
                a > 0 && b > 0 && c > 0,
                a + b > c && a + c > b && b + c > a
                = True
isValidShape _ = False

data Zipper a = Zipper [a] a [a] deriving Show
fromList' :: [a] -> Zipper a
fromList' (x:xs) = Zipper [] x xs
fromList' _      = error "empty!"
next :: Zipper a -> Zipper a
next (Zipper ys y (x:xs)) = Zipper (y : ys) x xs
next z = z
prev :: Zipper a -> Zipper a
prev (Zipper (y:ys) x xs) = Zipper ys y (x : xs)
prev z = z

aa list1 list2 = foldr (:) list1 list2

f x = ((+1).((*2)(pred)).(-1)) x

--greeting :: IO
--greeting = do
--                  putStrLn "Greetings! What is your name?"
--                  inpStr <- getLine
--                  putStrLn (inpStr ++ "! Nice name :) I'm sending back its length...")
--                  return (length inpStr)

fn' :: [Char] -> Int -> (Char -> t) -> [t]
--fn' :: [Char] -> Int -> (Char -> Bool) -> [Bool]
fn' xs n p = map p ( take n xs)

--fnnn x [] = []
--fnnn x True:ys = x : fn x ys
--fnnn x _ = []

--f'n :: Float -> Int -> Float
--f'n (a,b) = a - 2 * b

--congratulations :: [(String, Int)] -> [String]
--congratulations [] = []
--congratulations ((name,mark):rest)
--   | mark > 40 = name
--   | otherwise = congratulations rest

fn'' :: Ord a => [a] -> a
fn'' [] = error "Error: empty list input."
fn'' [x] = x
fn'' (x:xs)
   | x < mx = x
   | otherwise = mx
     where mx = fn xs
ffn :: [(a,b)] -> b
ffn ((x,y):zs) = y

hasMark :: String -> [(String,Int)] -> Bool
hasMark _ [] = False
hasMark name ((n,_):rest)
   | name == n = True
   | otherwise = False

a :: Float -> Float
a x = 2 / x

stest str a n
   | count < n = "There aren't enough!"
   | otherwise = "There are too many!"
     where
     count = length [ c | c <- str, c == a ]

hh xs = case xs of [] -> error"nothing"
                   (x:_) -> x

data Shapes = Circle' Float | Rect Float Float
area :: Shapes -> Float
area (Circle' r) = pi*r^2
area (Rect l w) = l*w
instance Ord Shapes where
  compare s1 s2 = compare (area s1) (area s2)
instance Eq Shapes where
  (==) s1 s2 = (area s1) == (area s2)

--big a b
--  | n > 0 = n
--  | otherwise = 0
--    where n = a - b
big a b
    | let n = a - b in n > 0 = 1
    | let n = a - b in n < 0 = 0

fd :: Float -> Float -> Float
fd a b = a / b