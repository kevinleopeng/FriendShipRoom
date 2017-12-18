package com.fsr.repository.mybatis;

import com.fsr.domain.Contract;
import com.fsr.domain.Expense;
import com.fsr.dto.ExInLineStatDTO;
import com.fsr.repository.ContractRepository;
import com.fsr.repository.ExpenseRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Hasee on 2017/4/25.
 */
@Mapper
public interface ContractMapper extends ContractRepository {
    @Override
    List<Contract> getLandlordContractsByPage(@Param("offset") Integer offset, @Param("perPage") Integer perPage);

    @Override
    List<Contract> getRenterContractsByCurrentDateAndNextFiveDate(@Param("currentDate") Date currentDate, @Param("nextFiveDate") String nextFiveDate);

    @Override
    Long selectCountByType(Integer type);

    @Override
    List<Contract> getRenterContractsByPage(@Param("offset") Integer offset, @Param("perPage") Integer perPage);

    @Override
    Integer insertContract(Contract contract);
}
