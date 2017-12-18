package com.fsr.service.impl;

import com.fsr.domain.Expense;
import com.fsr.dto.ExInLineStatDTO;
import com.fsr.repository.ExpenseRepository;
import com.fsr.service.ExpenseService;
import com.fsr.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Hasee on 2017/4/25.
 */
@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getExpensesByPage(Integer page, Integer perPage) {
        Integer offset = PageUtil.calculateOffset(page, perPage);
        return expenseRepository.getExpensesByPage(offset, perPage);
    }

    @Override
    public Integer insertExpense(Expense expense) {
        return expenseRepository.insertExpense(expense);
    }

    @Override
    public Integer getTotalPage(Integer perPage) {
        return PageUtil.calculateTotalPage(selectCount(), perPage);
    }

    @Override
    public Set<ExInLineStatDTO> getExpenseLineStatData(String from, String to, String homeCondition) {
        return expenseRepository.getExpenseLineStatData(from, to, homeCondition);
    }

    @Override
    public Long selectCount() {
        return expenseRepository.selectCount();
    }
}
