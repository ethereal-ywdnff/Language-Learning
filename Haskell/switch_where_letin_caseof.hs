

bmi :: (RealFloat a) => a -> a -> String
bmi weight height
 | weight/height ^ 2 <= 18.5 = "underweight"
 | weight/height ^ 2 <= 25.0 = "normal"
 | weight/height ^ 2 <= 30.0 = "fat"
 | otherwise = "ahh"
--otherwise is default as true

{-bmi :: (RealFloat a) => a -> a -> String
bmi weight height
 | bmi ^ 2 <= 18.5 = "underweight"
 | bmi ^ 2 <= 25.0 = "normal"
 | bmi ^ 2 <= 30.0 = "fat"
 | otherwise = "ahh"
 where bmi = weight/height
-}


compare' :: (Ord a) => a -> a -> Ordering
a `compare'` b
 | a > b     = GT
 | a == b    = EQ
 | otherwise = LT



--let in
--let a + 5 in a * 2
--let a = 5; b = 4 in a + b
--let square x = x ^ 2 in [(square 4, square 5)]
--let (a,b,c) = (1,2,3) in a*b*c
cylinder :: (RealFloat a) => a -> a -> a
cylinder r h =
  let sideArea = 2 * pi * r * h
      baseArea = pi * r ^ 2
  in sideArea + 2 * baseArea



--输出前n个元素
say :: (Show a) => [a]->String
say[] = "empty list"

say(x:[]) = "first element is " ++ show x
--or say[x] = "first element is " ++ show x

say(x:y:[]) = "first two elements are " ++ show x ++ " and " ++ show y
{-or say[x,y] = "first two elements are " ++ show x ++ " and " ++ show y -}

say(x:y:_) = "first two elements are " ++ show x ++ " and " ++ show y


--输出前n个元素 case in
say' :: (Show a) => [a] -> String
say' xs = case xs of [] -> "empty list"
                     [x] -> "first element is " ++ show x
                     [x,y] -> "first two elements are " ++ show x ++ " and " ++ show y
                     (x:y:_) -> "first two elements are " ++ show x ++ " and " ++ show y

