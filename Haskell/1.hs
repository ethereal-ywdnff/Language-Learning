--单行注释
{-多行注释-}

getUppercase str = [a | a <- str, a `elem` ['A'..'Z']]

len' xs = sum [1|_ <- xs]

num xs = [if x > 10 then "B" else "S" | x <- xs, odd x]

quicksort :: Ord a => [a] -> [a]
quicksort [] = []
quicksort (x:xs) =
    let smallerSorted = quicksort [a | a <- xs, a <= x]
        biggerSorted = quicksort [a | a <- xs, a > x]
    in smallerSorted ++ (x : biggerSorted)

zipWith' :: (t1 -> t2 -> a) -> [t1] -> [t2] -> [a]
zipWith' _ [] _ = []
zipWith' _ _ [] = []
zipWith' f (x:xs) (y:ys) = f x y : zipWith' f xs ys

