import unittest
from ..main.Sudoku import Sudoku


class SudokuTest(unittest.TestCase):

    def setUp(self):
        self.input = "017903600000080000900000507072010430000402070064370250701000065000030000005601720"
        self.sudoku = Sudoku(self.input)

    def test_initialization(self):
        self.assertEqual(str(self.sudoku), self.input)

    def test_clone(self):
        clone = self.sudoku.clone()
        self.assertEqual(clone, self.sudoku)

    def test_serialize(self):
        serialized = self.sudoku.serialize()
        self.assertEqual(serialized, self.input)

    def test_deserialize(self):
        deserialize = Sudoku.deserialize(self.input)
        self.assertEqual(deserialize, self.sudoku)

    def test_getCandidates(self):
        expected = [2, 4, 5, 8]
        candidates = self.sudoku.getCandidates(0, 0)
        self.assertEqual(candidates, expected)

if __name__ == '__main__':
    unittest.main()