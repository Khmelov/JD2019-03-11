package by.it.vashkevich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> math = Math.class;
        Method[] methods = math.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                StringBuilder name = new StringBuilder("public ");
                if (Modifier.isStatic(modifiers))
                    name.append("static ");
                String returnTypeName = method.getReturnType().getSimpleName();
                name.append(returnTypeName).append(' ');
                name.append(method.getName()).append('(');
                Class<?>[] paramTypes = method.getParameterTypes();
                for (int i = 0; i < paramTypes.length; i++) {
                    if (i > 0) name.append(',');
                    name.append(paramTypes[i].getSimpleName());
                }
                name.append(')');
                System.out.println(name);
            }
        }
        System.out.println("double E");
        System.out.println("double PI");
    }
}
