doubleX x = x + x

doubleUs x y = doubleX x + doubleX y

doubleIf x = if x>100 then x else x*2

doubleIf' x = (if x>100 then x else x*2) + 10