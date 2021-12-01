public class 质因数的个数 {

/*
描述
求正整数N(N>1)的质因数的个数。 相同的质因数需要重复计算。如120=2*2*2*3*5，共有5个质因数。
输入描述：
可能有多组测试数据，每组测试数据的输入是一个正整数N，(1<N<10^9)。
输出描述：
对于每组数据，输出N的质因数的个数。
示例1
输入：
120
复制
输出：
5
 */
//    #include<stdio.h>
//
//    int main() {
//        int n;
//
//        while (scanf("%d", & n)!=EOF){
//            int count = 0;
//            for (int i = 2; i * i <= n; i++) {
//                while (n % i == 0) {
//
//                    count++;
//                    n /= i;
//                }
//            }
//            if (n > 1) {    //质数时
//                printf("%d\n", count + 1);
//            } else {       //非质数时
//                printf("%d\n", count);
//            }
//
//        }
//        return 0;
//    }
}