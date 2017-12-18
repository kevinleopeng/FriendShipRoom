package com.fsr.service.impl;

import com.fsr.domain.Landlord;
import com.fsr.domain.Room;
import com.fsr.repository.RoomRepository;
import com.fsr.service.RoomService;
import com.fsr.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hasee on 2017/7/17.
 */
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> getRoomsByHomeId(Long homeId) {
        return roomRepository.getRoomsByHomeId(homeId);
    }

    @Override
    public List<Room> getRoomsByPage(Integer page, Integer perPage) {
        Integer offset = PageUtil.calculateOffset(page, perPage);
        return roomRepository.getRoomsByPage(offset, perPage);
    }

    @Override
    public Integer insertRoom(Room room) {
        return roomRepository.insertRoom(room);
    }

    @Override
    public Integer getTotalPage(Integer perPage) {
        return PageUtil.calculateTotalPage(selectCount(), perPage);
    }

    @Override
    public Long selectCount() {
        return roomRepository.selectCount();
    }
}
