public class Test2 {
    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.println(RandomSentence.getRandomSentence(List.of("dragon", "wizard", "castle"), List.of("fierce", "mysterious", "ancient")));
        }
    }
}