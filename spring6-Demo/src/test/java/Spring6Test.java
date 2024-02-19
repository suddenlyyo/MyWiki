import com.zx.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: MyWiki
 * @description:
 * @author: zhou  xun
 * @create: 2024-02-19 18:49
 */
public class Spring6Test {
    @Test
    public void createPerson() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }

}
