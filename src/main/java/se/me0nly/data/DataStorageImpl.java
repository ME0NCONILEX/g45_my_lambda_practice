package se.me0nly.data;
import se.me0nly.data.DataStorage;
import se.me0nly.model.Person;
import se.me0nly.util.PersonGenerator;
import se.me0nly.util.PersonGenerator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Implementations for all methods. *
 */
public class DataStorageImpl implements se.me0nly.data.DataStorage {

    private static final se.me0nly.data.DataStorage INSTANCE;

    static {
        INSTANCE = new se.me0nly.data.DataStorageImpl();
    }

    private final List<Person> personList;

    private DataStorageImpl(){
        personList = PersonGenerator.getInstance().generate(1000);
    }

    static DataStorage getInstance(){
        return INSTANCE;
    }


    @Override
    public List<Person> findMany(Predicate<Person> filter) {
        List<Person> result = new ArrayList<>();
        for(Person person : personList){
            if(filter.test(person)){
                result.add(person);
            }
        }
        return result;
    }

    @Override
    public Person findOne(Predicate<Person> filter) {
        for(Person person : personList)
            if(filter.test(person))
                return person;
        return null;
    }

    @Override
    public String findOneAndMapToString(Predicate<Person> filter, Function<Person, String> personToString){
        Person person = findOne(filter);
        return personToString.apply(person);
    }

    @Override
    public List<String> findManyAndMapEachToString(Predicate<Person> filter, Function<Person, String> personToString){
        List<String> result = new ArrayList<>();
        for(Person person : personList){
            if(filter.test(person)){
                result.add(personToString.apply(person));
            }
        }
        return result;
    }

    @Override
    public void findAndDo(Predicate<Person> filter, Consumer<Person> consumer){
        for(Person person : personList)
            if(filter.test(person))
                consumer.accept(person);
    }

    @Override
    public List<Person> findAndSort(Comparator<Person> comparator){
        List<Person> allPeople = new ArrayList<>(personList);
        allPeople.sort(comparator);
        return allPeople;
    }

    @Override
    public List<Person> findAndSort(Predicate<Person> filter, Comparator<Person> comparator){
        List<Person> list = findMany(filter);
        list.sort(comparator);
        return list;
    }
}
