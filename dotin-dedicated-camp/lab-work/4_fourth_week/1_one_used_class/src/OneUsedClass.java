public class OneUsedClass {
    static class InnerClass{
        public InnerClass() {
        }

        public InnerClass(String string) {
            this.string = string;
        }

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }

        String string;
    }

    public static void main(String[] args) {
        OneUsedClass.InnerClass object = new OneUsedClass.InnerClass("Hello World");
        System.out.println(object.string);
    }
}
