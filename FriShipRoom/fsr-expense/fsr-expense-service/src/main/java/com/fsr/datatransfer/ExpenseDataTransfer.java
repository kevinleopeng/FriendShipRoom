package com.fsr.datatransfer;

import com.fsr.constant.AdvancePayConstant;
import com.fsr.constant.SettlementStatusConstant;
import com.fsr.context.SpringContextHolder;
import com.fsr.domain.Expense;
import com.fsr.dto.ExpenseDTO;
import com.fsr.service.HomeService;
import com.fsr.util.CategoryUtil;
import com.fsr.util.DateUtil;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Hasee on 2017/5/11.
 */
@Service("expenseDataTransfer")
public class ExpenseDataTransfer implements DataTransfer<Expense, ExpenseDTO> {
    @Override
    public Collection<ExpenseDTO> transfer(Collection<Expense> list, Object... objs) {
        List<ExpenseDTO> dtoList = new ArrayList();

        if (null != list && list.size() > 0) {
            HomeService homeService = (HomeService) SpringContextHolder.getBean("homeServiceImpl");
            CategoryUtil categoryUtil = CategoryUtil.getInstance();
            Field[] expenseDtoFields = ExpenseDTO.class.getDeclaredFields();

            for (Expense expense: list) {
               ExpenseDTO expenseDTO = new ExpenseDTO();
               Field[] expenseFields = expense.getClass().getDeclaredFields();
               for (Field field: expenseFields) {
                    for (Field dtoField: expenseDtoFields) {
                        if (!field.getName().equals("serialVersionUID") && field.getName().equals(dtoField.getName())
                                && field.getType().equals(dtoField.getType())) {
                            try{
                                Field dtofield = expenseDTO.getClass().getDeclaredField(field.getName());
                                dtofield.setAccessible(true);
                                field.setAccessible(true);
                                dtofield.set(expenseDTO, field.get(expense));
                            } catch(Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
                expenseDTO.setPayType(categoryUtil.getCategoryById(String.valueOf(expense.getType())));
                expenseDTO.setPayActualProj(categoryUtil.getCategoryById(String.valueOf(expense.getActualProj())));
                expenseDTO.setAdvancePayStatus((expense.getIsAdvancePay() == AdvancePayConstant.NON_PAID) ? AdvancePayConstant.NON_PAID_STR : AdvancePayConstant.HAVE_PAID_STR);
                expenseDTO.setSettledStatus((expense.getSettlementStatus() == SettlementStatusConstant.NON_SETTLED) ? SettlementStatusConstant.NON_SETTLED_STR : SettlementStatusConstant.HAVE_SETTLED_STR);
                expenseDTO.setPayTime(DateUtil.toString(expense.getTime(), DateUtil.Format_Date));
                expenseDTO.setHomeAddress(homeService.getHomeById(expense.getHomeId()).getAddress());
                dtoList.add(expenseDTO);
            }
        }
        return dtoList;
    }

    public ExpenseDataTransfer(){
        System.out.println("datatransfer init");
    }
}
