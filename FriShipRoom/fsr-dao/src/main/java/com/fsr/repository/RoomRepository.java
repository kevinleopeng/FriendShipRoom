package com.fsr.repository;

import com.fsr.domain.Home;
import com.fsr.domain.Room;

import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
public interface RoomRepository {
    List<Room> getRoomsByHomeId(Long homeId);

    List<Room> getRoomsByPage(Integer offset, Integer perPage);

    Long selectCount();

    Integer insertRoom(Room room);
}
