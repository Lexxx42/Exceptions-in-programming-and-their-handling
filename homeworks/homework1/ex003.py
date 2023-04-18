# * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
# и возвращающий новый массив,
# каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
# Если длины массивов не равны, необходимо как-то оповестить пользователя.
# Важно: При выполнении метода единственное исключение,
# которое пользователь может увидеть - RuntimeException, т.е. ваше.

class RuntimeException(Exception):
    pass


class Divide:
    def return_division(self, list1: list[int], list2: list[int]) -> list[int]:
        if len(list1) == len(list2):
            try:
                return [i // j for i, j in zip(list1, list2)]
            except Exception as exc:
                raise RuntimeException('Input arrays must have equal lengths.') from exc
        raise RuntimeException('Input arrays must have equal lengths.')


diff_list = Divide()

print(diff_list.return_division([2, 2, 2], [0, 0, 0]))
print(diff_list.return_division([2, 2, 2], []))
print(diff_list.return_division([2, 2, 2], ['2', '2', '2']))
print(diff_list.return_division([2, 2, 2], [1, 1, 1, 1]))
