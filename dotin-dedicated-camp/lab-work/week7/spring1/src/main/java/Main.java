import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("Conf.xml");
        User user=(User) context.getBean("user");
        User userr=(User) context.getBean("user2");
        user.setAge(10);
        user.setName("alii");

        userr.setAge(10);
        userr.setName("hasan");

        System.out.println(user.toString());
        System.out.println(userr.toString());
    }
}
