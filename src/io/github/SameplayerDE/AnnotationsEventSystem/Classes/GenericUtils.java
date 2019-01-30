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

}
