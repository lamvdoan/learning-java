package factory_pattern.helper;

public class StringHelper {
    public static String toTitleCase(String text) {
        String firstChar = text.substring(0, 1).toUpperCase();
        String remainingChars = text.substring(1, text.length()).toLowerCase();

        return firstChar + remainingChars;
    }
}
