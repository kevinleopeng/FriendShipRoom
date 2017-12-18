package com.fsr.repository.mybatis;

import com.fsr.domain.Expense;
import com.fsr.domain.Home;
import com.fsr.repository.ExpenseRepository;
import com.fsr.repository.HomeRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
@Mapper
public interface HomeMapper extends HomeRepository {
    @Override
    List<Home> getAllHomes();

    @Override
    Home getHomeById(Long id);

    @Override
    List<Home> getHomesByPage(@Param("offset") Integer offset, @Param("perPage") Integer perPage);

    @Override
    Long selectCount();

    @Override
    Integer insertHome(Home home);
}
