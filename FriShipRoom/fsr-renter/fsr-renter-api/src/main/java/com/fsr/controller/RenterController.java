package com.fsr.controller;

import com.fsr.constant.PageConstant;
import com.fsr.constant.ResultCode;
import com.fsr.domain.Renter;
import com.fsr.dto.PaginatedResult;
import com.fsr.dto.StatusResult;
import com.fsr.service.RenterService;
import com.fsr.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Hasee on 2017/4/25.
 */
@RestController
@RequestMapping("/renter")
@CrossOrigin(origins = "http://localhost:8088")
public class RenterController {
    @Autowired
    private RenterService renterService;

    @GetMapping("/getRentersByType")
    public ResponseEntity<?> getRentersByType(@RequestParam("type") Integer type) {

        return ResponseEntity
                .ok(new PaginatedResult()
                        .setData(renterService.getRentersByType(type)));
                     //   .setTotal(expenseService.selectCount());
    }
    @GetMapping("/getRenters")
    public ResponseEntity<?> getRenters(@RequestParam(value = "page", required = false) String pageString,
                                          @RequestParam(value = "pageSize", required = false) String perPageString) {
        int page = PageUtil.parsePage(pageString, PageConstant.PAGE);
        int perPage = PageUtil.parsePerPage(perPageString, PageConstant.PER_PAGE);

        return ResponseEntity
                .ok(new PaginatedResult()
                        .setData(renterService.getRentersByPage(page, perPage))
                        .setCurrentPage(page)
                        .setTotal(renterService.selectCount())
                        .setTotalPage(renterService.getTotalPage(perPage)));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addRenter(@RequestBody Renter renter) {
        StatusResult statusResult = new StatusResult();
        try{
            renterService.insertRenter(renter);

            statusResult
                    .setCode(ResultCode.SUCCESS)
                    .setMessage("添加租客信息成功");
        } catch(Exception e) {
            e.printStackTrace();
            statusResult
                    .setCode(ResultCode.ERROR)
                    .setMessage("添加租客信息失败");
        }

        return ResponseEntity
                .ok(statusResult);
    }
    public RenterController(){
        System.out.println("renter controller init");
    }
}
