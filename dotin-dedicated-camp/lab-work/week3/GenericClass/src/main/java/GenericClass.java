
    public class GenericClass <E>{
        E n;
        GenericClass(E c){
            n=c;
        }
        public <E> E niloofar(){
            return (E) n;
        }
    }



