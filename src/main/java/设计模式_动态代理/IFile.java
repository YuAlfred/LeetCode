package 设计模式_动态代理;

/**
 * @author : ty
 * @version : 1.0.0
 * @date : Created in 2019/7/5 17:37
 * @description : 文件管理器接口
 * @modified By  :
 */
public interface IFile {

    /**
     * 创建文件
     *
     * @param fileName 文件名
     */
    void createFile(String fileName);

    /**
     * 删除文件文件
     *
     * @param fileName 文件名
     */
    void deleteFile(String fileName);
}
