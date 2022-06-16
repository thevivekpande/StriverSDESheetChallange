public class Solution
{
    public static int findMinimumCoins(int amount)
    {
        int[] coins=new int[]{1000,500,100,50,20,10,5,2,1};
        int i=0;
        int res=0;
        while(i<9 && amount>0){
            if(amount<coins[i])
                i++;
            else{
                res+=amount/coins[i];
                amount-=coins[i]*(amount/coins[i]);
                i++;
            }
        }
        return res;
    }
}
