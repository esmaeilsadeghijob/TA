public class GenericClass <E>{
    E e;
    GenericClass(E c){
        e=c;
    }
    public <E> E pooya(){
        return (E) e;
    }
}
