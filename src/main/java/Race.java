import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Race {

    Scanner scanner = new Scanner(System.in);
    ArrayList<Car> cars = new ArrayList<>();

    public Car takeInput(String carNum) {
        System.out.printf("Введите через пробел имя и скорость %s автомобиля. Обращаем внимание, что скорость не может быть меньше 1 и больше 250.%n", carNum);
        String[] input = scanner.nextLine().split(" ");
        if (!checkSpeed(input[1])) {
            System.out.println("Введена неверная скорость, повторите ввод");
            takeInput(carNum);
        }
        return new Car(input[0], Integer.parseInt(input[1]));
    }

    public static boolean checkSpeed(String speed) {
        return Integer.parseInt(speed) > 0 && Integer.parseInt(speed) <= 250;
    }

    public String findWinner() {
        cars.sort(Comparator.comparing(car -> car.speed * 24));
        return String.format("Победителем стал автомобиль %s, проехав %d километров", cars.get(2).name, cars.get(2).speed * 24);
    }

}
