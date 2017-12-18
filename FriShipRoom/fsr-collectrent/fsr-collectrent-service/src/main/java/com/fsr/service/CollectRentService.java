package com.fsr.service;

import com.fsr.domain.CollectRent;
import com.fsr.domain.Contract;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Hasee on 2017/4/25.
 */
public interface CollectRentService {
    List<CollectRent> getCollectRentContractsByPageAndType(Integer offset, Integer perPage, Integer type);

    Long selectCountByType(Integer type);

    Integer getTotalPage(Integer perPage, Integer type);

    Integer insertCollectRent(CollectRent collectRent);

    Long getCollectRentCountByTypeAndPayDate(Integer type, Date payDate, Long id);

    void collectRentByScheduledTask(Map<Integer, List<Contract>> map);
}
