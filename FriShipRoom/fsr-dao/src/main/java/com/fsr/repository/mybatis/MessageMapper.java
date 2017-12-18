package com.fsr.repository.mybatis;

import com.fsr.domain.Contract;
import com.fsr.domain.Message;
import com.fsr.repository.ContractRepository;
import com.fsr.repository.MessageRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
@Mapper
public interface MessageMapper extends MessageRepository {
    @Override
    List<Message> getMessagesByPage(@Param("offset") Integer offset, @Param("perPage") Integer perPage);

    @Override
    Long selectCount();

    @Override
    Integer insertMessage(Message message);

    @Override
    Integer updateMessage(Message message);
}
