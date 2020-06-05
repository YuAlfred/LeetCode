package 设计模式_动态代理;

import java.io.File;
import java.io.IOException;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2019/7/5 17:39
 * @description : 文件系统实现类
 * @modified By  :
 */
public class FileManagement implements IFile {


    @Override
    public void createFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }
}
