
public class Tamrin1 {

static String name;

    public static void setName(String name) {
        Tamrin1.name = name;
    }

    public static void saybye(){
    System.out.println("bye forever");
}
static class inner{
    String Heloo= name + " khosh omadi";
    public void sayhelloo(){
        System.out.println(this.Heloo);

    }

}
    public static void main(String[] args) {
     setName("niloofar");
     inner inner1 = new inner();
     inner1.sayhelloo();
     Tamrin1.saybye();

    }

}
