

workingDay :: (Integral a) => a -> String
workingDay 1 = "Monday"
workingDay 2 = "Tuesday"
workingDay 3 = "Wednesday"


factorial :: (Integral a) => a -> a
factorial 0 = 1
factorial x = x * factorial(x-1)


addParis :: (Num a) => (a,a) -> (a,a) -> (a,a)
addParis (a,b)(x,y) = (a + x, b + y)


first :: (a,b,c) -> a
first (x,_,_) = x

second :: (a,b,c) -> b
second (x,y,_) = y

third :: (a,b,c) -> c
third (x,y,z) = z




--override head function
head' :: [a] -> a
head [] = error "empty list"
head' (x:_) = x

{-error: 接受一个字符串（出错信息），
	    生成一个运行时错误。
-}




--输出前n个元素
say :: (Show a) => [a]->String
say[] = "empty list"

say(x:[]) = "first element is " ++ show x
--or say[x] = "first element is " ++ show x

say(x:y:[]) = "first two elements are " ++ show x ++ " and " ++ show y
{-or say[x,y] = "first two elements are " ++ show x ++ " and " ++ show y -}

say(x:y:_) = "first two elements are " ++ show x ++ " and " ++ show y




--len': 自定义length
len' :: (Num b) => [a] -> b
len' [] = 0
len' (_:x) = 1 + len' x
{- len' "st" = 1 + len' "t"
             = 1 + 1 + len' " "
             = 1 + 1 + 1
             = 3
-}




--完整字符串引用: 名称 + @ + 模式
capital :: String -> String
capital "" = "empty string"
capital all@(x:xs) = "first element of " ++ all ++ ": " ++ [x]












