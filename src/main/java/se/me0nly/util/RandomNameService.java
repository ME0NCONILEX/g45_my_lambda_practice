package se.me0nly.util;
import se.me0nly.data.CSVReader;
import se.me0nly.util.RandomNumberGenerator;

import java.util.List;

public class RandomNameService {

    private static final se.me0nly.util.RandomNameService INSTANCE;

    static {
        INSTANCE = new se.me0nly.util.RandomNameService();
    }

    public static se.me0nly.util.RandomNameService getInstance() {
        return INSTANCE;
    }

    private final List<String> maleFirstNames;
    private final List<String> femaleFirstNames;
    private final List<String> lastNames;

    private RandomNameService() {
        maleFirstNames = CSVReader.getInstance().getMaleFirstNames();
        femaleFirstNames = CSVReader.getInstance().getFemaleFirstNames();
        lastNames = CSVReader.getInstance().getLastNames();
    }

    public String getRandomMaleFirstName() {
        return maleFirstNames.get(se.me0nly.util.RandomNumberGenerator.getInstance().getRandomInt(0, maleFirstNames.size()-1));
    }

    public String getRandomFemaleFirstName() {
        return femaleFirstNames.get(se.me0nly.util.RandomNumberGenerator.getInstance().getRandomInt(0, femaleFirstNames.size()-1));
    }

    public String getRandomLastName() {
        return lastNames.get(RandomNumberGenerator.getInstance().getRandomInt(0, lastNames.size()-1));
    }



}
