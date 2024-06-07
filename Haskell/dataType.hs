data Person = Person {
    name :: String,
    age :: Int
} deriving(Eq, Ord, Read, Show)

data Day = Monday | Tuesday | Wednesday | Thursday | Friday | Saturday | Sunday deriving(Eq, Ord, Show, Read, Enum, Bounded)

data Either a b = Left a | Right b deriving (Eq, Ord, Read, Show)

data Calculation = Add Int Int | Sub Int Int

calc :: Calculation -> Int
calc (Add a b) = a + b