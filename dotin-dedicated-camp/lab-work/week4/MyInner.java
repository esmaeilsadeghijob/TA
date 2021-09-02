public class MyInner {

        private int player=30;

        // Inner Class
        class Inner{
            void msg(){
                System.out.println("data is "+player);
            }
            int getNum(){
                System.out.println("return num Of Outer Class");
                return player;
            }
      }
}
