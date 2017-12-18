package com.fsr.controller;


import com.fsr.constant.ContractConstant;
import com.fsr.constant.PageConstant;
import com.fsr.constant.ResultCode;
import com.fsr.datatransfer.DataTransfer;
import com.fsr.domain.Contract;
import com.fsr.dto.PaginatedResult;
import com.fsr.dto.StatusResult;
import com.fsr.quartz.CollectRentTask;
import com.fsr.service.CollectRentService;
import com.fsr.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Hasee on 2017/4/25.
 */
@RestController
@RequestMapping("/collectrent")
@CrossOrigin(origins = "http://localhost:8088")
public class CollectRentController {
    @Autowired
    private CollectRentService collectRentService;

    @Autowired
    @Qualifier("collectRentDataTransfer")
    private DataTransfer collectRentDataTransfer;

    @Autowired
    private CollectRentTask collectRentTask;

    @GetMapping("/getCollectRentByType")
    public ResponseEntity<?> getCollectRentByType(@RequestParam(value = "page", required = false) String pageString,
                                      @RequestParam(value = "pageSize", required = false) String perPageString,
                                      @RequestParam(value = "type", required = false) Integer type) {
        int page = PageUtil.parsePage(pageString, PageConstant.PAGE);
        int perPage = PageUtil.parsePerPage(perPageString, PageConstant.PER_PAGE);

         return ResponseEntity
                .ok(new PaginatedResult()
                        .setData(collectRentDataTransfer.transfer(collectRentService.getCollectRentContractsByPageAndType(page, perPage, type), type))
                        .setCurrentPage(page)
                        .setTotal(collectRentService.selectCountByType(type))
                        .setTotalPage(collectRentService.getTotalPage(perPage, type)));
                     //   .setTotal(expenseService.selectCount());
    }

    @GetMapping("/refreshPayDayAndNotify")
    public ResponseEntity<?> refreshPayDayAndNotify() {
        StatusResult result = new StatusResult();
        try {
            collectRentTask.run();
            result.setCode(ResultCode.SUCCESS).setMessage("更新通知成功");
        } catch(Exception e) {
            e.printStackTrace();
            result.setCode(ResultCode.ERROR).setMessage("更新通知失败");
        }

        return ResponseEntity
                .ok(result);
    }

    public CollectRentController(){
        System.out.println("collectrent controller init");
    }
}
