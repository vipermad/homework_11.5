import com.sun.nio.sctp.SctpSocketOption;

public class Loader {
    private static Cat getKitten(String name)
    {
        return new Cat(name);
    }
    public static void main(String[] args) {
        Cat cat = new Cat();
        Cat barsik = new Cat();
        Cat moris = new Cat();
        Cat kitiket = new Cat();
        Cat tiger = new Cat();
        Cat richard = new Cat();
        Cat leo = new Cat();
        Cat musay = new Cat();
        Cat rich = new Cat(1.0);
        //кормим кошечек
        cat.feed(1000.0);
        barsik.feed(500.0);
        tiger.feed(1500.0);

        //получаем их вес.
        System.out.println("Weight cat: " + cat.getWeight() + " g.");
        System.out.println("Weight barsik: " + barsik.getWeight() + " g.");
        System.out.println("Weight tiger: " + tiger.getWeight() + " g.");

        //перекармливаем кошку до взрыва.
        while (cat.isAlive()) {
            cat.feed(1000.0);
        }
        System.out.println("Cat status: " + cat.getStatus());

        //Замяукаем кошку
        while (barsik.isAlive()) {
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
        //создаем котов используя метод и сразу выводим их вес в консоль
        System.out.println(getKitten("vova").getWeight());
        System.out.println(getKitten("lesli").getWeight());
        System.out.println(getKitten("chelsi").getWeight());
        System.out.println(rich.getWeight());
        //Задаем коту цвет и проверяем(выводим его в консоль)
        cat.setCatColor(CatColor.FOXY);
        System.out.println(cat.getCatColor());

        //Проверяем работу копирования кота.
        System.out.println(cat.getWeight());
        Cat vasya = cat.makeTwin();
        System.out.println(cat.getWeight());
        System.out.println(vasya.getWeight());


    }

}
