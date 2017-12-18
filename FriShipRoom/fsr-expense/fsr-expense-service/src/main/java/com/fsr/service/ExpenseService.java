package com.fsr.service;

import com.fsr.domain.Expense;
import com.fsr.dto.ExInLineStatDTO;

import java.util.List;
import java.util.Set;

/**
 * Created by Hasee on 2017/4/25.
 */
public interface ExpenseService {
    List<Expense> getExpensesByPage(Integer page, Integer perPage);

    Integer getTotalPage(Integer perPage);

    Integer insertExpense(Expense expense);

    Long selectCount();

    Set<ExInLineStatDTO> getExpenseLineStatData(String from, String to, String homeCondition);
}
