data Person = Person {
    name :: String,
    age :: Int
} deriving(Eq, Ord, Read, Show)

data Day = Monday | Tuesday | Wednesday | Thursday | Friday | Saturday | Sunday deriving(Eq, Ord, Show, Read, Enum, Bounded)
