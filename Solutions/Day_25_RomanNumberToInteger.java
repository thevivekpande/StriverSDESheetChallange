public class Solution {
    public static int value(char ch){
        switch(ch){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return -1;
        }
    }
    public static int romanToInt(String s) {
        // Write your code here
        int res=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            int i1=value(s.charAt(i));
            if(i<n-1){
                int i2=value(s.charAt(i+1));
                if(i1<i2){
                    res+=i2-i1;
                    i++;
                }else{
                    res+=i1;
                }
            }else{
                res+=i1;
            }
        }
        return res;
    }
}