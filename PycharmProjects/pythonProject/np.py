import numpy as np

my_list = [1, 2, 3, 4, 5]
my_array = np.array(my_list)  # create a simple 1-D array
print(my_list)
print(my_array)
print(type(my_list))
type(my_array)

print()
my_2d_array = np.array([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
print(my_2d_array)
type(my_2d_array)

print()
my_2d_array.shape
my_2d_array.size
print(my_2d_array.dtype)

print()
x2 = np.array([[1,2], [3, 4],[5,6]])  # a matrix
x3 = np.array([x2, x2, x2, x2])  # stacking two matrices
print(x3.shape)