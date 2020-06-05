package 设计模式_动态代理;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2019/7/5 17:45
 * @description : 文件系统动态代理类
 * @modified By  :
 */
public class FileInvocationHandler implements InvocationHandler {

    private Object obj;

    public FileInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        File log = new File("log.txt");
        if (!log.exists()) {
            log.createNewFile();
        } else {
            Writer writer = new FileWriter(log,true);
            writer.write(method.getName() + ":" + args[0].toString()+"\n");
            writer.flush();
            writer.close();
        }
        result = method.invoke(this.obj, args);
        return result;
    }
}
