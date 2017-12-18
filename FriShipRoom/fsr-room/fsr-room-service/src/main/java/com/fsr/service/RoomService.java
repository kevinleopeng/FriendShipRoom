package com.fsr.service;

import com.fsr.domain.Room;

import java.util.List;

/**
 * Created by Hasee on 2017/7/17.
 */
public interface RoomService {
    List<Room> getRoomsByHomeId(Long homeId);

    List<Room> getRoomsByPage(Integer page, Integer perPage);

    Integer getTotalPage(Integer perPage);

    Integer insertRoom(Room room);

    Long selectCount();
}
