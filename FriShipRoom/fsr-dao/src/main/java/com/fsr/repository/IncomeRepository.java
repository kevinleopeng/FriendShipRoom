package com.fsr.repository;

import com.fsr.domain.Expense;
import com.fsr.domain.Income;

import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
public interface IncomeRepository {
    List<Income> getIncomesByPage(Integer offset, Integer perPage);

    Long selectCount();

    Income getIncomeById(Long id);

    Integer insertIncome(Income income);
}
