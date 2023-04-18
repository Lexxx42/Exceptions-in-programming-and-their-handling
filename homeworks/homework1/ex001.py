# Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
# Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?

class AlotOfBugs:
    def error_div_by_zero(self, number1: int, number2=0) -> float:
        return number1 / number2

    def error_read_file(self, filename: str) -> str:
        with open(filename) as f:
            file_content = f.read()
        return file_content

    def error_print_list_elements(self, input_list: list[int]) -> str:
        elements = ''
        for item in range(0, 10):
            elements += str(input_list[item])
        return elements


bug = AlotOfBugs()

# Method errors
print(bug.error_div_by_zero(2))  # ZeroDivisionError: division by zero
print(bug.error_read_file('test.txt'))  # FileNotFoundError: [Errno 2] No such file or directory: 'test.txt'
print(bug.error_print_list_elements([1, 2, 3, 4, 5]))  # IndexError: list index out of range

# Bugs that can be found
print(bug.error_div_by_zero(spam, 2))  # NameError: name 'spam' is not defined, если
print(bug.error_div_by_zero('2', 2))  # TypeError: unsupported operand type(s) for /: 'str' and 'int'
print(bug.error_div_by_zero(2.2, 2.1)  # SyntaxError: '(' was never closed
assert bug.error_div_by_zero(2, 1) == 16, 'How could that happen!'  # AssertionError
from cool_story_bro import how_to_make_800k_in_nanosecond  # ModuleNotFoundError: No module named 'cool_story_bro'
