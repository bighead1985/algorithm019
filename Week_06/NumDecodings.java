/**
 * Description:
 * Date: 2020-12-13
 * Time: 10:39 PM
 */
public class NumDecodings {
//    public int numDecodings(String s) {
//        return getAns(s, 0);
//    }
//
//    private int getAns(String s, int start) {
//        //划分到了最后返回 1
//        if (start == s.length()) {
//            return 1;
//        }
//        //开头是 0,0 不对应任何字母，直接返回 0
//        if (s.charAt(start) == '0') {
//            return 0;
//        }
//        //得到第一种的划分的解码方式
//        int ans1 = getAns(s, start + 1);
//        int ans2 = 0;
//        //判断前两个数字是不是小于等于 26 的
//        if (start < s.length() - 1) {
//            int ten = (s.charAt(start) - '0') * 10;
//            int one = s.charAt(start + 1) - '0';
//            if (ten + one <= 26) {
//                ans2 = getAns(s, start + 2);
//            }
//        }
//        return ans1 + ans2;
//    }

    public int numDecodings(String s) {

        int n = s.length();
        int[] dp = new int[n];

        if(s.charAt(0)=='0') return 0;
        dp[0] = 1;
        for(int i=1;i<n;i++){

            int ans1 = 0;
            int ans2 = 0;
            if(s.charAt(i)!='0'){
               ans1 = dp[i-1];
            }
            if(s.charAt(i-1) == '1' || (s.charAt(i-1)=='2' && s.charAt(i) <='6')){
                if(i-2>=0){
                    ans2 = dp[i-2];
                }else{
                    ans2 = 1;
                }
            }
            dp[i] = ans1 +ans2;
        }
        return dp[n-1];

    }

    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("10"));
    }
}
