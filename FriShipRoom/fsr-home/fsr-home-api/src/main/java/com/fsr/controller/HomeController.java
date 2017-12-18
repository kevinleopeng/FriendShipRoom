package com.fsr.controller;

import com.fsr.constant.ContractConstant;
import com.fsr.constant.PageConstant;
import com.fsr.constant.ResultCode;
import com.fsr.datatransfer.DataTransfer;
import com.fsr.domain.Contract;
import com.fsr.domain.Home;
import com.fsr.dto.PaginatedResult;
import com.fsr.dto.StatusResult;
import com.fsr.service.HomeService;
import com.fsr.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Hasee on 2017/4/25.
 */
@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "http://localhost:8088")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @Autowired
    @Qualifier("homeDataTransfer")
    private DataTransfer homeDataTransfer;

    @GetMapping
    public ResponseEntity<?> getAllHomes(@RequestParam(value = "page", required = false) String pageString,
                                      @RequestParam(value = "pageSize", required = false) String perPageString) {
        int page = PageUtil.parsePage(pageString, PageConstant.PAGE);
        int perPage = PageUtil.parsePerPage(perPageString, PageConstant.PER_PAGE);

        return ResponseEntity
                .ok(new PaginatedResult()
                        .setData(homeService.getAllHomes())
                        .setCurrentPage(page));
                       // .setTotalPage(categoryService.getTotalPage(perPage)))
    }

    @GetMapping("/getHomesByPage")
    public ResponseEntity<?> getHomesByPage(@RequestParam(value = "page", required = false) String pageString,
                                               @RequestParam(value = "pageSize", required = false) String perPageString) {
        int page = PageUtil.parsePage(pageString, PageConstant.PAGE);
        int perPage = PageUtil.parsePerPage(perPageString, PageConstant.PER_PAGE);

        return ResponseEntity
                .ok(new PaginatedResult()
                        .setData(homeDataTransfer.transfer(homeService.getHomesByPage(page, perPage)))
                        .setCurrentPage(page)
                        .setTotal(homeService.selectCount())
                        .setTotalPage(homeService.getTotalPage(perPage)));
        //   .setTotal(expenseService.selectCount());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addContract(@RequestBody Home home) {
        StatusResult statusResult = new StatusResult();
        try{
            homeService.insertHome(home);

            statusResult
                    .setCode(ResultCode.SUCCESS)
                    .setMessage("添加房屋成功");
        } catch(Exception e) {
            e.printStackTrace();
            statusResult
                    .setCode(ResultCode.ERROR)
                    .setMessage("添加房屋失败");
        }

        return ResponseEntity
                .ok(statusResult);
    }
   public HomeController(){
        System.out.println("home controller init");
    }
}
