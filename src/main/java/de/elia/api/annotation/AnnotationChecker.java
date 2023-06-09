package de.elia.api.annotation;

import de.elia.api.Main;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;

public class AnnotationChecker {

    public static void processAnnotations(@NotNull Object object) {
        Class<?> clazz = object.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Planned.class)) {
                Planned annotation = method.getAnnotation(Planned.class);
                Main.logger().warning("This class has the annotation Planned! This means that the function used can still have errors!");
            }else if (method.isAnnotationPresent(Beta.class)) {
                Beta annotation = method.getAnnotation(Beta.class);
                Main.logger().warning("This class has the annotation Beta! This means that the function used can still have bugs or is still unstable");
            }
        }
    }

    public static void processAnnotations(@NotNull Class<?> clazz) {
        if (clazz.isAnnotationPresent(Planned.class)) {
            Planned annotation = clazz.getAnnotation(Planned.class);
            Main.logger().warning("This class has the annotation Planned! This means that the function used can still have errors!");
        }else if (clazz.isAnnotationPresent(Beta.class)) {
            Beta annotation = clazz.getAnnotation(Beta.class);
            Main.logger().warning("This class has the annotation Beta! This means that the function used can still have bugs or is still unstable");
        }
    }

}
