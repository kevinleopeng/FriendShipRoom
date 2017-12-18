package com.fsr.repository;

import com.fsr.domain.Contract;
import com.fsr.domain.Message;

import java.util.Date;
import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
public interface MessageRepository {
    List<Message> getMessagesByPage(Integer offset, Integer perPage);

    Long selectCount();

    Integer insertMessage(Message message);

    Integer updateMessage(Message message);
}
