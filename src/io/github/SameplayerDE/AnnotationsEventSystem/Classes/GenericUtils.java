package io.github.SameplayerDE.AnnotationsEventSystem.Classes;

public class GenericUtils {

    public static boolean isNumber(String string) {
        try {
            int i = Integer.parseInt(string);
        }catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public static String convertUmlaute(String string) {
        return string.replaceAll("ä", "ae").
                replaceAll("Ä", "Ae").
                replaceAll("ö", "oe").
                replaceAll("Ö", "Oe").
                replaceAll("ü", "ue").
                replaceAll("Ü", "Ue");
    }

    public static String convertUmlaute2(String string) {
        return string.replaceAll("ä", "\u00E4").
        replaceAll("Ä", "\u00C4").
        replaceAll("ö", "\u00F6").
        replaceAll("Ö", "\u00D6").
        replaceAll("ü", "\u00FC").
        replaceAll("Ü", "\u00DC");
    }

}
