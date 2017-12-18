package com.fsr.repository;

import com.fsr.domain.Expense;
import com.fsr.domain.Home;

import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
public interface HomeRepository {
    List<Home> getAllHomes();

    Home getHomeById(Long id);

    List<Home> getHomesByPage(Integer offset, Integer perPage);

    Long selectCount();

    Integer insertHome(Home home);
}
