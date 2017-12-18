package com.fsr.controller;


import com.fsr.constant.ContractConstant;
import com.fsr.constant.PageConstant;
import com.fsr.constant.ResultCode;
import com.fsr.datatransfer.DataTransfer;
import com.fsr.domain.Contract;

import com.fsr.dto.PaginatedResult;
import com.fsr.dto.StatusResult;
import com.fsr.service.ContractService;
import com.fsr.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Hasee on 2017/4/25.
 */
@RestController
@RequestMapping("/contract")
@CrossOrigin(origins = "http://localhost:8088")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    @Qualifier("contractDataTransfer")
    private DataTransfer contractDataTransfer;

    @GetMapping("/getHouseContract")
    public ResponseEntity<?> getHouseContracts(@RequestParam(value = "page", required = false) String pageString,
                                      @RequestParam(value = "pageSize", required = false) String perPageString) {
        int page = PageUtil.parsePage(pageString, PageConstant.PAGE);
        int perPage = PageUtil.parsePerPage(perPageString, PageConstant.PER_PAGE);

         return ResponseEntity
                .ok(new PaginatedResult()
                        .setData(contractDataTransfer.transfer(contractService.getLandlordContractsByPage(page, perPage), ContractConstant.HOUSE_CONTRACT))
                        .setCurrentPage(page)
                        .setTotal(contractService.selectCountByType(ContractConstant.HOUSE_CONTRACT))
                        .setTotalPage(contractService.getTotalPage(perPage, ContractConstant.HOUSE_CONTRACT)));
                     //   .setTotal(expenseService.selectCount());
    }

    @GetMapping("/getRoomContract")
    public ResponseEntity<?> getRoomContracts(@RequestParam(value = "page", required = false) String pageString,
                                         @RequestParam(value = "pageSize", required = false) String perPageString) {
        int page = PageUtil.parsePage(pageString, PageConstant.PAGE);
        int perPage = PageUtil.parsePerPage(perPageString, PageConstant.PER_PAGE);

        return ResponseEntity
                .ok(new PaginatedResult()
                        .setData(contractDataTransfer.transfer(contractService.getRenterContractsByPage(page, perPage), ContractConstant.ROOM_CONTRACT))
                        .setCurrentPage(page)
                        .setTotal(contractService.selectCountByType(ContractConstant.ROOM_CONTRACT))
                        .setTotalPage(contractService.getTotalPage(perPage, ContractConstant.ROOM_CONTRACT)));
        //   .setTotal(expenseService.selectCount());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addContract(@RequestBody Contract contract) {
        StatusResult statusResult = new StatusResult();
        try{
            contractService.insertContract(contract);

            statusResult
                    .setCode(ResultCode.SUCCESS)
                    .setMessage("添加合同成功");
        } catch(Exception e) {
            e.printStackTrace();
            statusResult
                    .setCode(ResultCode.ERROR)
                    .setMessage("添加合同失败");
        }

        return ResponseEntity
                .ok(statusResult);
    }



    public ContractController(){
        System.out.println("contract controller init");
    }
}
