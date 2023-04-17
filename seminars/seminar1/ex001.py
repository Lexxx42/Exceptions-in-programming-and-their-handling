class Cool:
    def __init__(self, arr, num):
        self.arr = arr
        self.number_for_search = num

    def get_length(self):
        if not len(self.arr):
            return -1
        return len(self.arr)

    def search_number(self):
        if len(self.arr) < 2:
            return -1
        elif self.number_for_search not in self.arr:
            return -2
        elif self.arr is None:
            return -3
        elif self.number_for_search == 42:
            return "42 is cool number"
        return self.arr.index(self.number_for_search)


a = Cool([1, 2, 3, 4], 4)
print(a.search_number())
