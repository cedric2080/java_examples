import java.util.Scanner;

public class EvenOrOdd {

   public static boolean isEven(int n) {
       //int remainder;
       //boolean result;

       //remainder = n % 2;
       //result = false;
       //if (remainder == 0) {
       //    result = true;
       //}

       //return result;
       //return (n % 2) == 0;
       return (n & 1) ==0;
   }

   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       System.out.println("Enter a number: ");
       int userNum = scanner.nextInt();
       System.out.println("Is the number even? " + isEven(userNum));
   }
}
