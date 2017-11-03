import java.lang.annotation.*;
import java.lang.reflect.Field;
/**
 * Created by Velik Georgiev on 11/3/2017.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface InstanceRegister { }

public class LTPExample {

    @InstanceRegister
    private LTPExample example;

    @InstanceRegister
    private String stringTest;

    public LTPExample() {
        get(LTPExample.class);
    }

    public static void get(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field: fields) {
            Annotation[] annotation = field.getDeclaredAnnotations();

            for (Annotation current: annotation) {
                if (current.annotationType().getSimpleName().equals("InstanceRegister")) {
                    System.out.println("Instance Of: " + field.getType().getSimpleName());
                    System.out.println("Variable Name: " + field.getName());
                    System.out.println("----------------------------------");
                }
            }
        }
    }

    public static void main(String[] args) {
        new LTPExample();
    }
}
