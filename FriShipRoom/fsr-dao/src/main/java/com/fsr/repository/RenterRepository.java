package com.fsr.repository;

import com.fsr.domain.Home;
import com.fsr.domain.Renter;

import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
public interface RenterRepository {
    List<Renter> getRentersByType(Integer type);

    List<Renter> getRentersByPage(Integer offset, Integer perPage);

    Long selectCount();

    Integer insertRenter(Renter renter);
}
