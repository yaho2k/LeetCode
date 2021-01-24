import java.util.Arrays;

public class M1329_SorttheMatrixDiagonally {

/*     
    1 2 3 4 5 
    1 2 3 4 5 
    1 2 3 4 5
    1 2 3 4 5 
 */

/* Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]] */

public static void main(String[] args) {
    Solution sol = new Solution();
    int [][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
    sol.diagonalSort(mat);

}
    static class Solution {
        public int[][] diagonalSort(int[][] mat) {
            
            int row = mat.length;
            int col = mat[0].length;

            int arraysMax = Math.min(row, col);
            int arrayNums = row+col-1;
            int[][] arrays =  new int[arrayNums][arraysMax];

            int arrayindex = 0;
            for(int i=0; i<col; i++){
                makeArray(mat,arrays, 0, i, arrayindex++, arraysMax);
            }

            for(int i=1; i<row; i++){
                makeArray(mat,arrays, i, 0, arrayindex++, arraysMax);
            }

            for(int i=0; i< arrayNums; i++){
                Arrays.sort(arrays[i]);
            }
            arrayindex= 0;
            for(int i=0; i<col; i++){
                restoreArray(mat,arrays, 0, i,arrayindex++);
            }

            for(int i=1; i<row; i++){
                restoreArray(mat,arrays, i, 0, arrayindex++);
            }    

            return mat;
        }

        private void restoreArray(int[][] mat, int[][] arrays, int startrow, int startcol, int arrayindex) {
            for (int row = startrow, col = startcol; row < mat.length && col < mat[0].length; row++, col++) {
                mat[row][col] = arrays[arrayindex][col - startcol];
            }
        }

        private void makeArray(int[][] mat, int[][] arrays, int startrow, int startcol, int arrayindex, int arrayMax) {
            int current = Integer.MAX_VALUE;
            for (int row = startrow, col = startcol; row < mat.length && col < mat[0].length; row++, col++) {
                arrays[arrayindex][col - startcol] = mat[row][col];
                current = col - startcol;
            }

            while (++current < arrayMax) {
                arrays[arrayindex][current] = Integer.MAX_VALUE;
            }
        }
        
    }
}
