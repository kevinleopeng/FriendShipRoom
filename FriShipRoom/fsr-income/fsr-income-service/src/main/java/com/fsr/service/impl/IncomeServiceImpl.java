package com.fsr.service.impl;

import com.fsr.domain.Expense;
import com.fsr.domain.Income;
import com.fsr.repository.ExpenseRepository;
import com.fsr.repository.IncomeRepository;
import com.fsr.service.IncomeService;
import com.fsr.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
@Service
public class IncomeServiceImpl implements IncomeService {
    @Autowired
    private IncomeRepository incomeRepository;

    @Override
    public List<Income> getIncomesByPage(Integer page, Integer perPage) {
        Integer offset = PageUtil.calculateOffset(page, perPage);

        return incomeRepository.getIncomesByPage(offset, perPage);
    }

    @Override
    public Integer insertIncome(Income income) {
        return incomeRepository.insertIncome(income);
    }

    @Override
    public Integer getTotalPage(Integer perPage) {
        return PageUtil.calculateTotalPage(selectCount(), perPage);
    }

    @Override
    public Long selectCount() {
        return incomeRepository.selectCount();
    }
}
