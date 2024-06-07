{- Note that the type definition for Shape has "deriving Show" added to it.
   Don't worry about it at the moment, we will come back to it. It's essential
   though if you want to test your functions; if you don't have it, you'll get
   a very confusing error.
-}
import Debug.Trace

data Shape = Circle Float | Rect Float Float deriving Show

-- Uncomment the type declaration and give a definition for the function scale
scale :: Float -> Shape -> Shape
scale a (Circle b) = Circle (b*a)
scale a (Rect b c) = Rect (b*a) (c*a)

mm xs = [x+3 | x <- xs]
ff xs = [x | x <- xs, x > 7]

mystery xs = foldr (:) [] (map sing xs)
  where
  sing x = [x]


maximum' x = foldl1 max x

altMap :: (a->b) -> (a->b) -> [a] -> [b]
altMap f g [] = []
altMap f g (x:xs) = f x : altMap g f xs

pipeline :: [(a->a)] -> [a] -> [a]
pipeline fns xs = map (piper fns) xs
  where
  piper [] = id
  piper (fn:fns) = fn . (piper fns)
pipeline' :: [(a->a)] -> [a] -> [a]
pipeline' fns xs = map (foldl (.) id fns) xs

tt 0 [x] = []
tt _ [] = []
tt n (x:xs) = x:tt (n-1) xs

mergesort :: (Ord a, Show a) => (a->a->Bool) -> [a] -> [a]
mergesort cmp [] = []
mergesort cmp [x] = [x]
mergesort cmp xs
 = trace (show xs ++ "(first half: " ++ show ys
 ++ "; second half: " ++ show zs ++ ")")
 merge cmp (mergesort cmp ys) (mergesort cmp zs)
 where
 (ys, zs) = (take n xs, drop n xs)
 n = length xs `div` 2
--mergesort :: (Ord a, Show a) => (a->a->Bool) -> [a] -> [a]
--mergesort cmp [] = []
--mergesort cmp [x] = [x]
--mergesort cmp xs
--  = traceShow xs merge cmp (mergesort cmp ys) (mergesort cmp zs)
--    where (ys, zs) = (take n xs, drop n xs)
--          n = length xs `div` 2
merge :: (Ord a, Show a) => (a->a->Bool) -> [a] -> [a] -> [a]
merge cmp [] ys = ys
merge cmp xs [] = xs
merge cmp (x:xs) (y:ys)
    | cmp x y = x : merge cmp xs (y:ys)
    | otherwise = y : merge cmp (x:xs) ys
my_function :: (String, Int) -> (String, Int) -> Bool
my_function (_, g1) (_, g2) = g1 < g2

switch :: Int ->a ->a->a
switch n x y
  |n>0 =x
  |otherwise = y