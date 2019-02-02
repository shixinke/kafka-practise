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
            byteArrayOutputStream = new ByteArrayOutputStream();
            outputStream = new ObjectOutputStream(byteArrayOutputStream);
            outputStream.writeObject(object);
            outputStream.flush();
            bytes = byteArrayOutputStream.toByteArray();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
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
            byteArrayInputStream= new ByteArrayInputStream(bytes);
            inputStream = new ObjectInputStream(byteArrayInputStream);
            object = inputStream.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
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

