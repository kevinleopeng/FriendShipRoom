package com.fsr.datatransfer;

import com.fsr.constant.AdvancePayConstant;
import com.fsr.constant.SettlementStatusConstant;
import com.fsr.context.SpringContextHolder;
import com.fsr.domain.Expense;
import com.fsr.domain.Income;
import com.fsr.dto.ExpenseDTO;
import com.fsr.dto.IncomeDTO;
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
@Service("incomeDataTransfer")
public class IncomeDataTransfer implements DataTransfer<Income, IncomeDTO> {
    @Override
    public Collection<IncomeDTO> transfer(Collection<Income> list, Object... objs) {
        List<IncomeDTO> dtoList = new ArrayList();

        if (null != list && list.size() > 0) {
            HomeService homeService = (HomeService) SpringContextHolder.getBean("homeServiceImpl");
            CategoryUtil categoryUtil = CategoryUtil.getInstance();
            Field[] incomeDtoFields = IncomeDTO.class.getDeclaredFields();

            for (Income income: list) {
                IncomeDTO incomeDTO = new IncomeDTO();
               Field[] incomeFields = income.getClass().getDeclaredFields();
               for (Field field: incomeFields) {
                    for (Field dtoField: incomeDtoFields) {
                        if (!field.getName().equals("serialVersionUID") && field.getName().equals(dtoField.getName())
                                && field.getType().equals(dtoField.getType())) {
                            try{
                                Field dtofield = incomeDTO.getClass().getDeclaredField(field.getName());
                                dtofield.setAccessible(true);
                                field.setAccessible(true);
                                dtofield.set(incomeDTO, field.get(income));
                            } catch(Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
                incomeDTO.setIncomeType(categoryUtil.getCategoryById(String.valueOf(income.getType())));
                incomeDTO.setIncomeActualProj(categoryUtil.getCategoryById(String.valueOf(income.getActualProj())));
                incomeDTO.setIncomeTime(DateUtil.toString(income.getTime(), DateUtil.Format_Date));
                incomeDTO.setHomeAddress(homeService.getHomeById(income.getHomeId()).getAddress());
                dtoList.add(incomeDTO);
            }
        }
        return dtoList;
    }

    public IncomeDataTransfer(){
        System.out.println("income datatransfer init");
    }
}
