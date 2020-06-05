package 设计模式_动态代理;

import java.lang.reflect.Proxy;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2019/7/5 17:50
 * @description : 文件管理系统客户端
 * @modified By  :
 */
public class Client {

    public static void main(String[] args) {
        IFile fileManagement = new FileManagement();
        FileInvocationHandler inv = new FileInvocationHandler(fileManagement);
        Class<?>[] cls = new Class[]{IFile.class};
        IFile fileProxy = (IFile) Proxy
                .newProxyInstance(fileManagement.getClass().getClassLoader(), cls, inv);
        fileProxy.createFile("file1.txt");
        fileProxy.createFile("file2.txt");
        fileProxy.createFile("file3.txt");
        fileProxy.createFile("file4.txt");
        fileProxy.deleteFile("file1.txt");
        fileProxy.deleteFile("file2.txt");
    }

}
