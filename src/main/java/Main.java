public class Main {

    public static void main(String[] args) {

        Race race = new Race();
        System.out.println("Приветствуем Вас на гонке 24 часа Ле-Мана!");
        race.takeInput("первого");
        race.takeInput("второго");
        race.takeInput("третьего");

        System.out.println(race.findWinner());
    }
}

