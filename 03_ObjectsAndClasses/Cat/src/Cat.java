
public class Cat {
    private double originWeight;
    private double weight;
    private String name;

    public static final double MIN_WEIGHT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;
    public static final int EYE = 2;
    private CatColor catColor;
    private double eatMass;

    private static int count;

    public CatColor getCatColor() {
        return catColor;
    }

    public void setCatColor(CatColor catColor) {
        this.catColor = catColor;
    }

    public static int getCount() {
        return count;
    }

    public boolean isAlive() {
        return weight > MIN_WEIGHT && weight < MAX_WEIGHT;
    }

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        eatMass = 0;
        count = count + 1;
    }

    public Cat(double weight) {
        this();
        this.weight = weight;
        if (!isAlive()) {
            System.out.println("Вес кошки не может быть меньше минимального: " + MIN_WEIGHT +
                    " или больше максимального: " + MAX_WEIGHT);
            count = count - 1;
        }
    }

    public Cat(String name) {
        this();
        this.name = name;
    }

    public Cat(String name, double weight) {
        this();
        this.name = name;
        this.weight = weight;
    }

    public void meow() {
        if (isAlive()) {
            weight = weight - 1;
            System.out.println("Meow");
            if (!isAlive()) {
                count--;
            }
        }
    }

    public void feed(Double amount) {
        if (isAlive()) {
            weight = weight + amount;
            eatMass = eatMass + amount;
            if (!isAlive()) {
                count--;
            }
        }
    }

    public void drink(Double amount) {
        if (isAlive()) {
            weight = weight + amount;
            if (!isAlive()) {
                count--;
            }
        }
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < MIN_WEIGHT) {
            return "Dead";
        } else if (weight > MAX_WEIGHT) {
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }

    public Double getEatMass() {
        return eatMass;
    }

    public void pee() {
        if (isAlive()) {
            weight = weight - weight / 100;
            System.out.println("Я сделал это!");
        } else {
            getStatus();
        }
    }
}