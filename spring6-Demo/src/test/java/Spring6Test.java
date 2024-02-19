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

//    构造器注入 适用于必需的、不可变的依赖，以及当你想在创建对象时立即设置其状态时。
//    Setter 注入 适用于可选的、可变的依赖，以及当你需要在对象生命周期中的不同时间点注入依赖时。
//    字段注入 是一种简洁的方式，但可能会导致代码的可读性和可维护性降低。它通常不推荐用于复杂的依赖注入场景。

    @Test
    public void createPerson() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }

}
