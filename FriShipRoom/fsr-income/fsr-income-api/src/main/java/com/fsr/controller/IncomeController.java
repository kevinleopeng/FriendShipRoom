package com.fsr.controller;


import com.fsr.constant.PageConstant;
import com.fsr.constant.ResultCode;
import com.fsr.datatransfer.DataTransfer;
import com.fsr.domain.Income;
import com.fsr.dto.PaginatedResult;
import com.fsr.dto.StatusResult;
import com.fsr.service.IncomeService;
import com.fsr.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Hasee on 2017/4/25.
 */
@RestController
@RequestMapping("/income")
@CrossOrigin(origins = "http://localhost:8088")
public class IncomeController {
    @Autowired
    private IncomeService incomeService;

    @Autowired
    @Qualifier("incomeDataTransfer")
    private DataTransfer incomeDataTransfer;

    @GetMapping
    public ResponseEntity<?> getPagedIncomes(@RequestParam(value = "page", required = false) String pageString,
                                      @RequestParam(value = "pageSize", required = false) String perPageString) {
        int page = PageUtil.parsePage(pageString, PageConstant.PAGE);
        int perPage = PageUtil.parsePerPage(perPageString, PageConstant.PER_PAGE);

        return ResponseEntity
                .ok(new PaginatedResult()
                        .setData(incomeDataTransfer.transfer(incomeService.getIncomesByPage(page, perPage)))
                        .setCurrentPage(page)
                        .setTotal(incomeService.selectCount())
                        .setTotalPage(incomeService.getTotalPage(perPage)));
                        //.setTotal(incomeService.selectCount());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addExpense(@RequestBody Income income) {
        StatusResult statusResult = new StatusResult();
        try{
            incomeService.insertIncome(income);

            statusResult
                    .setCode(ResultCode.SUCCESS)
                    .setMessage("添加收入成功");
        } catch(Exception e) {
            e.printStackTrace();
            statusResult
                    .setCode(ResultCode.ERROR)
                    .setMessage("添加收入失败");
        }

        return ResponseEntity
                .ok(statusResult);
    }

    public IncomeController(){
        System.out.println("income controller init");
    }
}
