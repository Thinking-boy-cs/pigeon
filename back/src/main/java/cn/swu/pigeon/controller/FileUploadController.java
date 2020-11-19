package cn.swu.pigeon.controller;

import cn.swu.pigeon.entity.Upload;
import cn.swu.pigeon.entity.User;
import cn.swu.pigeon.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.security.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//import static java.lang.System.currentTimeMillis;

@RestController
@CrossOrigin //允许跨域
@RequestMapping("upload")
@Slf4j

public class FileUploadController {
    @Autowired
    private UploadService uploadService;

    /**
     * 文件上传
     *
     * @param multipartFile
     */
    @PostMapping("fileUp")
    public Map<String,Object> saveUpload(Upload upload,MultipartFile multipartFile,HttpServletRequest request) {

        log.info("当前file：[{}]",upload.toString());
        //获取当前用户对象
        User thisUser = (User) request.getServletContext().getAttribute("thisUser");
        Map<String, Object> map = new HashMap<>();
        if(multipartFile.isEmpty())

        {
            map.put("status", -1);
            map.put("msg", "Empty file");
            return map;
        }

        // 将文件对象 multipartFile中的文件流上传到服务器
        // 获取文件的服务器的保存路径
        System.out.println("basepath:" + System.getProperty("server.basePath"));
        // 当前项目在web服务器上的部署的绝对路径
        String serverBasePath = System.getProperty("server.basePath");
        // 设置服务器的保存文件的路径名
        String serverFileSavePath = "uploadfiles/userimgfiles/";
        // 完整的服务器保存路径为 serverBasePath+ serverFileSavePath
        String serverSavePath = serverBasePath + serverFileSavePath;
        // 验证服务器是否已经创建了该目录
        File fileSave = new File(serverSavePath);
        // 判断保存路径文件对象是否存在
        if (!fileSave.exists()) {
            // 创建该目录
            fileSave.mkdirs();
        }
        // 文件需要在服务器上进行重命名，然后进行保存
        // 命名规则： 前缀+系统时间毫秒数+文件后缀
        // 获取文件类型
        String fileContentType = multipartFile.getContentType();
        // 获取文件后缀
        String fileType = fileContentType.substring(fileContentType.indexOf("/") + 1);
        // 文件名前缀
        String fileNamePrefix = "userimg";
        // 生成新的文件名
        String fileNewName = fileNamePrefix + System.currentTimeMillis() + "." + fileType;
        System.out.println("新文件名：" + fileNewName);

        // 将文件流写出到服务器保存路径
        try {
            multipartFile.transferTo(new File(serverSavePath + fileNewName));
        } catch (IOException e) {
            System.out.println("文件上传异常：" + e.getMessage());
            e.printStackTrace();

            map.put("status", -1);
            map.put("msg", "Empty file");
            return map;
        }
        // 需要保存的文件的访问路径
        String fileRelativePath = serverFileSavePath + fileNewName;
        System.out.println("文件的访问路径：" + fileRelativePath);
        // 将文件对象的访问路径映射给实体类对象的成员属性上
//        customer.setImgPath(fileRelativePath);
        upload.setImgPath(fileRelativePath);
        upload.setUsername(thisUser.getUsername());
        // 使用反射，将设置属性的方法具有通用性
        // 提取需要保存的属性名
        /*String propertyName = multipartFile.getName().replace("file_", "");
        try {
            BeanUtils.setProperty(upload, propertyName, fileRelativePath);
        } catch (Exception e) {
            System.out.println("文件上传异常：" + e.getMessage());
            e.printStackTrace();
        }*/
        // 调用Service层进行用户信息数据保存和修改操作
        try{

            uploadService.saveFile(upload);
            map.put("status",0);
            map.put("msg","Success to write file path");
        }catch (Exception e){
            e.printStackTrace();
            map.put("status",-1);
            map.put("msg","Fail to write file path");
        }
//        uploadService.saveFile(upload);
        // 根据操作结果进行视图转发处理
        return map;

    }

}
