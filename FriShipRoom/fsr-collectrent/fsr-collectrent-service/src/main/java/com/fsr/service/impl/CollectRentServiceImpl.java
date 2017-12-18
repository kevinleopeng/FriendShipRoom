package com.fsr.service.impl;

import com.fsr.constant.CollectRentConstant;
import com.fsr.constant.ContractConstant;
import com.fsr.domain.CollectRent;
import com.fsr.domain.Contract;
import com.fsr.http.HttpClientUtil;
import com.fsr.repository.CollectRentRepository;
import com.fsr.service.CollectRentService;
import com.fsr.util.DateUtil;
import com.fsr.util.PageUtil;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hasee on 2017/7/24.
 */
@Service
public class CollectRentServiceImpl implements CollectRentService {
    @Autowired
    private CollectRentRepository collectRentRepository;

    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    private HttpClientUtil clientUtil;

    @Override
    public List<CollectRent> getCollectRentContractsByPageAndType(Integer page, Integer perPage, Integer type) {
        Integer offset = PageUtil.calculateOffset(page, perPage);
        return collectRentRepository.getCollectRentContractsByPageAndType(offset, perPage, type);
    }

    @Override
    public Long selectCountByType(Integer type) {
        return collectRentRepository.selectCountByType(type);
    }

    @Override
    public void collectRentByScheduledTask(Map<Integer, List<Contract>> map) {
        if (null != map.get(ContractConstant.HOUSE_CONTRACT)) {
            collectHouseRent(map.get(ContractConstant.HOUSE_CONTRACT));
        }
        if (null != map.get(ContractConstant.ROOM_CONTRACT)) {
            collectRoomRent(map.get(ContractConstant.ROOM_CONTRACT));
        }
    }

    @Override
    public Integer getTotalPage(Integer perPage, Integer type) {
        return PageUtil.calculateTotalPage(selectCountByType(type), perPage);
    }

    private void collectHouseRent(List<Contract> list) {
        for (Contract contract: list) {
            Long count = this.collectRentRepository
                    .getCollectRentCountByTypeAndPayDate(
                            ContractConstant.HOUSE_CONTRACT, contract.getNextPayDate(),contract.getHomeId());
            if (0 == count) {
                int rental = contract.getRental();
                String payDateStr = DateUtil.getDateStrByDate(contract.getNextPayDate(), "yyyy-MM-dd");
                String[] payDateArr = payDateStr.split("-");
                if (ContractConstant.INCREMENT == contract.getIsIncrement()
                        && contract.getWhichYear().equals(payDateArr[0])) {
                    rental += rental * contract.getIncrementPercent() / 100;
                }
                int amount = rental * getMultiFactorByPayMode(contract.getPayMode());
                VelocityContext context = new VelocityContext();

                context.put("address", contract.getHomeAddress());
                context.put("amount", amount);
                context.put("month", payDateArr[1]);
                context.put("day", payDateArr[2]);

                StringWriter stringWriter = new StringWriter();
                velocityEngine.mergeTemplate("templates/houserent.vm", "UTF-8", context, stringWriter);
                String text = stringWriter.toString();

                StringWriter writer = new StringWriter();
                velocityEngine.mergeTemplate("templates/landlordrent.vm", "UTF-8", context, writer);
                String landlordText = writer.toString();
                System.out.print(landlordText);

                Map param = new HashMap();

                param.put("Uid", "kevinleopeng");
                param.put("Key", "b6e7085c4e5dcc0224f1");
                param.put("smsMob", String.valueOf(contract.getRenterPhoneNum()));
                param.put("smsText", text);

                String result = clientUtil.doPost("http://utf8.api.smschinese.cn/", param, "UTF-8");

                param.put("smsText", landlordText);
                param.put("smsMob", String.valueOf(contract.getLandlordPhoneNum()));

                String landlordResult = clientUtil.doPost("http://utf8.api.smschinese.cn/", param, "UTF-8");

                CollectRent collectRent = new CollectRent();

                collectRent.setHomeAddress(contract.getHomeAddress());
                collectRent.setCountDown(5);
                collectRent.setHomeId(contract.getHomeId());
                collectRent.setIsPay(CollectRentConstant.NON_PAID);
                collectRent.setLandlordId(contract.getLandlordId());
                collectRent.setLandlordName(contract.getLandlordName());
                collectRent.setOverDue(0);
                collectRent.setRenterId(contract.getRenterId());
                collectRent.setRenterName(contract.getRenterName());
                collectRent.setType(contract.getType());
                collectRent.setLandlordPhoneNum(contract.getLandlordPhoneNum());
                collectRent.setRenterPhoneNum(contract.getRenterPhoneNum());
                collectRent.setStatus(Integer.parseInt(result));
                collectRent.setPayDate(contract.getNextPayDate());
                collectRent.setAmount(amount);

                this.collectRentRepository.insertCollectRent(collectRent);
            }
        }
    }

    private void collectRoomRent(List<Contract> list) {
        for (Contract contract: list) {
            Long count = this.getCollectRentCountByTypeAndPayDate(
                            ContractConstant.ROOM_CONTRACT, contract.getNextPayDate(), contract.getRoomId());
            if (0 == count) {
                int rental = contract.getRental();
                String payDateStr = DateUtil.getDateStrByDate(contract.getNextPayDate(), "yyyy-MM-dd");
                String[] payDateArr = payDateStr.split("-");

                int amount = rental * getMultiFactorByPayMode(contract.getPayMode());
                VelocityContext context = new VelocityContext();

                context.put("address", contract.getHomeAddress() + contract.getRoomAddress());
                context.put("amount", amount);
                context.put("month", payDateArr[1]);
                context.put("day", payDateArr[2]);
                context.put("renterName", contract.getRenterName());
                context.put("renterPhoneNum", contract.getRenterPhoneNum());

                StringWriter stringWriter = new StringWriter();
                velocityEngine.mergeTemplate("templates/roomrent.vm", "UTF-8", context, stringWriter);
                String text = stringWriter.toString();
                System.out.print(text);

                StringWriter writer = new StringWriter();
                velocityEngine.mergeTemplate("templates/landlordroomrent.vm", "UTF-8", context, writer);
                String landlordText = writer.toString();
                System.out.print(landlordText);

                Map param = new HashMap();

                param.put("Uid", "kevinleopeng");
                param.put("Key", "b6e7085c4e5dcc0224f1");
                param.put("smsMob", String.valueOf(contract.getRenterPhoneNum()));
                param.put("smsText", text);

                String result = clientUtil.doPost("http://utf8.api.smschinese.cn/", param, "UTF-8");

                param.put("smsMob", String.valueOf(contract.getLandlordPhoneNum()));
                param.put("smsText", landlordText);
                String landlordResult = clientUtil.doPost("http://utf8.api.smschinese.cn/", param, "UTF-8");

                CollectRent collectRent = new CollectRent();

                collectRent.setHomeAddress(contract.getHomeAddress());
                collectRent.setCountDown(5);
                collectRent.setHomeId(contract.getHomeId());
                collectRent.setIsPay(CollectRentConstant.NON_PAID);
                collectRent.setLandlordId(contract.getLandlordId());
                collectRent.setLandlordName(contract.getLandlordName());
                collectRent.setOverDue(0);
                collectRent.setRenterId(contract.getRenterId());
                collectRent.setRenterName(contract.getRenterName());
                collectRent.setRoomId(contract.getRoomId());
                collectRent.setRoomAddress(contract.getRoomAddress());
                collectRent.setType(contract.getType());
                collectRent.setLandlordPhoneNum(contract.getLandlordPhoneNum());
                collectRent.setRenterPhoneNum(contract.getRenterPhoneNum());
                collectRent.setStatus(Integer.parseInt(result));
                collectRent.setPayDate(contract.getNextPayDate());
                collectRent.setAmount(amount);

                this.collectRentRepository.insertCollectRent(collectRent);
            }
        }
    }

    private static int getMultiFactorByPayMode(int payMode) {
        int factor = 0;

        if (ContractConstant.MONTH_PAID == payMode) {
             factor = 1;
        } else if (ContractConstant.SEASON_PAID == payMode) {
            factor = 3;
        } else if (ContractConstant.HALFYEAR_PAID == payMode) {
            factor = 6;
        } else if (ContractConstant.YEAR_PAID == payMode) {
            factor = 12;
        }

        return factor;
    }

    public Integer insertCollectRent(CollectRent collectRent) {
        return collectRentRepository.insertCollectRent(collectRent);
    }

    @Override
    public Long getCollectRentCountByTypeAndPayDate(Integer type, Date payDate, Long id) {
        return collectRentRepository.getCollectRentCountByTypeAndPayDate(type, payDate, id);
    }
}
