import Data.Char

let2int :: Char -> Int
let2int c = ord c - (ord 'a')

int2let :: Int -> Char
int2let n = chr (ord 'a' + n)

shift :: Int -> Char -> Char
shift n c | isLower c = int2let ((let2int c + n) `mod` 26)
          | otherwise = c

-- This is where you need to do the work... how can you use those functions to encode/decode a string?
encode :: Int -> String -> String
encode n input = [ shift n x | x <- input ]
decode :: Int -> String -> String
decode n input = [ shift (-n) x | x <- input]


nth 1 (x:xs) = x
nth n (x:xs) = nth (n-1) xs

split1 :: [a] -> ([a], [a])
split1 []  = ([], [])
split1 [x] = ([x], [])  -- necessary case for input lists that contains an odd number of elements
split1 (x : y : zs) = (x : xs, y : ys)
   where
      (xs, ys) = split1 zs


merge :: Ord a => [a] -> [a] -> [a]
merge [] ys = ys
merge xs [] = xs
merge (x:xs) (y:ys)
  | x <= y = x:(merge xs (y:ys))
  | otherwise = y:(merge (x:xs) ys)


qsort :: Ord a => [a] -> [a]
qsort [] = []
qsort (x:xs)
  = qsort [y | y <- xs, y <= x]
    ++ [x] ++
    qsort [z | z <- xs, z > x]

replace :: String -> String -> String -> String
replace orig new [] = []
replace orig new (x:xs)
  | orig == prefix = new ++ replace orig new rest
  | otherwise = x : replace orig new xs
  where (prefix,rest) = splitAt (length orig) (x:xs)


--primes :: [Int]
--primes = [x | x <- [2..], prime x]

primes' :: [Int]
primes' = sieve [2..]
  where sieve (p:xs) = p : sieve [ n | n <- xs, n `mod` p > 0 ]


roots :: (Float, Float, Float) -> (Float, Float)
roots (a,b,c) = ((-b + sqrt (b*b -4.0*a*c)/a*2), (-b - sqrt (b*b -4.0*a*c)/a*2))

roots' :: (Float, Float, Float) -> (Float, Float)
roots' (a, b, c) =
  let s = sqrt (b*b - 4.0*a*c)
      d = 2.0*a
  in ((-b+s)/d,(-b-s)/d)

addc :: Char -> String -> String
addc c str = c:str

capitalizeStart :: String -> String
capitalizeStart (x:xs) =
  if isUpper x then x:xs
    else toUpper x : xs

zip' :: [a] -> [b] -> [(a, b)]
zip' [] _ = []
zip' (x:xs) (y:ys) = (x, y) : zip' xs ys

unzip' :: [(a,b)] -> ([a],[b])
unzip' [] = ( [], [] )
unzip' ((x,y):rest) = (x : rest_xs, y : rest_ys)
  where
    (rest_xs, rest_ys) = unzip' rest

map' f [] = []
map' f (x:xs) = f x : map' f xs