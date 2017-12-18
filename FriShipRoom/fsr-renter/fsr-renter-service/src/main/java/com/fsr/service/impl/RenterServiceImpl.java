package com.fsr.service.impl;

import com.fsr.domain.Renter;
import com.fsr.repository.RenterRepository;
import com.fsr.service.RenterService;
import com.fsr.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hasee on 2017/6/29.
 */
@Service
public class RenterServiceImpl implements RenterService {
    @Autowired
    private RenterRepository renterRepository;

    @Override
    public List<Renter> getRentersByType(Integer type) {
        return renterRepository.getRentersByType(type);
    }

    @Override
    public List<Renter> getRentersByPage(Integer page, Integer perPage) {
        Integer offset = PageUtil.calculateOffset(page, perPage);
        return renterRepository.getRentersByPage(offset, perPage);
    }

    @Override
    public Long selectCount() {
        return renterRepository.selectCount();
    }

    @Override
    public Integer insertRenter(Renter renter) {
        return renterRepository.insertRenter(renter);
    }

    @Override
    public Integer getTotalPage(Integer perPage) {
        return PageUtil.calculateTotalPage(selectCount(), perPage);
    }
}
