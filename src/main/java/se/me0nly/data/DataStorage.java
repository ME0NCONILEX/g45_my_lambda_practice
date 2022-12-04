package se.me0nly.data;
import se.me0nly.data.DataStorageImpl;
import se.me0nly.model.Person;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface DataStorage {

    se.me0nly.data.DataStorage INSTANCE = DataStorageImpl.getInstance();

    List<Person> findMany(Predicate<Person> filter);
    Person findOne(Predicate<Person> filter);


    String findOneAndMapToString(Predicate<Person> filter, Function<Person, String> personToString);

    List<String> findManyAndMapEachToString(Predicate<Person> filter, Function<Person, String> personToString);

    void findAndDo(Predicate<Person> filter, Consumer<Person> consumer);

    List<Person> findAndSort(Comparator<Person> comparator);

    List<Person> findAndSort(Predicate<Person> filter, Comparator<Person> comparator);
}
