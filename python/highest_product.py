import unittest

def highest_product_of_3(list_of_ints):
    if ( len(list_of_ints)<3):
        raise IndexError('there must be more than or equal to 3 elements')
    k = sorted(list_of_ints)
    return max(k[0]*k[1]*k[-1], k[-1]*k[-2]*k[-3])
    # this approach has o(n logn ) time complexity, n space complexity


# def highest_product_of_3(list_of_ints):
#     if ( len(list_of_ints)<3):
#         raise IndexError('there must be more than or equal to 3 elements')

#     highest=max(list_of_ints[0],list_of_ints[1])
#     lowest=min(list_of_ints[0],list_of_ints[1])
#     highest_product_of_2 = lowest_product_of_2 = list_of_ints[0]*list_of_ints[1]
#     product_of_3 = max(highest_product_of_2, lowest_product_of_2)* list_of_ints[2]
    
#     for i in list_of_ints[2:]:
#         current_max = max(highest_product_of_2*i, lowest_product_of_2*i)
#         product_of_3 = max(product_of_3, current_max)
#         highest_product_of_2= max(highest * i, highest_product_of_2)
#         lowest_product_of_2= min(lowest * i, lowest_product_of_2)
#         if ( i < lowest):
#             lowest=i
#         if ( i > highest):
#             highest=i
#     return product_of_3 

def highest_product_of_3(list_of_ints):
    """a greedy order n approach taken off web (with a critical bug fix!)"""
    # from
    # https://knaidu.gitbooks.io/problem-solving/content/primitive_types/highest_product_of_3.html

    # Maintain the following values as we traverse the array
    # lowest_number
    # highest_number
    # lowest_product_of_2
    # highest_product_of_2
    # highest_product_of_3

    low = min(list_of_ints[0], list_of_ints[1])
    high = max(list_of_ints[0], list_of_ints[1])

    low_prod2 = high_prod2 = list_of_ints[0] * list_of_ints[1]
    high_prod3 = high_prod2 * list_of_ints[2]

    i = 2
    while i < len(list_of_ints):
        curr = list_of_ints[i]
        high_prod3 = max(
            high_prod2 * curr,
            low_prod2 * curr,
            high_prod3)

        low_prod2 = min(low * curr, low_prod2)
        high_prod2 = max(high * curr, high_prod2)

        high = max(high, curr)
        low = min(low, curr)
        i += 1  # heh, knaidu web book never incrs i, and so oo loop

    return high_prod3










# Tests

class Test(unittest.TestCase):

    def test_short_list(self):
        actual = highest_product_of_3([1, 2, 3, 4])
        expected = 24
        self.assertEqual(actual, expected)

    def test_longer_list(self):
        actual = highest_product_of_3([6, 1, 3, 5, 7, 8, 2])
        expected = 336
        self.assertEqual(actual, expected)

    def test_list_has_one_negative(self):
        actual = highest_product_of_3([-5, 4, 8, 2, 3])
        expected = 96
        self.assertEqual(actual, expected)

    def test_list_has_two_negatives(self):
        actual = highest_product_of_3([-10, 1, 3, 2, -10])
        expected = 300
        self.assertEqual(actual, expected)

    def test_list_is_all_negatives(self):
        actual = highest_product_of_3([-5, -1, -3, -2])
        expected = -6
        self.assertEqual(actual, expected)

    def test_error_with_empty_list(self):
        with self.assertRaises(Exception):
            highest_product_of_3([])

    def test_error_with_one_number(self):
        with self.assertRaises(Exception):
            highest_product_of_3([1])

    def test_error_with_two_numbers(self):
        with self.assertRaises(Exception):
            highest_product_of_3([1, 1])


unittest.main(verbosity=2)