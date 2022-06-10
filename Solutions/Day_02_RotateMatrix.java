import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        // Write your code here.
        int row=0, col=0, prev, curr;
        while (row < n && col < m)
        {
     
            if (row + 1 == n || col + 1 == m)
                break;
            prev = mat.get(row + 1).get(col);
            for (int i = col; i < m; i++)
            {
                curr = mat.get(row).get(i);
                mat.get(row).set(i,prev);
                prev = curr;
            }
            row++;
            for (int i = row; i < n; i++)
            {
                curr = mat.get(i).get(m-1);
                mat.get(i).set(m-1, prev);
                prev = curr;
            }
            m--;
            if (row < n)
            {
                for (int i = m-1; i >= col; i--)
                {
                    curr = mat.get(n-1).get(i);
                    mat.get(n-1).set(i, prev);
                    prev = curr;
                }
            }
            n--;
            if (col < m)
            {
                for (int i = n-1; i >= row; i--)
                {
                    curr = mat.get(i).get(col);
                    mat.get(i).set(col,prev);
                    prev = curr;
                }
            }
            col++;
        }
    }
}
