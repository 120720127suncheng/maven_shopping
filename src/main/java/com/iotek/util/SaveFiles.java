package com.iotek.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;

/**
 * com.iotek.util
 *
 * @author <Author Administrator>
 * @date 2018/3/19 13:54
 */
public class SaveFiles {
    public static String saveFile(MultipartFile filedata, HttpServletRequest request) {
        // 根据配置文件获取服务器图片存放路径,request一开始想获得配置的路径，后来没用到，忘记改了
        String newFileName = String.valueOf(System.currentTimeMillis());
        String saveFilePath = "D:/images";
        /* 构建文件目录 */
        File fileDir = new File(saveFilePath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        //上传的文件名
        String filename = filedata.getOriginalFilename();
        //文件的扩张名
        String extensionName = filename.substring(filename.lastIndexOf(".") + 1);
        try {
            String imgPath =  saveFilePath+"/"+newFileName + "." + extensionName;
            //System.out.println(pathval + imgPath);打印图片位置
            FileOutputStream out = new FileOutputStream(imgPath);
            // 写入文件
            out.write(filedata.getBytes());
            out.flush();
            out.close();
            /*返回存储的位置,看你自己想存哪*/
            return imgPath;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void deleteFile(String oldPic) {
        /* 构建文件目录 */
        File fileDir = new File(oldPic);
        if (fileDir.exists()) {
            //把修改之前的图片删除 以免太多没用的图片占据空间
            fileDir.delete();
        }

    }
}