public class Solution {
    public static int ninjaAndLadoos(int a[], int b[], int m, int n, int k) {
        // Write your code here.
        if(m>n) return ninjaAndLadoos(b, a, n, m, k);
        int low=Math.max(0, k-m), high=Math.min(n, k) ;
        while(low<=high){
            int cut1=(low+high)>>1;
            int cut2=k-cut1;
            int left1=cut1==0?Integer.MIN_VALUE:b[cut1-1];
            int left2=cut2==0?Integer.MIN_VALUE:a[cut2-1];
            int right1=cut1==n?Integer.MAX_VALUE:b[cut1];
            int right2=cut2==m?Integer.MAX_VALUE:a[cut2];
            if(left1<=right2 && left2<=right1){
                 return Math.max(left2, left1);
            }
            else if(left1>right2){
                high=cut1-1;
            }else{
                low=cut1+1;
            }
        }
        return -1;
    }
}
