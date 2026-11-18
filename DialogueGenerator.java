import java.util.concurrent.ThreadLocalRandom;

public class DialogueGenerator {
    private static final String[] NICKNAMES = {
        "%s-o",
        "%s-bear",
        "%s-bug",
        "Captain %s"
    };

    private static final String[] COMPLIMENTS = {
        "%s, you're absolutely %s!",
        "I love how %2$s you are, %1$s!",
        "Thanks for being so %2$s, %1$s!",
        "%s, you make being %s look easy!"
    };

    public static void main(String[] args) {
        if (args.length == 2 && args[0].equals("nickname") && !args[1].isBlank()) {
            System.out.println(randomMessage(NICKNAMES, args[1].strip()));
        } else if (args.length == 3 && args[0].equals("compliment")
                && !args[1].isBlank() && !args[2].isBlank()) {
            System.out.println(randomMessage(COMPLIMENTS, args[1].strip(), args[2].strip()));
        } else {
            System.err.println("Usage: java DialogueGenerator.java nickname <name>");
            System.err.println("   or: java DialogueGenerator.java compliment <name> <adjective>");
            System.exit(1);
        }
    }

    private static String randomMessage(String[] templates, String... inputs) {
        return String.format(templates[ThreadLocalRandom.current().nextInt(templates.length)], (Object[]) inputs);
    }
}
