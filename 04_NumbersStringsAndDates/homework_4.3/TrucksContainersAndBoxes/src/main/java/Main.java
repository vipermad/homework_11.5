import java.util.Scanner;

public class Main {

  public static final double VOLUME_CONTAINER = 27;
  public static final double VOLUME_TRUCK = 12 * VOLUME_CONTAINER;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int boxes = Integer.parseInt(scanner.nextLine());
    int needTruck = (int) Math.ceil(boxes / VOLUME_TRUCK);
    int needContainer = (int) Math.ceil(boxes / VOLUME_CONTAINER);

    int truck = 0;      // 12 container.
    int container = 0;  // 27 box
    int countBox = 0;        // счетчик коробок
    boolean flagFirstStart = true;
    if (boxes > 0) {
      truck++;
      container++;
      countBox++;
    }
    for (int i = 1; i != boxes+1; i++) {
      if (flagFirstStart){
        System.out.println("Грузовик: " + truck);
        truck++;
        System.out.println("\tКонтейнер: " + container);
        container++;
        flagFirstStart = false;
      }
      if ((i-1) % VOLUME_TRUCK == 0 && i != 1) {
        System.out.println("Грузовик: " + truck);
        truck++;
      }
      if ((i-1) % VOLUME_CONTAINER == 0 && i != 1) {
        System.out.println("\tКонтейнер: " + container);
        container++;
      }
      System.out.println("\t\tЯщик: " + countBox);
      countBox++;
    }

    System.out.println("Необходимо: \nгрузовиков - " + needTruck + " шт." + "\nконтейнеров - " + needContainer + " шт.");

    // TODO: вывести в консоль коробки разложенные по грузовикам и контейнерам
    // пример вывода при вводе 2
    // для отступа используйте табуляцию - \t

        /*
        Грузовик: 1
            Контейнер: 1
                Ящик: 1
                Ящик: 2
        Необходимо:
        грузовиков - 1 шт.
        контейнеров - 1 шт.
        */
  }

}
