package se.me0nly.util;
import java.util.Random;

public class RandomNumberGenerator {

    private static final se.me0nly.util.RandomNumberGenerator INSTANCE;

    static {
        INSTANCE = new se.me0nly.util.RandomNumberGenerator();
    }

    private RandomNumberGenerator() {}

    public static se.me0nly.util.RandomNumberGenerator getInstance() {
        return INSTANCE;
    }

    private static final Random rng = new Random();

    public int getRandomInt(int min, int max) {
        return rng.nextInt((max-min) + 1) + min;
    }

    public boolean getRandomBoolean() {
        return rng.nextBoolean();
    }

}
