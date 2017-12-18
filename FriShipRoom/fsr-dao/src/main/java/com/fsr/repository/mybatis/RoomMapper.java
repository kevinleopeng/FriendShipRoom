package com.fsr.repository.mybatis;

import com.fsr.domain.Renter;
import com.fsr.domain.Room;
import com.fsr.repository.RenterRepository;
import com.fsr.repository.RoomRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
@Mapper
public interface RoomMapper extends RoomRepository {
    @Override
    List<Room> getRoomsByHomeId(@Param("homeId") Long homeId);

    @Override
    List<Room> getRoomsByPage(@Param("offset") Integer offset, @Param("perPage") Integer perPage);

    @Override
    Long selectCount();

    @Override
    Integer insertRoom(Room room);
}
