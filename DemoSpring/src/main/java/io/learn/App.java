package io.learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        /*to access the ApplicationContext in the spring [without the boot], we should configure the
        class path.
        the spring.xml is the file where the definition of the bean will be created
        */
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        /*to access the bean in the context object, we use the method getBean.
        And to which class the bean is created will be mention in the brackets.
        Ex: context.getBean(Dev.class) or it will be written as context.getBean("dev")
        here "dev" is the id which we created in the spring.xml
        After creating the bean, it should be type of the class, then it will be converted. Ex: (Dev)
        */

       Dev obj = (Dev) context.getBean("dev");
       //System.out.println(obj.getAge());
       obj.build();

    }
}
