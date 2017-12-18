package com.fsr.service.impl;

import com.fsr.domain.Contract;
import com.fsr.repository.ContractRepository;
import com.fsr.service.ContractService;
import com.fsr.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * Created by Hasee on 2017/4/25.
 */
@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<Contract> getLandlordContractsByPage(Integer page, Integer perPage) {
        Integer offset = PageUtil.calculateOffset(page, perPage);
        return contractRepository.getLandlordContractsByPage(offset, perPage);
    }

    @Override
    public List<Contract> getRenterContractsByPage(Integer page, Integer perPage) {
        Integer offset = PageUtil.calculateOffset(page, perPage);
        return contractRepository.getRenterContractsByPage(offset, perPage);
    }

    @Override
    public List<Contract> getRenterContractsByCurrentDateAndNextFiveDate(Date currentDate, String nextFiveDate) {
        return contractRepository.getRenterContractsByCurrentDateAndNextFiveDate(currentDate, nextFiveDate);
    }

    @Override
    public Integer insertContract(Contract contract) {
        return contractRepository.insertContract(contract);
    }

    @Override
    public Integer getTotalPage(Integer perPage, Integer type) {
        return PageUtil.calculateTotalPage(selectCountByType(type), perPage);
    }

    @Override
    public Long selectCountByType(Integer type) {
        return contractRepository.selectCountByType(type);
    }
}
