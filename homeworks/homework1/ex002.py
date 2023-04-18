# Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
# и возвращающий новый массив, каждый элемент которого равен
# разности элементов двух входящих массивов в той же ячейке.
# Если длины массивов не равны, необходимо как-то оповестить пользователя.


class Difference:
    def return_difference(self, list1: list[int], list2: list[int]) -> str | list[int]:
        if len(list1) != len(list2):
            return 'Input arrays must have equal lengths.'
        return [i - j for i, j in zip(list1, list2)]


diff_list = Difference()
print(diff_list.return_difference([2, 2, 2, 3], [1, 1, 1]))
