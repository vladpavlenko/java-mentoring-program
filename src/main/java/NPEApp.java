public class NPEApp {
    public static void main(String[] args) {
        // -XX:+ShowCodeDetailsInExceptionMessages added to VM options in order to see detailed message for NPE
        newNPE(null);
    }

    static boolean newNPE(String string) {
        return string.equals("What is on my mind");
    }
}