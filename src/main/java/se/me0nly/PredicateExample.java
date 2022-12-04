package se.me0nly;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateExample {
    static List<se.me0nly.Car> carList = new ArrayList<>();

    public static List<se.me0nly.Car> findBy(Predicate<se.me0nly.Car> parameter) {
        List<se.me0nly.Car> temp = new ArrayList<>();
        for (se.me0nly.Car element : carList) {
            if (parameter.test(element)) {
                temp.add(element);
            }
        }
        return temp;
    }

    public static se.me0nly.Car findOne(Predicate<se.me0nly.Car> parameter) {
        for (se.me0nly.Car element : carList) {
            if (parameter.test(element)) {
                return element;
            }
        }
        return null;
    }

    public static String map(Predicate<se.me0nly.Car> parameter, Function<se.me0nly.Car, String>convert){
        return convert.apply(findOne(parameter));
    }

    public static void main(String[] args) {
        se.me0nly.Car bmw = new se.me0nly.Car("BMW", 56000);
        se.me0nly.Car polestar = new se.me0nly.Car("Polestar", 76900);
        carList.add(bmw);
        carList.add(polestar);
        List<se.me0nly.Car> modelInfo = findBy(car -> car.getModel().equals("BMW"));
        System.out.println(modelInfo);
        List<se.me0nly.Car> priceInfo = findBy(car -> car.getPrice() > 70000);
        System.out.println(priceInfo);
        se.me0nly.Car result =findOne(car -> car.getPrice()<100000);
        System.out.println(result);
    }
}

class Car {
    private final String model;
    private final double price;

    public Car(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
