package Exp3;

public class LCP {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("No input");
            return;
        }

        String prefix = args[0];

        for (int i = 1; i < args.length; i++) {
            while (!args[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    break;
            }
        }

        System.out.println("Prefix: " + prefix);
    }
}