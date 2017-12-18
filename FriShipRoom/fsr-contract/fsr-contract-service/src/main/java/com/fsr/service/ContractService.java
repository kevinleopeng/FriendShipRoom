package com.fsr.service;

import com.fsr.domain.Contract;
import com.fsr.domain.Expense;
import com.fsr.dto.ExInLineStatDTO;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Hasee on 2017/4/25.
 */
public interface ContractService {
    List<Contract> getLandlordContractsByPage(Integer page, Integer perPage);

    List<Contract> getRenterContractsByPage(Integer page, Integer perPage);

    Integer getTotalPage(Integer perPage, Integer type);

    Integer insertContract(Contract contract);

    Long selectCountByType(Integer type);

    List<Contract> getRenterContractsByCurrentDateAndNextFiveDate(Date currentDate, String nextFiveDate);
}
