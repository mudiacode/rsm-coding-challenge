// java.util package to create random numbers
import java.util.Random;

// Class for unique identifier used for officeNumber
public class UniqueIdentifier{
    // create random number with seed so number stays the same if program is reset
    private static final Random random = new Random(1);

   // random number from 1 to 500
    public static Integer generateUniqueIdentifier() {
        return random.nextInt(500) + 1;
    }
}



