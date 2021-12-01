import java.util.*;

public class 字符串合并处理 {
    /*
    描述
按照指定规则对输入的字符串进行处理。

详细描述：

第一步：将输入的两个字符串str1和str2进行前后合并。如给定字符串 "dec" 和字符串 "fab" ， 合并后生成的字符串为 "decfab"

第二步：对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标的意思是字符在字符串中的位置。注意排序后在新串中仍需要保持原来的奇偶性。例如刚刚得到的字符串“decfab”，分别对下标为偶数的字符'd'、'c'、'a'和下标为奇数的字符'e'、'f'、'b'进行排序（生成 'a'、'c'、'd' 和 'b' 、'e' 、'f'），再依次分别放回原串中的偶数位和奇数位，新字符串变为“abcedf”

第三步：对排序后的字符串中的'0'~'9'、'A'~'F'和'a'~'f'字符，需要进行转换操作。
转换规则如下：
对以上需要进行转换的字符所代表的十六进制用二进制表示并倒序，然后再转换成对应的十六进制大写字符（注：字符 a~f 的十六进制对应十进制的10~15，大写同理）。
如字符 '4'，其二进制为 0100 ，则翻转后为 0010 ，也就是 2 。转换后的字符为 '2'。
如字符 ‘7’，其二进制为 0111 ，则翻转后为 1110 ，对应的十进制是14，转换为十六进制的大写字母为 'E'。
如字符 'C'，代表的十进制是 12 ，其二进制为 1100 ，则翻转后为 0011，也就是3。转换后的字符是 '3'。
根据这个转换规则，由第二步生成的字符串 “abcedf” 转换后会生成字符串 "5D37BF"


注意本题含有多组样例输入。

数据范围：输入的字符串长度满足

输入描述：
本题含有多组样例输入。每组样例输入两个字符串，用空格隔开。

输出描述：
输出转化后的结果。每组样例输出一行。

示例1
输入：
dec fab
复制
输出：
5D37BF
复制
示例2
输入：
ab CD
复制
输出：
3B5D
复制
说明：
合并后为abCD，按奇数位和偶数位排序后是CDab（请注意要按ascii码进行排序，所以C在a前面，D在b前面），转换后为3B5D
示例3
输入：
123 15
复制
输出：
88C4A

     */


    public static class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            while (in.hasNext()) {
                char[] str1 = in.next().toCharArray();
                char[] str2 = in.next().toCharArray();
                //合并
                StringBuilder res = new StringBuilder();
                res.append(str1);
                res.append(str2);
                //奇偶分类
                StringBuilder even = new StringBuilder();
                StringBuilder odd = new StringBuilder();
                for (int i = 0; i < res.length(); i++) {
                    if (i % 2 == 0) even.append(res.charAt(i));
                    else odd.append(res.charAt(i));
                }
                char[] evenC = even.toString().toCharArray();
                char[] oddC = odd.toString().toCharArray();
                Arrays.sort(evenC);
                Arrays.sort(oddC);
                //再次合并,并非直接拼接，而是按原先的奇偶插回
                int oddIndex = 0;
                int evenIndex = 0;
                StringBuilder sorted = new StringBuilder();
                for (int j = 0; j < res.length(); j++) {
                    if (j % 2 == 0) {
                        sorted.append(evenC[evenIndex]);
                        evenIndex++;
                    } else {
                        sorted.append(oddC[oddIndex]);
                        oddIndex++;
                    }
                }

                //转换
                String dict = "0123456789abcdefABCDEF";//只是为了写起来方便
                char[] sortedChar = sorted.toString().toCharArray();
                for (int m = 0; m < sortedChar.length; m++) {
                    //如果是0-9,a-f,A-F
                    if (dict.contains(String.valueOf(sortedChar[m]))) {
                        //转换为十进制
                        int decimal = Integer.parseInt(String.valueOf(sortedChar[m]), 16);
                        //转换为二进制,加leading zeros
                        String binary = Integer.toString(decimal, 2);
                        binary = String.format("%04d", Integer.valueOf(binary));
                        //翻转
                        String reverseBinary = new StringBuilder(binary).reverse().toString();
                        //转换回16进制，如果是小写字符，变大写
                        //实际上这里无需判断是否是别的字符，因为四位二进制最大也就是1111，对应f,所以直接转换成大写
                        decimal = Integer.parseInt(reverseBinary, 2);
                        String hex = Integer.toString(decimal, 16).toUpperCase();
                        sortedChar[m] = hex.charAt(0);
                    }
                }
                System.out.println(sortedChar);
            }
        }
    }
}
