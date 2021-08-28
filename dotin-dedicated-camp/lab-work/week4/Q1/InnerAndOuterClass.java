package homeworks;

public class InnerAndOuterClass {
    public static void main(String[] args) {
        InnerAndOuterClass outerClass = new InnerAndOuterClass();
        InnerClass innerClass = outerClass.makeObject();
        System.out.println("The inner class name is: " + innerClass.name);
    }
    private class InnerClass {
        String name = "maryam";
    }
    private InnerClass makeObject(){
        InnerClass inner = new InnerClass();
        return inner;
    }
}
