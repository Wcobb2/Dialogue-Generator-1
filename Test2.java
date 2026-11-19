public class Test2 {
    public static void main(String[] args) {
        DialogueGenerator generator = new DialogueGenerator(DialogueGenerator.Style.CONFIDENT);
        for (int i = 0; i < 15; i++) {
            System.out.println(generator.nextPhrase());
        }
    }
}