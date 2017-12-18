package com.fsr.service;

import com.fsr.domain.Expense;
import com.fsr.domain.Renter;
import com.fsr.dto.ExInLineStatDTO;

import java.util.List;
import java.util.Set;

/**
 * Created by Hasee on 2017/4/25.
 */
public interface RenterService {
    List<Renter> getRentersByType(Integer type);

    List<Renter> getRentersByPage(Integer offset, Integer perPage);

    Long selectCount();

    Integer insertRenter(Renter renter);

    Integer getTotalPage(Integer perPage);
}
