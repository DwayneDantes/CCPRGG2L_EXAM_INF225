public class Recursion {

    public static void main(String[] args) {
        
        // Remove letters (30 pts)

        // Instructions (Important!)

        // Without using arrays or loops or regular expressions, apply recursion to remove specific letters in  Mark Emmanuel Palencia
        

        // 1. If the last letter of your surname is a vowel, remove all vowels in  Mark Emmanuel Palencia
        

        // 2. If the last letter of your surname is a consonant, remove all
        // consonants in your full name.

        // 3. Use only lowercase letters
        
        // 4. Each letter should be removed one by one.

        // Example:
        // Full name is "Mark Emmanuel Palencia".
       

        // Put your complete name in the "fullName" variable.
        // Example:
        // String fullName = "Mark Emmanuel Palencia";

        String fullName = "Mark Emmanuel C. Palencia";

        removeLetter(fullName);
    }

    static void removeLetter(String str) {
        if (str.length() == 0) {
            return;
        }
    
        String lastName = str.substring(str.lastIndexOf(" ") + 1);
        char lastLetter = lastName.charAt(lastName.length() - 1);
        boolean isVowel = lastLetter == 'a' || lastLetter == 'e' || lastLetter == 'i' || lastLetter == 'o' || lastLetter == 'u';
    
        if (isVowel) {
            removeVowels(str);
        } else {
            removeConsonants(str);
        }
    }
    
    static void removeVowels(String str) {
        if (str.length() == 0) {
            return;
        }
    
        char firstLetter = str.charAt(0);
        boolean isVowel = firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i' || firstLetter == 'o' || firstLetter == 'u';
    
        if (!isVowel) {
            System.out.print(firstLetter);
        }
    
        removeVowels(str.substring(1));
    }
    
    static void removeConsonants(String str) {
        if (str.length() == 0) {
            return;
        }
    
        char firstLetter = str.charAt(0);
        boolean isConsonant = firstLetter >= 'a' && firstLetter <= 'z' && !(firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i' || firstLetter == 'o' || firstLetter == 'u');
    
        if (isConsonant) {
            System.out.print(firstLetter);
        }
    
        removeConsonants(str.substring(1));
    }
}
