package demos;
/*
example
        int[] arr = {2, 1};
        String str1 = "ABCABC";
        String str2 = "ABC";
        Solution sol = new Solution();
        String res = sol.gcdOfStrings(str1, str2);
        System.out.println("test printing");
*/
import java.util.Stack;

import static java.lang.Math.min;

public class Solution {
    public int maxProfit(int[] prices) {
        int gain= 0;
//        Stack<Integer> st = new Stack<Integer>();
//        for (int i = 0; i < prices.length; i++) {
//            if (st.empty() || st.peek()<prices[i]){
//                st.push(prices[i]);
//            } else{
//                int pre_price = st.peek();
//                if (prices[i] < pre_price ) {
//
//                }
//            }
//
//        }
        int len = prices.length;
        if (len<2) {
            return  0;
        }
        for (int i=0; i<len -1; i++){
            for (int j = i+1; j < len; j++) {
                gain = Math.max(gain, prices[j] - prices[i]);
            }
        }
        return gain;
    }

    public boolean validMountainArray(int[] arr) {
        //search for a mountain from left to right
        int len = arr.length;
        int left = 0;
        int right = 0;
        while (left+1< len && arr[left] < arr[left+1]) {
            left++;
        }
        while (right>0 && arr[right] > arr[right+1]){
            right++;
        }
        return left>0 && right < len -1 && left==right;
    }

    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int minLen = min(len1, len2);
        for (int i = minLen; i > 0; i--) {
            if (len1 % minLen==0 || len2 % minLen == 0){
                String X = str1.substring(0, i);
                if (check(str1, X) && check(str2, X)){
                    return X;
                }
            }
        }
        return str2;
    }

    public boolean check(String S, String T){
        int lenX = S.length()/T.length();
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < lenX; i++) {
            ans.append(T);
        }
        return ans.equals(lenX);
    }
}
