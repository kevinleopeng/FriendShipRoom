package com.fsr.controller;


import com.fsr.constant.PageConstant;
import com.fsr.constant.ResultCode;
import com.fsr.domain.Landlord;
import com.fsr.dto.PaginatedResult;
import com.fsr.dto.StatusResult;
import com.fsr.service.LandlordService;
import com.fsr.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Hasee on 2017/4/25.
 */
@RestController
@RequestMapping("/landlord")
@CrossOrigin(origins = "http://localhost:8088")
public class LandlordController {
    @Autowired
    private LandlordService landlordService;

    @GetMapping("/getLandlords")
    public ResponseEntity<?> getLandlords(@RequestParam(value = "page", required = false) String pageString,
                                      @RequestParam(value = "pageSize", required = false) String perPageString) {
        int page = PageUtil.parsePage(pageString, PageConstant.PAGE);
        int perPage = PageUtil.parsePerPage(perPageString, PageConstant.PER_PAGE);

         return ResponseEntity
                .ok(new PaginatedResult()
                        .setData(landlordService.getLandlordsByPage(page, perPage))
                        .setCurrentPage(page)
                        .setTotal(landlordService.selectCount())
                        .setTotalPage(landlordService.getTotalPage(perPage)));
    }

    @GetMapping("/getAllLandlords")
    public ResponseEntity<?> getAllLandlords() {
        return ResponseEntity
                .ok(new PaginatedResult()
                        .setData(landlordService.getAllLandlords()));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addLandlord(@RequestBody Landlord landlord) {
        StatusResult statusResult = new StatusResult();
        try{
            landlordService.insertLandlord(landlord);

            statusResult
                    .setCode(ResultCode.SUCCESS)
                    .setMessage("添加房东信息成功");
        } catch(Exception e) {
            e.printStackTrace();
            statusResult
                    .setCode(ResultCode.ERROR)
                    .setMessage("添加房东信息失败");
        }

        return ResponseEntity
                .ok(statusResult);
    }



    public LandlordController(){
        System.out.println("contract controller init");
    }
}
