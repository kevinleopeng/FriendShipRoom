package com.fsr.datatransfer;

import com.fsr.domain.Message;
import com.fsr.dto.MessageDTO;
import com.fsr.util.DateUtil;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Hasee on 2017/5/11.
 */
@Service("messageDataTransfer")
public class MessageDataTransfer implements DataTransfer<Message, MessageDTO> {
    @Override
    public Collection<MessageDTO> transfer(Collection<Message> list, Object... objs) {
        List<MessageDTO> dtoList = new ArrayList();

        if (null != list && list.size() > 0) {
            Field[] messageDtoFields = MessageDTO.class.getDeclaredFields();

            for (Message message: list) {
                MessageDTO messageDTO = new MessageDTO();
               Field[] messageFields = message.getClass().getDeclaredFields();
               for (Field field: messageFields) {
                    for (Field dtoField: messageDtoFields) {
                        if (!field.getName().equals("serialVersionUID") && field.getName().equals(dtoField.getName())
                                && field.getType().equals(dtoField.getType())) {
                            try{
                                Field dtofield = messageDTO.getClass().getDeclaredField(field.getName());
                                dtofield.setAccessible(true);
                                field.setAccessible(true);
                                dtofield.set(messageDTO, field.get(message));
                            } catch(Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
                messageDTO.setAddTimeStr(DateUtil.toString(message.getAddTime(), DateUtil.Format_Date));
                messageDTO.setModifyTimeStr(DateUtil.toString(message.getModifyTime(), DateUtil.Format_Date));
                dtoList.add(messageDTO);
            }
        }
        return dtoList;
    }

    public MessageDataTransfer(){
        System.out.println("message datatransfer init");
    }
}
