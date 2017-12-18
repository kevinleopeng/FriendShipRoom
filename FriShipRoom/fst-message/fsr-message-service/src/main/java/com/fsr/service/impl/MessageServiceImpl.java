package com.fsr.service.impl;

import com.fsr.constant.NotifyConstant;
import com.fsr.domain.Landlord;
import com.fsr.domain.Message;
import com.fsr.domain.Renter;
import com.fsr.http.HttpClientUtil;
import com.fsr.repository.MessageRepository;
import com.fsr.service.LandlordService;
import com.fsr.service.MessageService;
import com.fsr.service.RenterService;
import com.fsr.util.PageUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hasee on 2017/8/29.
 */
@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private RenterService renterService;

    @Autowired
    private LandlordService landlordService;

    @Autowired
    private HttpClientUtil clientUtil;

    @Override
    public List<Message> getMessagesByPage(Integer page, Integer perPage) {
        Integer offset = PageUtil.calculateOffset(page, perPage);
        return messageRepository.getMessagesByPage(offset, perPage);
    }

    @Override
    public void notify(String message, Integer type) {
        if (type == NotifyConstant.RENTER) {
            notifyRenters(message);
        } else if (type == NotifyConstant.LANDLORD) {
            notifyLandlords(message);
        } else if (type == NotifyConstant.ALL) {
            notifyRenters(message);
            notifyLandlords(message);
        }
    }
    private void notifyRenters(String message) {
        int pages = renterService.getTotalPage(20);
        Map param = new HashMap();

        param.put("Uid", "kevinleopeng");
        param.put("Key", "b6e7085c4e5dcc0224f1");
        param.put("smsText", message);

        for (int i = 0; i < pages; i++) {
            List<Renter> renters = renterService.getRentersByPage(i + 1, 20);
            for (Renter renter : renters) {
                param.put("smsMob", String.valueOf(renter.getPhoneNum()));
                String result = clientUtil.doPost("http://utf8.api.smschinese.cn/", param, "UTF-8");
                if (!StringUtils.isEmpty(result) && Integer.valueOf(result) > 0) {
                    System.out.println("短信通知租客【"+renter.getName()+"】,手机号【"+renter.getPhoneNum()+"】成功");
                } else {
                    System.out.println("短信通知租客【"+renter.getName()+"】,手机号【"+renter.getPhoneNum()+"】失败");
                }

            }
        }
    }

    private void notifyLandlords(String message) {
        int pages = landlordService.getTotalPage(20);
        Map param = new HashMap();

        param.put("Uid", "kevinleopeng");
        param.put("Key", "b6e7085c4e5dcc0224f1");
        param.put("smsText", message);

        for (int i = 0; i < pages; i++) {
            List<Landlord> landlords = landlordService.getLandlordsByPage(i + 1, 20);
            for (Landlord landlord : landlords) {
                param.put("smsMob", String.valueOf(landlord.getPhoneNum()));
                String result = clientUtil.doPost("http://utf8.api.smschinese.cn/", param, "UTF-8");
                if (!StringUtils.isEmpty(result) && Integer.valueOf(result) > 0) {
                    System.out.println("短信通知房东【"+landlord.getName()+"】,手机号【"+landlord.getPhoneNum()+"】成功");
                } else {
                    System.out.println("短信通知房东【"+landlord.getName()+"】,手机号【"+landlord.getPhoneNum()+"】失败");
                }

            }
        }
    }

    @Override
    public Long selectCount() {
        return messageRepository.selectCount();
    }

    @Override
    public Integer getTotalPage(Integer perPage) {
        return PageUtil.calculateTotalPage(selectCount(), perPage);
    }

    @Override
    public Integer insertMessage(Message message) {
        return messageRepository.insertMessage(message);
    }

    @Override
    public Integer updateMessage(Message message) {
        return messageRepository.updateMessage(message);
    }
}
