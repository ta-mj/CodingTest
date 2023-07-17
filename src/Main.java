import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";
        String[] arr = s.split(" ");
        int[] arr_int = Arrays.stream(s.split(" "))
                .mapToInt(i->Integer.parseInt(i))
                .sorted()
                .toArray();
        System.out.println(arr_int[0] + " " + arr_int[arr_int.length - 1]);

    }
}