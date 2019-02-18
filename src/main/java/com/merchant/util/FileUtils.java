package com.merchant.util;

import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.util.StringUtils;

import java.io.File;

/**
 * @program: merchant-register
 * @description: 文件处理工具
 * @author: Vincent
 * @create: 2019-02-16 09:27
 **/
public class FileUtils {
    private static Logger log = LoggerFactory.getLogger("FileUtils");


    /**
     * 移动已经处理的图片到其他目录
     *
     * @param srcFile    移动的文件
     * @param destFolder 目的目录
     * @return boolean
     * @throws Exception 异常
     */
    public static boolean removeDoneFile(File srcFile, String destFolder) throws Exception {
        String destFilePath = destFolder.substring(0, destFolder.lastIndexOf(File.separator)) + File.separator +
                destFolder.substring(destFolder.lastIndexOf(File.separator) + 1) + "_DONE";
        return moveFile(srcFile, destFilePath);
    }


    /**
     * 移动文件
     *
     * @param srcFile    移动的文件
     * @param destFolder 目的目录
     * @return boolean
     * @throws Exception 异常
     */
    public static boolean moveFile(File srcFile, String destFolder) throws Exception {
        // 检查参数
        Preconditions.checkArgument(srcFile != null && srcFile.exists(), "文件不能为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(destFolder), "目标文件夹路径不能为空");

        String fileName = srcFile.getName();

        File destFile = new File(destFolder);
        if (!destFile.exists()) {
            destFile.mkdirs();
        }

        if (srcFile.renameTo(new File(destFile + File.separator + fileName))) {
            return true;
        } else {
            log.error("移动文件失败：" + srcFile.getAbsolutePath() + ", 目标地址:" + destFolder);
            return false;
        }
    }


    public static void main(String[] args) {
        try {
            String srcFile = "C:\\Users\\Administrator\\Desktop\\新建文件夹\\20190214天津滨海进件资料2\\test\\b+ab(成都远洋太古里店).jpg";
            String destFolder = "C:\\Users\\Administrator\\Desktop\\新建文件夹\\20190214天津滨海进件资料2\\test";
            System.out.println(removeDoneFile(new File(srcFile), destFolder));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
