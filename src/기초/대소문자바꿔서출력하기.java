package 기초;
import java.util.Scanner;

//영어 알파벳으로 이루어진 문자열 str이 주어집니다.
// 각 알파벳을 대문자는 소문자로 소문자는 대문자로 변환해서 출력하는 코드를 작성해 보세요.
public class 대소문자바꿔서출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String a_lower = a.toLowerCase();
        String a_upper = a.toUpperCase();
        String result = "";
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if ('A' <= c && c <= 'Z') {
                result += a_lower.charAt(i);
            } else {
                result += a_upper.charAt(i);
            }
        }
        System.out.println(result);
    }
}
