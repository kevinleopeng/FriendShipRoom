package com.fsr.controller;

import com.fsr.constant.PageConstant;
import com.fsr.constant.ResultCode;
import com.fsr.datatransfer.RoomDataTransfer;
import com.fsr.domain.Home;
import com.fsr.domain.Room;
import com.fsr.dto.PaginatedResult;
import com.fsr.dto.StatusResult;
import com.fsr.service.RoomService;
import com.fsr.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Hasee on 2017/7/17.
 */
@RestController
@RequestMapping("/room")
@CrossOrigin(origins = "http://localhost:8088")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @Autowired
    @Qualifier("roomDataTransfer")
    private RoomDataTransfer roomDataTransfer;

    @GetMapping("/getRoomsByHomeId")
    public ResponseEntity<?> getRoomsByHomeId(@RequestParam(value = "homeId", required = true) Long homeId) {
        return ResponseEntity
                .ok(new PaginatedResult()
                        .setData(roomDataTransfer.transfer(roomService.getRoomsByHomeId(homeId))));
    }

    @GetMapping("/getRoomsByPage")
    public ResponseEntity<?> getRoomsByPage(@RequestParam(value = "page", required = false) String pageString,
                                            @RequestParam(value = "pageSize", required = false) String perPageString) {
        int page = PageUtil.parsePage(pageString, PageConstant.PAGE);
        int perPage = PageUtil.parsePerPage(perPageString, PageConstant.PER_PAGE);

        return ResponseEntity
                .ok(new PaginatedResult()
                        .setData(roomDataTransfer.transfer(roomService.getRoomsByPage(page, perPage)))
                        .setCurrentPage(page)
                        .setTotal(roomService.selectCount())
                        .setTotalPage(roomService.getTotalPage(perPage)));
        //   .setTotal(expenseService.selectCount());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addRoom(@RequestBody Room room) {
        StatusResult statusResult = new StatusResult();
        try{
            roomService.insertRoom(room);

            statusResult
                    .setCode(ResultCode.SUCCESS)
                    .setMessage("添加单间成功");
        } catch(Exception e) {
            e.printStackTrace();
            statusResult
                    .setCode(ResultCode.ERROR)
                    .setMessage("添加单间失败");
        }

        return ResponseEntity
                .ok(statusResult);
    }
}
