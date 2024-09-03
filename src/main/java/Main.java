public class Main {

    public static void main(String[] args) {

        Race race = new Race();
        System.out.println("Приветствуем Вас на гонке 24 часа Ле-Мана!");
        race.cars.add(race.takeInput("первого"));
        race.cars.add(race.takeInput("второго"));
        race.cars.add(race.takeInput("третьего"));

        System.out.println(race.findWinner());
    }


}

