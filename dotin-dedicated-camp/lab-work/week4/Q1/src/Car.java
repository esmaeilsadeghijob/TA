import java.util.ArrayList;
import java.util.List;

public class Car {
    private int cots;
    private String model;
    private String color;
    private List<Part> parts;

    public Car(int cots, String model, String color) {
        this.cots = cots;
        this.model = model;
        this.color = color;
        this.parts = new ArrayList<>();

        addPart(new Part(10, "Wheel", 4));
        addPart(new Part(20, "Bumper", 4));
        addPart(new Part(15, "Side mirror", 2));
        addPart(new Part(12, "Chair", 4));
        addPart(new Part(35, "Door", 1));
        addPart(new Part(5, "Steering wheel", 4));
        addPart(new Part(10, "Gear", 1));
    }

    private class Part {
        private int price;
        private String name;
        private int count;

        Part(int price, String name, int count) {
            this.price = price;
            this.name = name;
            this.count = count;
        }

        public int getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }

        public int getCount() {
            return count;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return "Part = { " + "price = " + price + ", name = " + name + ", count = " + count +  " }";
        }
    }

    public void setCots(int cots) {
        this.cots = cots;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private void addPart(Part part) {
        parts.add(part);
    }

    public int getCots() {
        return cots;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public List<Part> getParts() {
        return parts;
    }

    @Override
    public String toString() {
        return "Car = { " + "cots = " + cots + ", model = " + model + ", color = " + color +  " }";
    }

    public static void main(String[] args){
        Car car = new Car(100, "Pride", "White");
        System.out.println(car.toString());
        System.out.println("before change Wheel cost: ");
        Part wheel = null;
        for (Part part : car.getParts()) {
            System.out.println(part.toString());
            if (part.getName().equals("Wheel"))
                wheel = part;
        }

        System.out.println("--------------------------");

        System.out.println("after change Wheel cost: ");
        wheel.setPrice(17);
        for (Part part : car.getParts())
            System.out.println(part.toString());



    }

}