import java.lang.reflect.Method;
import java.lang.reflect.Field;
public class ReflectionDemo {
    public static void showClassDetails(Object object) {
        Class<?> cls = object.getClass();

        System.out.println("Class Name: " + cls.getName());

        System.out.println("Fields:");
        for (Field field : cls.getDeclaredFields()) {
            System.out.println("- " + field.getName());
        }

        System.out.println("Methods:");
        for (Method method : cls.getDeclaredMethods()) {
            System.out.println("- " + method.getName());
        }
    }
}
