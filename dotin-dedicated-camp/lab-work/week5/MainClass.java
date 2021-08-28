public class MainClass {
    public static void main(String[] args) {
        MyClass myClass = new MyClass("anahita","makvandi",22,"female",1);
        myClass.setAge(20);
        System.out.println(myClass.getAge());
        System.out.println(MyClass.builder().gender("binary").age(54).name("james").build());
    }
}
