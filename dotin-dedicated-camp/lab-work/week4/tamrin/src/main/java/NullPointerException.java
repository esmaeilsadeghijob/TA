public class NullPointerException {
    public static void main(String[] args) {
        String name1="nilofar azizi";
        String name2=null;
        String name3="sara";
        try {
          Length(name1);
          Length(name2);

        }catch (java.lang.NullPointerException e){
            System.out.println("null ast ");

        }
      Length(name3);

    }
    public static void Length(String n){
        System.out.println("length is "+ "   "+ n + n.length());

    }
}
