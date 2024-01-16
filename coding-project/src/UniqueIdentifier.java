import java.util.Random;

public class UniqueIdentifier{
    private static final Random random = new Random(1);

    public static Integer generateUniqueIdentifier() {
        return random.nextInt(500) + 1;
    }
}



