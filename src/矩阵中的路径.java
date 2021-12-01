public class 矩阵中的路径 {
    /*
    描述
请设计一个函数，用来判断在一个n乘m的矩阵中是否存在一条包含某长度为len的字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 \begin{bmatrix} a & b & c &e \\ s & f & c & s \\ a & d & e& e\\ \end{bmatrix}\quad
⎣
⎡
​

a
s
a
​

b
f
d
​

c
c
e
​

e
s
e
​

⎦
⎤
​
  矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
数据范围：,
进阶：时间复杂度，空间复杂度
示例1
输入：
[[a,b,c,e],[s,f,c,s],[a,d,e,e]],"abcced"
复制
返回值：
true
复制
     */
    public class Solution {
        public boolean hasPath(char[][] matrix, String word) {
            boolean flag[][] = new boolean[matrix.length][matrix[0].length];//flag[][]数组，初始化为false，表示未经过的点
            //一次初始化，之后共用 ==>是因为每次试探后，都会复原flag数组
            for (int i = 0; i <= matrix.length - 1; ++i) {
                for (int j = 0; j <= matrix[0].length - 1; ++j) {//每行每列的全部格子作为起点，开始尝试
                    if (dfs(matrix, word, i, j, 0, flag) == true) return true;//如果找到一个，则完成任务+停止尝试，立即返回true
                }
            }
            return false;//全部失败，返回false  //单个尝试的失败不会有任何返回
        }

        public boolean dfs(char[][] matrix, String word, int i, int j, int count, boolean flag[][]) {
            if (0 <= i && i <= matrix.length - 1 && 0 <= j && j <= matrix[0].length - 1) {//统一拦截==>【剪枝】
                if (matrix[i][j] == word.charAt(count) && flag[i][j] == false) {//匹配++
                    ++count;//也可以在后面都用count+1
                    if (count == word.length()) return true;//完整匹配，则主动停止  //全文仅此一处、是true的源头
                    flag[i][j] = true;//【尝试改flag】（与下文还原flag对应）
                    //下面递归结构类似4叉树的递归：
                    if (dfs(matrix, word, i + 1, j, count, flag)
                            || dfs(matrix, word, i - 1, j, count, flag)
                            || dfs(matrix, word, i, j + 1, count, flag)
                            || dfs(matrix, word, i, j - 1, count, flag)
                    ) return true;//这个return true是带有if的、起到传递true的作用，它不是源头
                    flag[i][j] = false;//【还原flag】//注意，平时传值都不需要"还原"（如count），而这里需要。
                }                                   //说明flag[][]数组，传的是指针(而不是提供副本)，递归分支是共用一个的
            }
            return false;
        }
    }//时间：O(rows*cols*3^word)//3是因为不能回头、减少一种路
//空间：1)flag空间 O(rows*cols)  2)栈空间O(word)
//如果有类似线性匹配的KMP模式串的优化，会快一些
}
