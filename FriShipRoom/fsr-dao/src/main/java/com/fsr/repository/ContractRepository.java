package com.fsr.repository;

import com.fsr.domain.Contract;
import com.fsr.domain.Income;

import java.util.Date;
import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
public interface ContractRepository {
    List<Contract> getLandlordContractsByPage(Integer offset, Integer perPage);

    Long selectCountByType(Integer type);

    List<Contract> getRenterContractsByPage(Integer offset, Integer perPage);

    Integer insertContract(Contract contract);

    List<Contract> getRenterContractsByCurrentDateAndNextFiveDate(Date currentDate, String nextFiveDate);
}
