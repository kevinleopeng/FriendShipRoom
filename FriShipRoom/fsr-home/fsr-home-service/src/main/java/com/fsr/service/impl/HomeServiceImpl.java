package com.fsr.service.impl;

import com.fsr.domain.Home;
import com.fsr.domain.Landlord;
import com.fsr.repository.HomeRepository;
import com.fsr.repository.mybatis.HomeMapper;
import com.fsr.service.HomeService;
import com.fsr.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hasee on 2017/5/11.
 */
@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeRepository homeRepository;

    @Override
    public List<Home> getAllHomes() {
        return this.homeRepository.getAllHomes();
    }

    @Override
    public Home getHomeById(Long id) {
        return homeRepository.getHomeById(id);
    }

    @Override
    public List<Home> getHomesByPage(Integer page, Integer perPage) {
        Integer offset = PageUtil.calculateOffset(page, perPage);
        return homeRepository.getHomesByPage(offset, perPage);
    }

    @Override
    public Integer insertHome(Home home) {
        return homeRepository.insertHome(home);
    }

    @Override
    public Integer getTotalPage(Integer perPage) {
        return PageUtil.calculateTotalPage(selectCount(), perPage);
    }

    @Override
    public Long selectCount() {
        return homeRepository.selectCount();
    }

    public HomeServiceImpl(){
        System.out.println("homeservice init");
    }
}
