class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet check = new HashSet();
        for (int i=0;i<board.length;i++)
        {
            for (int j=0;j<board[0].length;j++)
            {
                char n = board[i][j];
                if (n!='.'){
                if (!check.add(n+"row"+i)||!check.add(n+"col"+j)||!check.add(n+"block"+i/3+"-"+j/3))
                    return false;
                }
            }
        }
        return true;
    }
}