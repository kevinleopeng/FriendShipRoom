package com.fsr.controller;


import com.fsr.constant.PageConstant;
import com.fsr.constant.ResultCode;
import com.fsr.datatransfer.DataTransfer;
import com.fsr.domain.Message;
import com.fsr.dto.MessageFormDTO;
import com.fsr.dto.PaginatedResult;
import com.fsr.dto.StatusResult;
import com.fsr.service.MessageService;
import com.fsr.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * Created by Hasee on 2017/4/25.
 */
@RestController
@RequestMapping("/message")
@CrossOrigin(origins = "http://localhost:8088")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @Autowired
    @Qualifier("messageDataTransfer")
    private DataTransfer messageDataTransfer;

    @GetMapping("/getMessages")
    public ResponseEntity<?> getMessages(@RequestParam(value = "page", required = false) String pageString,
                                      @RequestParam(value = "pageSize", required = false) String perPageString) {
        int page = PageUtil.parsePage(pageString, PageConstant.PAGE);
        int perPage = PageUtil.parsePerPage(perPageString, PageConstant.PER_PAGE);

         return ResponseEntity
                .ok(new PaginatedResult()
                        .setData(messageDataTransfer.transfer(messageService.getMessagesByPage(page, perPage)))
                        .setCurrentPage(page)
                        .setTotal(messageService.selectCount())
                        .setTotalPage(messageService.getTotalPage(perPage)));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addMessage(@RequestBody MessageFormDTO messageForm) {
        StatusResult statusResult = new StatusResult();
        Date now = new Date();
        Message msg = new Message();
        try{
            messageService.notify(messageForm.getMessage(), messageForm.getPeopleType());
            msg.setAddTime(now);
            msg.setModifyTime(now);
            msg.setMessage(messageForm.getMessage());
            messageService.insertMessage(msg);

            statusResult
                    .setCode(ResultCode.SUCCESS)
                    .setMessage("添加信息成功");
        } catch(Exception e) {
            e.printStackTrace();
            statusResult
                    .setCode(ResultCode.ERROR)
                    .setMessage("添加信息失败");
        }

        return ResponseEntity
                .ok(statusResult);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateMessage(@RequestBody Message message) {
        StatusResult statusResult = new StatusResult();
        Date now = new Date();
        try{
            message.setModifyTime(now);
            messageService.updateMessage(message);

            statusResult
                    .setCode(ResultCode.SUCCESS)
                    .setMessage("修改信息成功");
        } catch(Exception e) {
            e.printStackTrace();
            statusResult
                    .setCode(ResultCode.ERROR)
                    .setMessage("修改信息失败");
        }

        return ResponseEntity
                .ok(statusResult);
    }

    public MessageController(){
        System.out.println("contract controller init");
    }
}
