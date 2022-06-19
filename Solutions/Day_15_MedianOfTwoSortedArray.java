public class Solution {
    public static double median(int[] a, int[] b) {
    	// Write your code here.
        if(b.length<a.length) return median(b, a);
        int n=a.length, m=b.length, low=0, high=n;
        while(low<=high){
            int cut1=(low+high)>>1;
            int cut2=((n+m+1)>>1)-cut1;
            int left1=cut1==0?Integer.MIN_VALUE:a[cut1-1];
            int left2=cut2==0?Integer.MIN_VALUE:b[cut2-1];
            int right1=cut1==n?Integer.MAX_VALUE:a[cut1];
            int right2=cut2==m?Integer.MAX_VALUE:b[cut2];
            if(left1<=right2 && left2<=right1){
                if((n+m)%2==0) return (((Math.max(left1, left2)+(Math.min(right1, right2)))/2.0));
                else return Math.max(left2, left1);
            }
            else if(left1>right2){
                high=cut1-1;
            }else{
                low=cut1+1;
            }
        }
        return 0.0;
    }
}