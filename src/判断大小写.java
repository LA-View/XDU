import java.util.*;

public class 判断大小写 {
    public static class Main {
        public static void main(String[] arg) {
            Scanner s = new Scanner(System.in);
            while (s.hasNextLine()) {
                String input1 = s.nextLine();
                String input = input1.replaceAll("([A-Z]+)", "");
                System.out.println(input1.length() - input.length());
            }
        }
    }
}
