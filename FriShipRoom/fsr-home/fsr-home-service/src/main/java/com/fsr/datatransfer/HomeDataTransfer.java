package com.fsr.datatransfer;


import com.fsr.constant.HomeConstant;
import com.fsr.domain.Home;
import com.fsr.dto.HomeDTO;
import com.fsr.util.DateUtil;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Hasee on 2017/5/11.
 */
@Service("homeDataTransfer")
public class HomeDataTransfer implements DataTransfer<Home, HomeDTO> {
    @Override
    public Collection<HomeDTO> transfer(Collection<Home> list, Object... objs) {
        List<HomeDTO> dtoList = new ArrayList();

        if (null != list && list.size() > 0) {
            Field[] HomeDtoFields = HomeDTO.class.getDeclaredFields();

            for (Home home: list) {
               HomeDTO HomeDTO = new HomeDTO();
               Field[] HomeFields = home.getClass().getDeclaredFields();
               for (Field field: HomeFields) {
                    for (Field dtoField: HomeDtoFields) {
                        if (!field.getName().equals("serialVersionUID") && field.getName().equals(dtoField.getName())
                                && field.getType().equals(dtoField.getType())) {
                            try{
                                Field dtofield = HomeDTO.getClass().getDeclaredField(field.getName());
                                dtofield.setAccessible(true);
                                field.setAccessible(true);
                                dtofield.set(HomeDTO, field.get(home));
                            } catch(Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
                HomeDTO.setHomeStatus(HomeConstant.homeTypeMap.get(home.getStatus()));

                HomeDTO.setIsLivingRoomBalcony(HomeConstant.HAVE_LIVING_BALCONY == home.getLivingRoomBalcony() ? HomeConstant.HAVE_STR : HomeConstant.NO_STR);
                HomeDTO.setIsLivingRoomBalcony(HomeConstant.HAVE_LIFE_BALCONY == home.getLifeBalcony() ? HomeConstant.HAVE_STR : HomeConstant.NO_STR);

                dtoList.add(HomeDTO);
            }
        }
        return dtoList;
    }

    public HomeDataTransfer(){
        System.out.println("home datatransfer init");
    }
}
