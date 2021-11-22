
def get_max_profit(prices):
    if ( len(prices)< 2):
        raise IndexError('Minimum 2 prices required')
    next_possible_buy= prices[0]
    next_possible_sell = prices [1]
    profit = next_possible_sell - next_possible_buy
    for i in range(1,len(prices)):
        if ( prices[i] < next_possible_buy ):
            next_possible_buy = prices[i]
        elif ( prices [i] > next_possible_sell ):
            next_possible_sell= prices [i]
            profit = next_possible_sell - next_possible_buy
    return profit    
# Tests

import unittest

class Test(unittest.TestCase):

    def test_price_goes_up_then_down(self):
        actual = get_max_profit([1, 5, 3, 2])
        expected = 4
        self.assertEqual(actual, expected)

    def test_price_goes_down_then_up(self):
        actual = get_max_profit([7, 2, 8, 9])
        expected = 7
        self.assertEqual(actual, expected)

    def test_price_goes_up_all_day(self):
        actual = get_max_profit([1, 6, 7, 9])
        expected = 8
        self.assertEqual(actual, expected)

    def test_price_goes_down_all_day(self):
        actual = get_max_profit([9, 7, 4, 1])
        expected = -2
        self.assertEqual(actual, expected)

    def test_price_stays_the_same_all_day(self):
        actual = get_max_profit([1, 1, 1, 1])
        expected = 0
        self.assertEqual(actual, expected)

    def test_error_with_empty_prices(self):
        with self.assertRaises(Exception):
            get_max_profit([])

    def test_error_with_one_price(self):
        with self.assertRaises(Exception):
            get_max_profit([1])
    


unittest.main(verbosity=2)