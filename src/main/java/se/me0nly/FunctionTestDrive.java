package se.me0nly;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FunctionTestDrive {

    public static void main(String[] args) {
        getSupplier().get()
                .map(getStringStringFunction())
                .filter(getPredicate())
                .forEach(getConsumer());
    }

    private static Supplier<Stream<String>> getSupplier() {
        return () -> Stream.of("apple", "banana");
    }

    private static Consumer<String> getConsumer() {
        return System.out::println;
    }

    private static Predicate<String> getPredicate() {
        return e -> e.startsWith("A");
    }

    private static Function<String, String> getStringStringFunction() {
        return String::toUpperCase;
    }
}
