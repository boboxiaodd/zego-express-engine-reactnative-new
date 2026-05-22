package im.zego.reactnative;

import android.content.Context;
import java.lang.reflect.Field;

public class BuildConfigReader {
    public static Object getBuildConfigValue(Context context, String fieldName) {
        try {
            // 1. 获取宿主 App 的完整类名：包名.BuildConfig
            String className = context.getPackageName() + ".BuildConfig";
            // 2. 加载该类
            Class<?> clazz = Class.forName(className);
            // 3. 获取目标字段
            Field field = clazz.getField(fieldName);
            // 4. 读取静态字段的值并返回
            return field.get(null);
        } catch (ClassNotFoundException e) {
            // 处理类未找到异常
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // 处理字段未找到异常
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // 处理字段访问异常
            e.printStackTrace();
        }
        return null;
    }
}