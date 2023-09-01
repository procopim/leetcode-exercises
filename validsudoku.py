class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        #check rows first
        for row in board:
            check = {}
            for i in row:
                if i ==".":
                    continue
                elif not i in check.keys():
                    check[i] = 1
                else:
                    return False
        #check columns:
        for col in range(len(board)):
            check = {}
            for row in range(len(board)):
                if board[row][col] == ".":
                    continue
                elif not board[row][col] in check.keys():
                    check[board[row][col]] = 1
                else:
                    return False
        #check squares
        def squarecheck(row,col,board):
            check = {}
            for r in range(row,row+3):
                for c in range(col,col+3):
                    val = None
                    val = board[r][c]
                    if val == ".":
                        continue
                    elif not val in check.keys():
                        check[val] = 1
                    else:
                        return False
        results = []
        results.append(squarecheck(0,0,board))
        results.append(squarecheck(0,3,board))
        results.append(squarecheck(0,6,board))
        results.append(squarecheck(3,0,board))
        results.append(squarecheck(3,3,board))
        results.append(squarecheck(3,6,board))
        results.append(squarecheck(6,0,board))
        results.append(squarecheck(6,3,board))
        results.append(squarecheck(6,6,board))
        if not False in results:
            return True
        else:
            return False
            
    
#https://leetcode.com/problems/valid-sudoku