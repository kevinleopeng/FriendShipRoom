package com.fsr.repository;

import com.fsr.domain.Expense;
import com.fsr.dto.ExInLineStatDTO;

import java.util.List;
import java.util.Set;

/**
 * Created by Hasee on 2017/4/25.
 */
public interface ExpenseRepository {
    List<Expense> getExpensesByPage(Integer offset, Integer perPage);

    Long selectCount();

    Expense getExpenseById(Long id);

    Integer insertExpense(Expense expense);

    Set<ExInLineStatDTO> getExpenseLineStatData(String from, String to, String homeCondition);


}
