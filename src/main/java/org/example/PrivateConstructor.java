package org.example;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class PrivateConstructor {
    private String id = "123";
    private String name = "A";

    private PrivateConstructor() {
    }

    @Override
    public String toString() {
        return "A{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        try {
            Constructor<PrivateConstructor> constructor = PrivateConstructor.class.getDeclaredConstructor();
            constructor.setAccessible(true);

            PrivateConstructor privateConstructor = constructor.newInstance();

            Field idField = PrivateConstructor.class.getDeclaredField("id");
            Field nameField = PrivateConstructor.class.getDeclaredField("name");

            idField.setAccessible(true);
            nameField.setAccessible(true);

            idField.set(privateConstructor, "456");
            nameField.set(privateConstructor, "B");

            System.out.println(privateConstructor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
