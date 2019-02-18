package com.merchant.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.MimetypesFileTypeMap;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description: 模拟表单上传文件
 * @Author: Vincent
 * @Date: 2019/2/16
 */
public class FileUploadHandler {
    private static Logger log = LoggerFactory.getLogger("FileUploadHandler");

    /**
     * 上传图片
     *
     * @param filePath 图片地址
     * @param urlStr   上传URL
     * @return String
     */
    public static String uplad(String filePath, String urlStr) {
        Map<String, String> textMap = new HashMap<>();
        textMap.put("name", "testname");
        Map<String, String> fileMap = new HashMap<>();
        fileMap.put("file", filePath);
        String uploadResult = formUpload(urlStr, textMap, fileMap);

        log.info("上传图片返回结果=" + uploadResult);
        return uploadResult;
    }

    /**
     * 上传图片
     *
     * @param urlStr  上传地址
     * @param textMap 参数
     * @param fileMap 文件
     * @return String
     */
    public static String formUpload(String urlStr, Map<String, String> textMap,
                                    Map<String, String> fileMap) {
        String res = "";
        HttpURLConnection conn = null;
        String BOUNDARY = "---------------------------123821742118716"; //boundary就是request头和上传文件内容的分隔符
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

            OutputStream out = new DataOutputStream(conn.getOutputStream());

            // 文本
            if (textMap != null) {
                StringBuffer strBuf = new StringBuffer();
                Iterator iterator = textMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry) iterator.next();
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                    strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"\r\n\r\n");
                    strBuf.append(inputValue);
                }
                out.write(strBuf.toString().getBytes());
            }

            // 文件
            if (fileMap != null) {
                Iterator fileIterator = fileMap.entrySet().iterator();
                while (fileIterator.hasNext()) {
                    Map.Entry entry = (Map.Entry) fileIterator.next();
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    File file = new File(inputValue);
                    String filename = file.getName();
                    String contentType = new MimetypesFileTypeMap()
                            .getContentType(file);
                    if (filename.endsWith(".png")) {
                        contentType = "image/png";
                    }
                    if (contentType == null || contentType.equals("")) {
                        contentType = "application/octet-stream";
                    }
                    StringBuffer strBuf = new StringBuffer();
                    strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                    strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"; filename=\"" + filename + "\"\r\n");
                    strBuf.append("Content-Type:" + contentType + "\r\n\r\n");

                    out.write(strBuf.toString().getBytes());
                    DataInputStream in = new DataInputStream(new FileInputStream(file));
                    int bytes = 0;
                    byte[] bufferOut = new byte[1024];
                    while ((bytes = in.read(bufferOut)) != -1) {
                        out.write(bufferOut, 0, bytes);
                    }
                    in.close();
                }
            }

            byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
            out.write(endData);
            out.flush();
            out.close();

            // 读取返回数据
            StringBuffer strBuf = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                strBuf.append(line).append("\n");
            }
            res = strBuf.toString();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("上传图片异常=" + e.getMessage());
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Administrator\\Desktop\\滨农进件资料\\张旭良 二类卡\\3.jpg";
        String urlStr = "http://www.ruishengglass.cn//api-v1-user/upload.html";

        uplad(filePath, urlStr);
    }


}
