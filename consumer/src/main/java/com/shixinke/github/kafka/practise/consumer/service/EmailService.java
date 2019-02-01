package com.shixinke.github.kafka.practise.consumer.service;

/**
 * @author shixinke
 * @version 1.0
 * @Description
 * @Date 19-2-1 下午5:00
 */
public interface EmailService {
    /**
     * 发送邮件
     * @param receiver
     * @param receiverEmail
     * @param title
     * @param content
     * @param sender
     * @param senderEmail
     * @return
     */
    public int send(String receiver, String receiverEmail,  String title, String content, String sender, String senderEmail);
}
