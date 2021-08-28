import java.util.List;

public class GenericMethod {
    int num;

    public <Integer> int integer_ge() {
        return num+3;
    }

    public <E> List listpooya(List<E> p) {
        return p;
    }
}
