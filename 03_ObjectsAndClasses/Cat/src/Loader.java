import org.w3c.dom.ls.LSOutput;

public class Loader
{
    public static void main(String[] args)
    {
        Cat cat = new Cat();
        Cat barsik = new Cat();
        Cat moris = new Cat();
        Cat kitiket = new Cat();
        Cat tiger = new Cat();
        Cat richard = new Cat();
        Cat leo = new Cat();

        //кормим кошечек
        cat.feed(1000.0);
        barsik.feed(500.0);
        tiger.feed(1500.0);

        //получаем их вес.
        System.out.println("Weight cat: " + cat.getWeight() + " g.");
        System.out.println("Weight barsik: " + barsik.getWeight() + " g.");
        System.out.println("Weight tiger: " + tiger.getWeight() + " g.");

        //перекармливаем кошку до взрыва.
        while(cat.getStatus() != "Exploded")
        {
            cat.feed(1000.0);
            }
        System.out.println("Cat status: "+ cat.getStatus());

        //Замяукаем кошку
        while (barsik.getStatus() != "Dead")
        {
            barsik.meow();
            }
        System.out.println("Barsik status: " + barsik.getStatus());

        }

    }
