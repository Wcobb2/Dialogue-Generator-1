import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.random.RandomGenerator;

/** Generates playful, competition-focused phrases in a chosen style. */
public class DialogueGenerator {

    private static enum Style {
        CONFIDENT, SILLY, DRAMATIC
    }

    private static final List<String> CONFIDENT_PHRASES = List.of(
            "No <adjective> <noun> can stop me from winning!",
            "My <adjective> <noun> is ready to claim victory!",
            "Watch this <adjective> <noun> take the lead!",
            "I'm bringing my <adjective> <noun> to the competition!",
            "This <adjective> <noun> is taking home the win!",
            "You can't outplay my <adjective> <noun>!",
            "A <adjective> <noun> like mine guarantees victory!",
            "My <adjective> <noun> has this round in the bag!",
            "The <adjective> <noun> is all I need to win!",
            "I'm here to prove this <adjective> <noun> is unbeatable!");

    private static final List<String> SILLY_PHRASES = List.of(
            "Prepare to be defeated by my <adjective> <noun>!",
            "My <adjective> <noun> is already warming up its victory dance!",
            "You can't outrun this <adjective> <noun>!",
            "I'm powered by my <adjective> <noun> and a snack!",
            "Behold my <adjective> <noun>—the plan is questionable!",
            "My secret weapon is a <adjective> <noun>!",
            "I'm coming for the crown with my <adjective> <noun>!",
            "Even my <adjective> <noun> believes in me!",
            "My game plan is a <adjective> <noun> with a side of chaos!",
            "You haven't seen my final form: a <adjective> <noun>!");

    private static final List<String> DRAMATIC_PHRASES = List.of(
            "The <adjective> <noun> is the stage upon which my victory awaits!",
            "This <adjective> <noun> marks the moment my legend begins!",
            "Today, the scoreboard shall remember my <adjective> <noun>!",
            "The final round belongs to my <adjective> <noun>!",
            "Witness the dawn of my <adjective> <noun>!",
            "The contest ends with my <adjective> <noun> triumphant!",
            "I shall rise with my <adjective> <noun> and prevail!",
            "Let the games begin, and let my <adjective> <noun> be remembered!",
            "The crown awaits the <adjective> <noun> that claims it!",
            "No force can stop my <adjective> <noun> on the path to victory!");

    private final RandomGenerator random;
    private final List<String> phrases;
    private int previousIndex = -1;

    public DialogueGenerator() {
        this(new Random(), Random.nextInt() % 3 == 0 ? Style.CONFIDENT : Random.nextInt() % 3 == 1 ? Style.SILLY : Style.DRAMATIC);
    }

    public static DialogueGenerator getRandomPhrase() {
        Style style = Random.nextInt() % 3 == 0 ? Style.CONFIDENT : Random.nextInt() % 3 == 1 ? Style.SILLY : Style.DRAMATIC;
        return getRandomPhrase(style); 
    }

    public static String getRandomPhrase(Style style) {
        if(style == Style.CONFIDENT) {
            return CONFIDENT_PHRASES.get(random.nextInt(CONFIDENT_PHRASES.size()));
        } else if(style == Style.SILLY) {
            return SILLY_PHRASES.get(random.nextInt(SILLY_PHRASES.size()));
        } else {
            return DRAMATIC_PHRASES.get(random.nextInt(DRAMATIC_PHRASES.size()));
        }
    }
}
