import java.util.Scanner;

/**
 * Created by ODA on 27.09.2016.
 */
public class stepik2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int value = in.nextInt();

        System.out.println(isPowerOfTwo(value));

    }

    public static boolean isPowerOfTwo(int value) {
        int valueABS=Math.abs(value);
        boolean result = false;
        for(int i=0; i<=32;i++)
        {
            int c= (int) Math.pow(2, i); // n в степени b

            if(valueABS==c)
            {
                result = true;
                break;
            }
        }

        return result;
    }
}
