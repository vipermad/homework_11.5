import org.w3c.dom.ls.LSOutput;

//homework done
public class Loader {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Cat barsik = new Cat();
        Cat moris = new Cat();
        Cat kitiket = new Cat();
        Cat tiger = new Cat();
        Cat richard = new Cat();
        Cat leo = new Cat();
        Cat musay = new Cat();

        //кормим кошечек
        cat.feed(1000.0);
        barsik.feed(500.0);
        tiger.feed(1500.0);

        //получаем их вес.
        System.out.println("Weight cat: " + cat.getWeight() + " g.");
        System.out.println("Weight barsik: " + barsik.getWeight() + " g.");
        System.out.println("Weight tiger: " + tiger.getWeight() + " g.");

        //перекармливаем кошку до взрыва.
        while (cat.isAlive) {
            cat.feed(1000.0);
        }
        System.out.println("Cat status: " + cat.getStatus());

        //Замяукаем кошку
        while (barsik.isAlive) {
            barsik.meow();
        }
        System.out.println("Barsik status: " + barsik.getStatus());

        //проверяем работу метода "сходить в туалет" в комплексе с массой съеденной еды.
        leo.feed(150.0);
        leo.pee();
        leo.pee();
        leo.pee();
        System.out.println(leo.getEatMass());

        //проверяем количество оставшихся в живых кошек
        System.out.println("В живых осталось только: " + Cat.getCount() + " котов");
    }

}
