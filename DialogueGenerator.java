import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.random.RandomGenerator;

/** Generates playful, competition-focused phrases in a chosen style. */
public class DialogueGenerator {
    public enum Style {
        CONFIDENT, SILLY, DRAMATIC
    }

    private static final List<String> CONFIDENT_PHRASES = List.of(
            "I'm going to win this round!",
            "You have no chance!",
            "Victory is within my reach!",
            "I've got this game in the bag!",
            "I'm ready to claim the win!",
            "You can't keep up with me!",
            "This round is mine!",
            "I'm bringing my best game!",
            "Watch me take the lead!",
            "I'm here to win!");

    private static final List<String> SILLY_PHRASES = List.of(
            "Prepare to be defeated by my lucky socks!",
            "My victory dance is already warming up!",
            "You can't outrun my imaginary rocket shoes!",
            "I'm powered by snacks and the desire to win!",
            "Behold my highly questionable winning strategy!",
            "My secret weapon is an extra helping of enthusiasm!",
            "I'm coming for the crown, and maybe a cookie!",
            "Even my imaginary mascot believes in me!",
            "My game plan is chaos with a side of victory!",
            "You haven't seen my final form: extra confident!");

    private static final List<String> DRAMATIC_PHRASES = List.of(
            "The stage is set, and victory awaits me!",
            "This is the moment my legend begins!",
            "Today, the scoreboard shall know my name!",
            "The final round belongs to me!",
            "Witness the dawn of my triumph!",
            "The contest ends with my glorious victory!",
            "I shall rise to the challenge and prevail!",
            "Let the games begin, and let my victory be remembered!",
            "The crown awaits its rightful champion!",
            "My path to victory cannot be stopped!");

    private final RandomGenerator random;
    private final List<String> phrases;
    private int previousIndex = -1;

    public DialogueGenerator(Style style) {
        this(new Random(), style);
    }

    public DialogueGenerator(long seed, Style style) {
        this(new Random(seed), style);
    }

    private DialogueGenerator(RandomGenerator random, Style style) {
        this.random = random;
        this.phrases = switch (Objects.requireNonNull(style, "style")) {
            case CONFIDENT -> CONFIDENT_PHRASES;
            case SILLY -> SILLY_PHRASES;
            case DRAMATIC -> DRAMATIC_PHRASES;
        };
    }

    public String nextPhrase() {
        int index;
        if (previousIndex < 0) {
            index = random.nextInt(phrases.size());
        } else {
            index = random.nextInt(phrases.size() - 1);
            if (index >= previousIndex) {
                index++;
            }
        }
        previousIndex = index;
        return phrases.get(index);
    }
}
