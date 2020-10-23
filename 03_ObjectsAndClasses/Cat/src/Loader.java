
public class Loader
{
    public static void main(String[] args)
    {
        Cat cat = new Cat();

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

        //создаем котов используя метод и сразу выводим их вес в консоль
        System.out.println(getKitten("vova").getWeight());
        System.out.println(getKitten("lesli").getWeight());
        System.out.println(getKitten("chelsi").getWeight());

        //Задаем коту цвет и проверяем(выводим его в консоль)
        cat.setCatColor("Black");
        System.out.println(cat.getCatColor());
    }

}
