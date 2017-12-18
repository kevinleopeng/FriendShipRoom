package com.fsr.repository.mybatis;

import com.fsr.domain.Expense;
import com.fsr.domain.Income;
import com.fsr.repository.ExpenseRepository;
import com.fsr.repository.IncomeRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
@Mapper
public interface IncomeMapper extends IncomeRepository {
    @Override
    List<Income> getIncomesByPage(@Param("offset") Integer offset, @Param("perPage") Integer perPage);

    @Override
    Long selectCount();

    @Override
    Income getIncomeById(Long id);

    @Override
    Integer insertIncome(Income income);
}
