package phase1Base;

/**
 *
 * @author yun
 */
public class Common {

    public static int step = 0;
    public static String indent1 = "   | ";
    public static String indent2 = "       |";
    public static String padding = "\n| ----------------------------- ";

    public static enum Role {
        SENDER, RECEIVER
    }

    public static String caseSeperator(String token, String testCase) {

        String result = "";

        for (int i = 0; i < testCase.length(); i++) {

            result += token;
        }
   
        result += "\n\n" + testCase + "\n\n";

        for (int i = 0; i < testCase.length(); i++) {

            result += token;
        }
        result += "\n";

        return result;

    }

}
