package se.me0nly.util;
import se.me0nly.model.Gender;
import se.me0nly.model.Person;
import se.me0nly.util.RandomNameService;
import se.me0nly.util.RandomNumberGenerator;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class PersonGenerator {

    private static final se.me0nly.util.PersonGenerator INSTANCE;

    private PersonGenerator() {
    }

    static {
        INSTANCE = new se.me0nly.util.PersonGenerator();
    }

    public static se.me0nly.util.PersonGenerator getInstance() {
        return INSTANCE;
    }

    public List<se.me0nly.model.Person> generate(int amount){
        List<se.me0nly.model.Person> persons = new ArrayList<>();
        for(int i=0 ; i<amount; i++) {
            se.me0nly.model.Gender gender = getRandomGender();
            String firstName;
            String lastName;
            int year;

            if(gender == se.me0nly.model.Gender.FEMALE) {
                firstName = RandomNameService.getInstance().getRandomFemaleFirstName();
            }else {
                firstName = RandomNameService.getInstance().getRandomMaleFirstName();
            }

            lastName = RandomNameService.getInstance().getRandomLastName();

            year = RandomNumberGenerator.getInstance().getRandomInt(1930, 2019);

            persons.add(new Person(firstName, lastName, generateBirthDate(year), gender));
        }
        return persons;

    }

    private LocalDate generateBirthDate(int year){
        return Year.isLeap(year) ?
                LocalDate.ofYearDay(year, RandomNumberGenerator.getInstance().getRandomInt(1,366)) :
                LocalDate.ofYearDay(year, RandomNumberGenerator.getInstance().getRandomInt(1,365));
    }

    private se.me0nly.model.Gender getRandomGender() {
        boolean isFemale = RandomNumberGenerator.getInstance().getRandomBoolean();
        return isFemale ? se.me0nly.model.Gender.FEMALE : Gender.MALE;
    }


}
