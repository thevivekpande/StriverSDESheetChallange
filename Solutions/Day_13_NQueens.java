import java.util.*;
public class Solution {
    public static void dfs(int col, int n, int[][] board, ArrayList<ArrayList<Integer>> res){
        if(col==n){
            res.add(construct(board));
            return;
        }
        for(int row=0;row<n;row++){
            if(validate(board, row, col)){
                board[row][col]=1;
                dfs(col+1, n, board, res);
                board[row][col]=0;
            }
        }
    }
    
    public static ArrayList<Integer> construct(int[][] board){
        ArrayList<Integer> ds=new ArrayList();
        for(int[] row:board)
            for(int i:row)
                ds.add(i);
        return ds;
    }
    
    public static boolean validate(int[][] board, int row,int col){
        int dupRow=row;
        int dupCol=col;
        while(row>=0 && col>=0){
            if(board[row][col]==1) return false;
            row--;
            col--;
        }
        
        row=dupRow;
        col=dupCol;
        while(row>=0 && col>=0){
            if(board[row][col]==1) return false;
            col--;
        }
        
        row=dupRow;
        col=dupCol;
        while(row<board.length && col>=0){
            if(board[row][col]==1) return false;
            row++;
            col--;
        }
        
        return true;
    }
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        int[][] board=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j]=0;
        dfs(0, n, board, res);
        return res;
    }
}