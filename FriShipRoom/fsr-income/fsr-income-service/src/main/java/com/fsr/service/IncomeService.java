package com.fsr.service;

import com.fsr.domain.Expense;
import com.fsr.domain.Income;

import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
public interface IncomeService {
    List<Income> getIncomesByPage(Integer page, Integer perPage);

    Integer getTotalPage(Integer perPage);

    Integer insertIncome(Income income);

    Long selectCount();
}
