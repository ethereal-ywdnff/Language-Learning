

fibonacci :: Integer -> Integer
fibonacci 0 = 1
fibonacci 1 = 1
fibonacci n = fibonacci(n-1) + fibonacci(n-2)




getMax :: (Ord a) => [a] -> a
getMax [] = error "EMPTY LIST"
getMax [x] = x
getMax (x:xs)
    | x > maxNum = x
    | otherwise = maxNum
    where maxNum = getMax xs


-- 用max函数（接收两个数，返回其中的较大数）
getMax' :: (Ord a) => [a] -> a
getMax' [] = error "EMPTY LIST"
getMax' [x] = x
getMax' (x:xs) = max x (getMax' xs)



replicate' :: (Num i, Ord i) => i -> a -> [a]
replicate' n x
    | n <= 0 = []
    | otherwise = x : replicate' (n-1) x