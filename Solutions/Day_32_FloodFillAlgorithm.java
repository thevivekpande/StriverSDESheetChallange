public class Solution
{
    public static void dfs(int[][] image, int x, int y, int color, int newColor){
        if(image[x][y]==color){
            image[x][y]=newColor;
            if(x>=1) dfs(image, x-1, y, color, newColor);
            if(y>=1) dfs(image, x, y-1, color, newColor);
            if(x+1<image.length) dfs(image, x+1, y, color, newColor);
            if(y+1<image[0].length) dfs(image, x, y+1, color, newColor);
        }
    }
    public static int[][] floodFill(int[][] image, int x, int y, int newColor)
    {
        // Write your code here
        int color=image[x][y];
        if(color!=newColor) dfs(image, x, y, color, newColor);
        return image;
    }
}

