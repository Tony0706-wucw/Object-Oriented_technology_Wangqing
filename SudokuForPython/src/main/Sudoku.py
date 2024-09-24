class Sudoku:
    # Constructor
    def __init__(self, data: str = None) -> None:
        if data:
            self.board = [[int(data[i * 9 + j]) for j in range(9)]
                          for i in range(9)]
        else:
            self.board = [[0 for _ in range(9)] for _ in range(9)]

    # Clone
    def clone(self):
        return Sudoku(str(self))

    # Serialization, turning the board into a series of numbers
    def serialize(self):
        return str(self)

    def __str__(self):
        return ''.join(str(num) for row in self.board for num in row)


    # Externalization, turning a string of numbers into a board
    @staticmethod
    def deserialize(data: str) -> 'Sudoku':
        return Sudoku(data)

    def getCandidates(self, row: int, col: int) -> list:
        if self.board[row][col] != 0:
            return []

        used = [False] * 10
        for i in range(9):
            used[self.board[row][i]] = True
            used[self.board[i][col]] = True
            used[self.board[row // 3 * 3 + i // 3][col // 3 * 3 + i % 3]] = True

        candidates = [num for num in range(1, 10) if not used[num]]
        return candidates

    def __eq__(self, other) -> bool:
        if self is other:
            return True
        if not isinstance(other, Sudoku):
            return False
        return self.board == other.board
    
    # print the board
    def printBoard(self) -> None:
        for row in self.board:
            print(' '.join(map(str, row)))
