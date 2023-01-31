import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Regex {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Pattern pattern = null;
        Matcher match = null;
        boolean isValid = false;

        // ============================================================
        System.out.println("1. Password Validation");
        // (10 points)

        // Rules

        // 1. The password length should be greater than or equal to the total number of
        // letters in your surname.

        // 2. Any characters are allowed except the consonant letters in your surname.

        // 3. If your surname begins with a vowel, the password should begin with any
        // special character

        // 4. If your surname ends with a consonant, the password should end with any
        // digit.

        System.out.println("1. Password Validation");
        System.out.print("Enter Surname: ");
        String surname = scan.nextLine();
        System.out.print("Enter Password: ");
        String password = scan.nextLine();
        
        // Length rule
        int length = surname.length();
        if (password.length() < length) {
            System.out.println("Password is invalid! The length should be greater than or equal to the total number of letters in the surname.");
            return;
        }
        
        // Forbidden characters rule
        String forbidden = surname.replaceAll("[aeiouAEIOU]", "");
        for (char c : forbidden.toCharArray()) {
            if (password.indexOf(c) != -1) {
                System.out.println("Password is invalid! It contains a forbidden character.");
                return;
            }
        }
        
        // Start with special character rule
        String first = surname.substring(0, 1);
        if (first.matches("[aeiouAEIOU]")) {
            pattern = Pattern.compile("^[^A-Za-z0-9]+.*");
            match = pattern.matcher(password);
            if (!match.matches()) {
                System.out.println("Password is invalid! It should start with a special character.");
                return;
            }
        }
        
        // End with digit rule
        String last = surname.substring(length - 1);
        if (!last.matches("[aeiouAEIOU]")) {
            pattern = Pattern.compile(".*\\d$");
            match = pattern.matcher(password);
            if (!match.matches()) {
                System.out.println("Password is invalid! It should end with a digit.");
                return;
            }
        }
        
        System.out.println("Password is valid!");
        // ============================================================
        System.out.println("2. Personal Email Address Validation");
        // (10 points)

        // Note:
        // The prefix appears to the left of the @ symbol.
        // The domain appears to the right of the @ symbol. (e.g. gmail.com)

        // Rules

        // 1. The email domain should always end with "gmail.com" if your first name is
        // more than one.

        // 2. The email domain should always end with "ymail.com" if you only have one
        // first name.

        // 2. The email prefix should contain the last two digits of your student
        // number. This can appear anywhere in the prefix.

        // 3. The length of the email prefix should be at least 10 characters if the
        // last digit of your student number is an even number.

        // 4. The length of the email prefix should be at least 15 characters if the
        // last digit of your student number is an odd number.

        // 5. The email prefix should not contain any special characters except the
        // underscore and the dot.

        System.out.print("Enter Email: ");
        String email = scan.nextLine();

        // Provide regex pattern
        pattern = Pattern.compile("");

        match = pattern.matcher(email);

        isValid = match.matches();

        if (isValid) {
            System.out.println("Valid email!");
        } else {
            System.out.println("Invalid email!");
        }

        // ============================================================
        System.out.println("3.URl Validation");
        Scanner scan1 = new Scanner(System.in);
        System.out.print("Enter URL: ");
        String url = scan.nextLine();
        
        Pattern pattern1 = Pattern.compile("^(https?:\\/\\/)?(www\\.)?markpalencia\\.[a-zA-Z0-9]+");
        Matcher match1 = pattern.matcher(url);
        boolean isValid1 = match.matches();
    
        if (isValid1) {
            System.out.println("Valid URL!");
        } else {
            System.out.println("Invalid URL!");
        }
    
    

        // ============================================================
        Scanner scan2 = new Scanner(System.in);
        System.out.print("Enter surname: ");
        String surname2 = scan.nextLine();
        String myFiles = "report.pptx, project2019.xlsx, assignment2020.docx, registration2020.txt, helloworld.py, snake.java, hacker.cpp";
        
        
        
            // Check the last character of surname
            char lastChar = surname.charAt(surname.length() - 1);
            Pattern pattern2;
            Matcher match2Matcher;
            boolean found = false;
        
            // If the last character of surname is a vowel, retrieve source code files
            if (lastChar == 'a' || lastChar == 'e' || lastChar == 'i' || lastChar == 'o' || lastChar == 'u') {
                pattern = Pattern.compile(".*\\.py$|.*\\.java$|.*\\.cpp$");
                match = pattern.matcher(myFiles);
        
                while (match.find()) {
                    System.out.println("I found the source code file: " + match.group());
                    found = true;
                }
            } else {
                // If the last character of surname is a sentant, retrieve non source code files
                pattern = Pattern.compile(".*\\.(pptx|xlsx|docx|txt)$");
                match = pattern.matcher(myFiles);
        
                while (match.find()) {
                    System.out.println("I found the non-source code file: " + match.group());
                    found = true;
                }
            }
        
            if (!found) {
                System.out.println("No files found.");
            }
        

        // ============================================================
        System.out.println("5. Search and remove hashtag");
        // (10 points)

        String tweet = "I'd pet a million stray pit bulls before I'd eat a single pink-slimy McBite. #McDStories http://bit.ly/wd0BDe";

        // Instructions
        // 1. Remove the hashtag in the tweet

        // Provide the regex pattern
        tweet = tweet.replaceAll("#\\S+", "");

        System.out.println(tweet);

        // ============================================================
        System.out.println("6. Search and remove URL");
        // (10 points)

        tweet = "The oldest living survivor of the Japanese Attack on Pearl Harbor in 1941 celebrated his upcoming 105th birthday at the National World War II Museum in New Orleans. Joseph Eskenazi of Redondo Beach, California, boarded a train Friday for the journey. http://apne.ws/AayqsiC";

        // Instructions
        // 1. Remove the URL in the tweet

        // Provide the regex pattern
        tweet = tweet.replaceAll("https?://\\S+", "");

        System.out.println(tweet);

        // ============================================================
        System.out.println("7. Search and remove special characters");
        // (10 points)

        tweet = "Press On, three, was killed training this morning at Santa Anita – “musculoskeletal,” for now. He is the sixth dead horse at Cal tracks through the first three weeks of 2023. “Reform” is a ruse, “safe racing” a lie. Horseracing kills; it must end.";

        // Instructions
        // 1. Remove all special characters in the tweet.

        // Provide the regex pattern
        tweet = tweet.replaceAll("[^A-Za-z0-9 ]", "");

        System.out.println(tweet);

        scan.close();
    }
}
