import java.util.List;

public class GenericMethod{
    private int num;

    public GenericMethod(int num) {
        this.num = num;
    }

    public <E> int getNumber() {
        return num;
    }

    public <E> List listBack(List<E> list) {
        return list;
    }

}
