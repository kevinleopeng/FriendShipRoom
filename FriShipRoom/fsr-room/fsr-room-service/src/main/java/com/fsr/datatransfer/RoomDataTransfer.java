package com.fsr.datatransfer;

import com.fsr.constant.AdvancePayConstant;
import com.fsr.constant.RoomConstant;
import com.fsr.constant.SettlementStatusConstant;
import com.fsr.context.SpringContextHolder;
import com.fsr.domain.Room;
import com.fsr.domain.Room;
import com.fsr.dto.RoomDTO;
import com.fsr.dto.RoomDTO;
import com.fsr.service.HomeService;
import com.fsr.util.CategoryUtil;
import com.fsr.util.DateUtil;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Hasee on 2017/5/11.
 */
@Service("roomDataTransfer")
public class RoomDataTransfer implements DataTransfer<Room, RoomDTO> {
    @Override
    public Collection<RoomDTO> transfer(Collection<Room> list, Object... objs) {
        List<RoomDTO> dtoList = new ArrayList();

        if (null != list && list.size() > 0) {
            Field[] roomDtoFields = RoomDTO.class.getDeclaredFields();

            for (Room room: list) {
               RoomDTO roomDTO = new RoomDTO();
               Field[] roomFields = room.getClass().getDeclaredFields();
               for (Field field: roomFields) {
                    for (Field dtoField: roomDtoFields) {
                        if (!field.getName().equals("serialVersionUID") && field.getName().equals(dtoField.getName())
                                && field.getType().equals(dtoField.getType())) {
                            try{
                                Field dtofield = roomDTO.getClass().getDeclaredField(field.getName());
                                dtofield.setAccessible(true);
                                field.setAccessible(true);
                                dtofield.set(roomDTO, field.get(room));
                            } catch(Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
                roomDTO.setRoomType(RoomConstant.roomTypeMap.get(room.getRoomClass()));
                roomDTO.setHasBalcony(RoomConstant.HAVE == room.getIsBalcony() ? RoomConstant.HAVE_STR : RoomConstant.NO_STR);
                roomDTO.setHasBathRoom(RoomConstant.HAVE == room.getIsBathRoom() ? RoomConstant.HAVE_STR : RoomConstant.NO_STR);
                roomDTO.setEmptyStatus(RoomConstant.HAVE == room.getIsEmpty() ? RoomConstant.IS_STR : RoomConstant.NON_STR);
                dtoList.add(roomDTO);
            }
        }
        return dtoList;
    }

    public RoomDataTransfer(){
        System.out.println("room datatransfer init");
    }
}
