class Cool:
    def __init__(self, arr):
        self.arr = arr

    def get_element_sum(self):
        it = iter(self.arr)
        the_len = len(next(it))
        if not all(len(l) == the_len for l in it):
            return "length is not the same"
        return sum([sum(i) for i in zip(*self.arr)])


a = Cool([[1, 2], [3, 4]])
print(a.get_element_sum())
