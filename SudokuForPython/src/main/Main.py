from Sudoku import Sudoku

if __name__ == "__main__":
    input_data = "017903600000080000900000507072010430000402070064370250701000065000030000005601720"
    sudoku = Sudoku(input_data)
    sudoku.printBoard()