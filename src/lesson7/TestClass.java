package lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestClass {

    public static void start(Class c) throws RuntimeException {
        Method[] methods = c.getDeclaredMethods();

        List<Method> mList = new ArrayList<>();

        for (Method m : methods) {
            if(m.isAnnotationPresent(Test.class)){
                mList.add(m);
            }
        }

        mList.sort(Comparator.comparingInt(method -> method.getAnnotation(Test.class).priority()));
        Collections.reverse(mList);


        for (Method m : methods) {

            if(!m.isAnnotationPresent(BeforeSuite.class)){
                continue;
            }

            if (!mList.isEmpty() && mList.get(0).isAnnotationPresent(BeforeSuite.class)) {
                throw new RuntimeException("BeforeSuite can't be more than 1");
            }

            mList.add(0, m);
        }

        for (Method m : methods) {

            if(!m.isAnnotationPresent(AfterSuite.class)){
                continue;
            }

            if (!mList.isEmpty() && mList.get(mList.size() - 1).isAnnotationPresent(AfterSuite.class)) {
                throw new RuntimeException("AfterSuite can't be more than 1");
            }

            mList.add(m);
        }

        for (Method method : mList) {
            try {
                method.invoke(null);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }
}
