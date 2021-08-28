public class MyMain {
    public static void main(String[] args) {
        Airplane airplane1 = new UltralightAirplane();
        airplane1.landing();
        airplane1.fly();

        Airplane airplane2 = new AirBus();
        airplane2.fly();
        airplane2.landing();

    }
}
