package com.fsr.quartz;

import com.fsr.constant.ContractConstant;
import com.fsr.domain.Contract;
import com.fsr.service.CollectRentService;
import com.fsr.service.ContractService;
import com.fsr.util.DateUtil;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Hasee on 2017/7/23.
 */
@Service
public class CollectRentTask implements Job {
    @Autowired
    private ContractService contractService;

    @Autowired
    private CollectRentService collectRentService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println ("Scheduling Tasks Examples By Cron: The time is now " + dateFormat ().format (new Date()));
    }

    public void run() {
        Date currentDate = new Date();
        String nextFiveDate = DateUtil.getMovedDate(currentDate, 5);
        List<Contract> contracts = this.contractService.getRenterContractsByCurrentDateAndNextFiveDate(currentDate, nextFiveDate);
        if (null != contracts && contracts.size() > 0) {
            Map<Integer, List<Contract>> map = new HashMap(64);
            List<Contract> houseList = new ArrayList(32);
            List<Contract> roomList = new ArrayList(32);

            for (Contract contract: contracts) {
                if (ContractConstant.HOUSE_CONTRACT == contract.getType()) {
                    houseList.add(contract);
                } else {
                    roomList.add(contract);
                }
            }
            map.put(ContractConstant.HOUSE_CONTRACT, houseList);
            map.put(ContractConstant.ROOM_CONTRACT, roomList);
            collectRentService.collectRentByScheduledTask(map);
        }
        System.out.print("aaa");
    }
    private SimpleDateFormat dateFormat(){
        return new SimpleDateFormat ("HH:mm:ss");
    }
}
