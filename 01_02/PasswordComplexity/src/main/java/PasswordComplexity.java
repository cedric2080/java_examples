import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordComplexity {

    public static boolean isPasswordComplex(String password) {
        // Valid if:
        //  - at least 6 characters
        //  - one uppercase letter
        //  - one lowercase letter
        //  - one number
        String regex1 = ".*[a-z].*";
        String regex2 = ".*[A-Z].*";
        String regex3 = ".*[0-9].*";

        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);
        Pattern pattern3 = Pattern.compile(regex3);

        Matcher matcher1 = pattern1.matcher(password);
        Matcher matcher2 = pattern2.matcher(password);
        Matcher matcher3 = pattern3.matcher(password);
        
        boolean result = false;
        if (password.length()>5){
            result = matcher1.matches() && matcher2.matches() && matcher3.matches();
        }
        
        return result;
    }

    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);

       System.out.println("Enter a password: ");
       String userInput = scanner.nextLine();
       System.out.println("Is the password complex? " +
               isPasswordComplex(userInput));
    }
}
