package reflection.domain;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {

    /**
     * 可以创建任意类的对象
     *
     * */
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {

        /**
         * 前提：不能改变任意类的代码，可以创建任意对象，任意方法
         *      用反射实现
         *          实现：
         *              1.配置文件
         *              2.反射
         *          步骤：
         *              1.将需要创建的对象的全类名和需要执行的方法定义在配置文件种
         *                  a)创建properties对象
         *                      Properties pro = new Properties();
         *                  b)获取classlo
         *              2.在程序中加载读取配置文件
         *              3.使用反射技术来加载类文件进内存
         *              4.创建对象
         *              5.执行方法
         *
         * */

        //1.1创建properties对象
        Properties pro = new Properties();

        //1.2加载配置文件，转换为一个集合
        //1.2.1获取class目录下的配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);

        //获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //加载该类进入内存
        Class cla = Class.forName(className);

        //创建对象
        Object obj = cla.newInstance();

        //获取对象方法
        Method method = cla.getMethod(methodName);

        //执行方法
        method.invoke(obj);
    }
}
