package com.fsr.repository;

import com.fsr.domain.Landlord;
import com.fsr.domain.Renter;

import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
public interface LandlordRepository {
    List<Landlord> getLandlordsByPage(Integer offset, Integer perPage);

    Long selectCount();

    Integer insertLandlord(Landlord landlord);

    List<Landlord> getAllLandlords();
}
