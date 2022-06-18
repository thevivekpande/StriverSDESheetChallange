public class Solution {
	public static boolean isItSudoku(int matrix[][]) {
		// Write your code here.
        return solve(matrix);
	}
    public static boolean solve(int matrix[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(matrix[i][j]==0){
                    for(int c=1;c<=9;c++){
                        if(isValid(matrix, i, j, c)){
                            matrix[i][j]=c;
                            if(solve(matrix)==true)
                                return true;
                            else
                                matrix[i][j]=0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isValid(int[][] matrix, int r, int c, int val){
        for(int i=0;i<9;i++){
            if(matrix[r][i]==val) return false;
            if(matrix[i][c]==val) return false;
            if(matrix[3*(r/3)+(i/3)][3*(c/3)+(i%3)]==val) return false;      
        }
        return true;
    }
}
