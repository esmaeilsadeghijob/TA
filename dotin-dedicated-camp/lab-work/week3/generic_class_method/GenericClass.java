package TA04mapsa;

public class GenericClass<E> {
    private E e;
    public GenericClass(E e){
        this.e = e;
    }
    public <E> E returnGenericType(){
        System.out.println("returning generic type:");
        return (E) e;
    }
}
