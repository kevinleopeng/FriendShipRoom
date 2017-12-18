package com.fsr.repository.mybatis;

import com.fsr.domain.Expense;
import com.fsr.dto.ExInLineStatDTO;
import com.fsr.repository.ExpenseRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Set;

/**
 * Created by Hasee on 2017/4/25.
 */
@Mapper
public interface ExpenseMapper extends ExpenseRepository {
    @Override
    List<Expense> getExpensesByPage(@Param("offset") Integer offset, @Param("perPage") Integer perPage);

    @Override
    Long selectCount();

    @Override
    Set<ExInLineStatDTO> getExpenseLineStatData(@Param("from") String from, @Param("to") String to, @Param("homeCondition") String homeCondition);

    @Override
    Expense getExpenseById(Long id);

    @Override
    Integer insertExpense(Expense expense);
}
