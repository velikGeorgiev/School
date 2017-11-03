import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Velik Georgiev on 11/3/2017.
 */

public class LTPExample {
    public String name;

    public  LTPExample(String name) {
        this.name = name;

        InstanceRegister.append(LTPExample.class, this);
    }

    public static void main(String[] args) {
        LTPExample example1 = new LTPExample("ex1");
        LTPExample example2 = new LTPExample("ex2");
        LTPExample example3 = new LTPExample("ex3");

        InstanceRegister.getInstances(LTPExample.class).forEach(v -> {
            System.out.println(((LTPExample) v).name);
        });
    }
}

class InstanceRegister {
    private final static HashMap<String, ArrayList<Object>> instancesRegistry = new HashMap<>();

    public static void append(Class<?> clazz, final Object instance) {
        String className = clazz.getClass().getName();
        ArrayList<Object> container;

        if (instancesRegistry.containsKey(className)) {
            container = instancesRegistry.get(className);
            container.add(instance);
        } else {
            container = new ArrayList<Object>() {{ add(instance); }};
            instancesRegistry.put(className, container);
        }
    }

    public static ArrayList<Object> getInstances(Class<?> clazz) {
        String className = clazz.getClass().getName();

        if (!instancesRegistry.containsKey(className)) {
            return null;
        }

        return instancesRegistry.get(className);
    }

    public static void clearRegistry() {
        instancesRegistry.clear();
    }
}
