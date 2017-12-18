package com.fsr.service;

import com.fsr.domain.Contract;
import com.fsr.domain.Landlord;

import java.util.Date;
import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
public interface LandlordService {
    List<Landlord> getLandlordsByPage(Integer page, Integer perPage);

    Integer getTotalPage(Integer perPage);

    Integer insertLandlord(Landlord landlord);

    Long selectCount();

    List<Landlord> getAllLandlords();
}
