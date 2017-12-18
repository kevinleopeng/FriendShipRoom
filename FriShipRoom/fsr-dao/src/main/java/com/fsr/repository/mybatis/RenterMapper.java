package com.fsr.repository.mybatis;

import com.fsr.domain.Expense;
import com.fsr.domain.Renter;
import com.fsr.dto.ExInLineStatDTO;
import com.fsr.repository.ExpenseRepository;
import com.fsr.repository.RenterRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * Created by Hasee on 2017/4/25.
 */
@Mapper
public interface RenterMapper extends RenterRepository {
    @Override
    List<Renter> getRentersByType(@Param("type") Integer type);

    @Override
    List<Renter> getRentersByPage(@Param("offset") Integer offset, @Param("perPage") Integer perPage);

    @Override
    Long selectCount();

    @Override
    Integer insertRenter(Renter renter);
}
