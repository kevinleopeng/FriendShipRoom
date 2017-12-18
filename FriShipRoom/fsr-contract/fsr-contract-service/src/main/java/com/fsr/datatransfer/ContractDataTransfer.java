package com.fsr.datatransfer;


import com.fsr.constant.ContractConstant;
import com.fsr.domain.Contract;
import com.fsr.dto.ContractDTO;
import com.fsr.util.DateUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Hasee on 2017/5/11.
 */
@Service("contractDataTransfer")
public class ContractDataTransfer implements DataTransfer<Contract, ContractDTO> {
    @Override
    public Collection<ContractDTO> transfer(Collection<Contract> list, Object... objs) {
        List<ContractDTO> dtoList = new ArrayList();
        int type = (Integer) objs[0];
        if (null != list && list.size() > 0) {
            Field[] ContractDtoFields = ContractDTO.class.getDeclaredFields();

            for (Contract contract: list) {
               ContractDTO ContractDTO = new ContractDTO();
               Field[] ContractFields = contract.getClass().getDeclaredFields();
               for (Field field: ContractFields) {
                    for (Field dtoField: ContractDtoFields) {
                        if (!field.getName().equals("serialVersionUID") && field.getName().equals(dtoField.getName())
                                && field.getType().equals(dtoField.getType())) {
                            try{
                                Field dtofield = ContractDTO.getClass().getDeclaredField(field.getName());
                                dtofield.setAccessible(true);
                                field.setAccessible(true);
                                dtofield.set(ContractDTO, field.get(contract));
                            } catch(Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
                ContractDTO.setContractType(ContractConstant.HOUSE_CONTRACT == contract.getType() ? ContractConstant.HOUSE_CONTRACT_STR : ContractConstant.ROOM_CONTRACT_STR);
                ContractDTO.setContractRentStartTime(DateUtil.toString(contract.getRentStartTime(), DateUtil.Format_Date));
                ContractDTO.setContractRentEndTime(DateUtil.toString(contract.getRentEndTime(), DateUtil.Format_Date));
                ContractDTO.setContractSignDate(DateUtil.toString(contract.getSignDate(), DateUtil.Format_Date));
                ContractDTO.setContractNextPayDate(DateUtil.toString(contract.getNextPayDate(), DateUtil.Format_Date));
                if (ContractConstant.HOUSE_CONTRACT == type) {
                    ContractDTO.setIsContractIncrement(ContractConstant.INCREMENT == contract.getIsIncrement() ? ContractConstant.INCREMENT_STR : ContractConstant.NON_INCREMENT_STR);
                }
                if (ContractConstant.MONTH_PAID == contract.getPayMode()) {
                    ContractDTO.setContractPayMode(ContractConstant.MONTH_PAID_STR);
                } else if (ContractConstant.SEASON_PAID == contract.getPayMode()) {
                    ContractDTO.setContractPayMode(ContractConstant.SEASON_PAID_STR);
                } else if (ContractConstant.HALFYEAR_PAID == contract.getPayMode()) {
                    ContractDTO.setContractPayMode(ContractConstant.HALFYEAR_PAID_STR);
                } else if (ContractConstant.YEAR_PAID == contract.getPayMode()) {
                    ContractDTO.setContractPayMode(ContractConstant.YEAR_PAID_STR);
                }
                dtoList.add(ContractDTO);
            }
        }
        return dtoList;
    }

    public ContractDataTransfer(){
        System.out.println("contract datatransfer init");
    }
}
