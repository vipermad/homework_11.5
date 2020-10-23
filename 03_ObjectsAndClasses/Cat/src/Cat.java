
public class Cat {
    private double originWeight;
    private double weight;

    private static final double minWeight = 1000.0;
    private static final double maxWeight = 9000.0;
    private static final int eye = 2;
    private double eatMass;

    private static int count;
    public boolean isAlive;

    public static int getCount() {
        return count;
    }

    public boolean getIsAlive() {
        if (weight > minWeight && weight < maxWeight) {
            isAlive = true;
            return true;
        } else {
            isAlive = false;
            return false;
        }
    }

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        eatMass = 0;
        count = count + 1;
        isAlive = true;
    }

    public void meow() {
        if (getIsAlive()) {
            weight = weight - 1;
            System.out.println("Meow");
            if (!getIsAlive()) {
                count--;
            }
        }
    }

    public void feed(Double amount) {
        if (getIsAlive()) {
            weight = weight + amount;
            eatMass = eatMass + amount;
            if (!getIsAlive()) {
                count--;
            }
        }
    }

    public void drink(Double amount) {
        if (getIsAlive()) {
            weight = weight + amount;
            if (!getIsAlive()) {
                count--;
            }
        }
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < minWeight) {
            return "Dead";
        } else if (weight > maxWeight) {
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
        if (getIsAlive()) {
            weight = weight - weight / 100;
            System.out.println("Я сделал это!");
        } else {
            getStatus();
        }
    }
}