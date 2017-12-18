package com.fsr.datatransfer.impl;

import com.fsr.datatransfer.DataTransfer;
import com.fsr.dto.ExInLineStatDTO;
import com.fsr.util.DateUtil;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Hasee on 2017/5/28.
 */
@Service("exInLineStatDataTransfer")
public class ExInLineStatDataTransfer implements DataTransfer<ExInLineStatDTO, Long>{
    @Override
    public Collection<Long> transfer(Collection<ExInLineStatDTO> list, Object... objs) {
        Set<String> days = (LinkedHashSet) objs[0];
        List<Long> totalList = new ArrayList(days.size());
        Map<String, Long> map;
        int size = list.size();
        if (size >= 12) {
            int count = 0;
            int i = 4;
            while (true) {
                if ((count = 2 << i) * 0.75 > size) {
                    break;
                }
                ++i;
            }
            map = new HashMap(size);
        } else {
            map = new HashMap();
        }
        for (ExInLineStatDTO statDTO: list) {
            map.put(statDTO.getDay(), statDTO.getTotal());
        }
        for (String day: days) {
            Long val = map.get(day);
            if (null != val && 0 != val) {
                totalList.add(val);
            } else {
                totalList.add(0l);
            }
        }
        return totalList;
    }
}
