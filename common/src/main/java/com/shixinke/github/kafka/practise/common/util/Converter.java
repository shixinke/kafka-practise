package com.shixinke.github.kafka.practise.common.util;

import java.io.*;

/**
 * @author shixinke
 * @version 1.0
 * @Description
 * @Date 19-2-1 下午3:02
 */
public class Converter {

    /**
     * bean转化为byte数组
     * @param object
     * @return
     */
    public static byte[] bean2ByteArray(Object object) {
        byte[] bytes = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            /**
             * 1.定义字节数组输出流和对象输出流
             */
            byteArrayOutputStream = new ByteArrayOutputStream();
            outputStream = new ObjectOutputStream(byteArrayOutputStream);
            /**
             * 2.将对象写入输出流中
             */
            outputStream.writeObject(object);
            outputStream.flush();
            /**
             * 3.字节数组输出流转化为字节数组
             */
            bytes = byteArrayOutputStream.toByteArray();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            /**
             * 4.关闭流,释放资源
             */
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bytes;
    }

    /**
     * byte数组转化为bean
     * @param bytes
     * @return
     */
    public static Object byteArray2Bean(byte[] bytes) {
        Object object = null;
        ByteArrayInputStream byteArrayInputStream = null;
        ObjectInputStream inputStream = null;
        try {
            /**
             * 1.定义字节数组输入流
             */
            byteArrayInputStream= new ByteArrayInputStream(bytes);
            /**
             * 2.定义输入流
             */
            inputStream = new ObjectInputStream(byteArrayInputStream);
            /**
             * 3.从输入流中读取对象数据
             */
            object = inputStream.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            /**
             * 4.关闭流,释放资源
             */
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return object;
    }
}

