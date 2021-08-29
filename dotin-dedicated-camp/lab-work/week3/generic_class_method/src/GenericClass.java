public class GenericClass <E> {
    private E num;

    public GenericClass(E num) {
        this.num = num;
    }

    public <E> E getNum() {
        return (E) num;
    }
}
