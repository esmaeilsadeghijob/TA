public class Car2 {

        public int size;
        public String color;
        static int count = 0;


        public static void main(String[] args) {

            Car2 pride = new Car2();
            count++;
            Car2 benz = new Car2();
            count++;
            Car2 bmw = new Car2();
            count++;
            System.out.println(count);

        }

    }

