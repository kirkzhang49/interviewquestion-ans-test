public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m =A.length,n=A[0].length,nB = B[0].length;
        int [][] C = new int [m][nB];
        for (int i = 0; i <m;i++)//rows
        {
            for (int k =0; k<n; k++)//cols
            {
               if (A[i][k]!=0)
               {
                 for (int j=0;j<nB;j++)
                 {
                     if (B[k][j]!=0)
                     { . //i start j end match here
                         C[i][j] +=A[i][k]*B[k][j];
                     }
                 }
               }
            }
        }
        return C;
    }
}
/*
A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
*/