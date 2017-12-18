package com.fsr.service;

import com.fsr.domain.Message;

import java.util.List;

/**
 * Created by Hasee on 2017/8/29.
 */
public interface MessageService {
    List<Message> getMessagesByPage(Integer offset, Integer perPage);

    Long selectCount();

    Integer getTotalPage(Integer perPage);

    Integer insertMessage(Message message);

    Integer updateMessage(Message message);

    void notify(String message, Integer type);
}
