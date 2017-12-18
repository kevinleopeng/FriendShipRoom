package com.fsr.repository;

import com.fsr.domain.CollectRent;
import com.fsr.domain.Contract;

import java.util.Date;
import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
public interface CollectRentRepository {
    List<CollectRent> getCollectRentContractsByPageAndType(Integer offset, Integer perPage, Integer type);

    Long selectCountByType(Integer type);

    Integer insertCollectRent(CollectRent collectRent);

    Long getCollectRentCountByTypeAndPayDate(Integer type, Date payDate, Long id);
}
