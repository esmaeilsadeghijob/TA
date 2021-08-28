import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyClass {
    private String name;
    private String lastName;
    private int age;
    private String gender;
    private int id;
}
