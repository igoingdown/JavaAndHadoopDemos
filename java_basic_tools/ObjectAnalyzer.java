package java_basic_tools;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * Created by zhaomingxing on 2016/12/25.
 */

public class ObjectAnalyzer {
    public String toString(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (visited.contains(obj)) {
            return "...";
        }
        visited.add(obj);
        Class cl = obj.getClass();
        // 处理obj为String对象的情况(这种情况不必进行后面的循环处理)
        if (cl == String.class) {
            return (String) obj;
        }
        // 处理obj为数组对象的情况。
        if (cl.isArray()) {
            String r = cl.getComponentType() + "[]{";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i > 0) {
                    r += ",";
                }
                Object val = Array.get(obj, i);
                if (cl.getComponentType().isPrimitive()) {
                    r += val;
                }
                else {
                    r += toString(val);
                }
            }
            return r;
        }
        // 处理对象为多重继承的情况
        String r = cl.getName();
        do {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);

            for (Field f: fields) {
                if (! Modifier.isStatic(f.getModifiers())) {
                    if (! r.endsWith("[")) {
                        r += ", ";
                    }
                    r += f.getName() + "=";
                    try {
                        Object val = f.get(obj);
                        if (f.getType().isPrimitive()) {
                            r += val;
                        } else {
                            r += toString(val);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
            r += "]";
            cl = cl.getSuperclass();
        }
        while (cl != Object.class);
        return r;
    }

    private ArrayList<Object> visited = new ArrayList<Object>();
}
