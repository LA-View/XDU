import java.util.*;

public class 正则表达式 {


    public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param str     string字符串
         * @param pattern string字符串
         * @return bool布尔型
         */
        public boolean match(String str, String pattern) {
            // write code here
            int n = str.length();
            int m = pattern.length();
            boolean[][] f = new boolean[n + 1][m + 1];

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    //分成空正则和非空正则两种
                    if (j == 0) {
                        f[i][j] = i == 0;
                    } else {
                        //非空正则分为两种情况 * 和 非*
                        if (pattern.charAt(j - 1) != '*') {
                            if (i > 0 && (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.')) {
                                f[i][j] = f[i - 1][j - 1];
                            }
                        } else {
                            //碰到 * 了，分为看和不看两种情况
                            //不看
                            if (j >= 2) {
                                f[i][j] |= f[i][j - 2];
                            }
                            //看
                            if (i >= 1 && j >= 2 && (str.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.')) {
                                f[i][j] |= f[i - 1][j];
                            }
                        }
                    }
                }
            }
            return f[n][m];
        }
    }
}
