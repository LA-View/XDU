import java.util.Scanner;

public class 字符串最后一个单词 {

    public static class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            int i = s.length() - 1;
            int t = 0;
            while (i >= 0 && s.charAt(i) != ' ') {
                t++;
                i--;
            }
            System.out.println(t);
        }
    }

//    #include <stdio.h>
//#include <string.h>
//
//    int main(void)
//    {
//        char str[5000] = {0};
//        char *str_p = str;
//        int count = 0;
//        fgets(str, sizeof(str), stdin);
//
//        int str_len = strlen(str) - 1;//减去换行符
//        if (str_len <= 0) {
//            printf("0\n");
//            return 0;
//        }
//
//        str_p = str_p + str_len - 1;
//        for (int i = 0; i < str_len; i++) {
//            if (*str_p != ' ')
//            count++;
//        else
//            break;
//            str_p--;
//        }
//
//        printf("%d\n", count);
//        return 0;
//    }
}
