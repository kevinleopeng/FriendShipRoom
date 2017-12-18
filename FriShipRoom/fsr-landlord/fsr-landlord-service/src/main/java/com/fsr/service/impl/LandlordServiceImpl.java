package com.fsr.service.impl;

import com.fsr.domain.Landlord;
import com.fsr.repository.LandlordRepository;
import com.fsr.service.LandlordService;
import com.fsr.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * Created by Hasee on 2017/4/25.
 */
@Service
public class LandlordServiceImpl implements LandlordService {
    @Autowired
    private LandlordRepository landlordRepository;

    @Override
    public List<Landlord> getLandlordsByPage(Integer page, Integer perPage) {
        Integer offset = PageUtil.calculateOffset(page, perPage);
        return landlordRepository.getLandlordsByPage(offset, perPage);
    }

    @Override
    public Integer insertLandlord(Landlord landlord) {
        return landlordRepository.insertLandlord(landlord);
    }

    @Override
    public Integer getTotalPage(Integer perPage) {
        return PageUtil.calculateTotalPage(selectCount(), perPage);
    }

    @Override
    public Long selectCount() {
        return landlordRepository.selectCount();
    }

    @Override
    public List<Landlord> getAllLandlords() {
        return landlordRepository.getAllLandlords();
    }
}
