import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Race {

    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<Car> cars = new ArrayList<>();

    public void takeInput(String carNum) {

        System.out.printf("Введите через пробел имя и скорость %s автомобиля. Обращаем внимание, что скорость не может быть меньше 1 и больше 250.%n", carNum);
        String[] input = scanner.nextLine().trim().split(" ");
        if (input.length != 2) { // проверка правильности ввода через пробел
            System.out.println("Не соблюден формат ввода, повторите ввод.");
            takeInput(carNum);
            return; // чтобы после отработки рекурсивного вызова метод не продолжал работу
        }
        while (!checkSpeed(input[1])) {
            System.out.printf("Введите через пробел имя и скорость %s автомобиля. Обращаем внимание, что скорость не может быть меньше 1 и больше 250.%n", carNum);
            input = scanner.nextLine().split(" ");
        }
        cars.add(new Car(input[0], Integer.parseInt(input[1]))); // фактический сеттер для cars
    }

    public static boolean checkSpeed(String speed) {
        if (!(speed.matches("\\d+"))) {
            System.out.println("Для ввода скорости можно использовать только цифры от 0 до 9");
            return false;
        } else if (!(Integer.parseInt(speed) > 0) || !(Integer.parseInt(speed) <= 250)) {
            System.out.println("Введена недопустимая скорость, повторите ввод");
            return false;
        }
        return true;
    }

    public String findWinner() {
        cars.sort(Comparator.comparing(car -> car.getSpeed() * 24));
        return String.format("Победителем стал автомобиль %s, проехав %d километров", cars.get(2).getName(), cars.get(2).getSpeed() * 24);
    }
}
