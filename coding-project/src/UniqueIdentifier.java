import java.util.Random;

public class UniqueIdentifier{
    private static final Random random = new Random(1);
    public static void main(String[] args) {
        Integer uniqueIdentifier = generateUniqueIdentifier();
        System.out.println("Unique Identifier: " + uniqueIdentifier);
    }

    public static Integer generateUniqueIdentifier() {
        return random.nextInt(900000) + 100000;
    }
}



