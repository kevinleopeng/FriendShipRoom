package com.fsr.datatransfer;


import com.fsr.constant.CollectRentConstant;
import com.fsr.domain.CollectRent;
import com.fsr.dto.CellectRentDTO;
import com.fsr.util.DateUtil;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Hasee on 2017/5/11.
 */
@Service("collectRentDataTransfer")
public class CollectRentDataTransfer implements DataTransfer<CollectRent, CellectRentDTO> {
    @Override
    public Collection<CellectRentDTO> transfer(Collection<CollectRent> list, Object... objs) {
        List<CellectRentDTO> dtoList = new ArrayList();
        int type = (Integer) objs[0];
        if (null != list && list.size() > 0) {
            Field[] CollectRentDtoFields = CellectRentDTO.class.getDeclaredFields();

            for (CollectRent contract: list) {
                CellectRentDTO CollectRentDTO = new CellectRentDTO();
               Field[] CollectRentFields = contract.getClass().getDeclaredFields();
               for (Field field: CollectRentFields) {
                    for (Field dtoField: CollectRentDtoFields) {
                        if (!field.getName().equals("serialVersionUID") && field.getName().equals(dtoField.getName())
                                && field.getType().equals(dtoField.getType())) {
                            try{
                                Field dtofield = CollectRentDTO.getClass().getDeclaredField(field.getName());
                                dtofield.setAccessible(true);
                                field.setAccessible(true);
                                dtofield.set(CollectRentDTO, field.get(contract));
                            } catch(Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
                CollectRentDTO.setPayStatus(CollectRentConstant.HAVE_PAID == contract.getIsPay() ? CollectRentConstant.HAVE_PAID_STR : CollectRentConstant.NON_PAID_STR);
                CollectRentDTO.setMessageStatus(contract.getStatus() > 0 ? CollectRentConstant.MESSAGE_SUCCESS : CollectRentConstant.MESSAGE_FAIL);
                CollectRentDTO.setPayDateStr(DateUtil.toString(contract.getPayDate(), DateUtil.Format_Date));

                dtoList.add(CollectRentDTO);
            }
        }
        return dtoList;
    }

    public CollectRentDataTransfer(){
        System.out.println("collectrent datatransfer init");
    }
}
