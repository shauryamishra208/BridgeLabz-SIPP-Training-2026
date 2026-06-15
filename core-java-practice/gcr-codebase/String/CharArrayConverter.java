import java.util.Scanner;

class CharArrayConverter {

    public static char[] getCharactersFromString(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }

    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.next();

        char[] userDefinedArray = getCharactersFromString(text);
        char[] builtInArray     = text.toCharArray();
        boolean areEqual        = compareCharArrays(userDefinedArray, builtInArray);

        System.out.print("\nUser-defined char array : ");
        for (char c : userDefinedArray) System.out.print(c + " ");

        System.out.print("\nBuilt-in toCharArray()  : ");
        for (char c : builtInArray) System.out.print(c + " ");

        System.out.println("\nBoth arrays are equal   : " + areEqual);

        scanner.close();
    }
}
