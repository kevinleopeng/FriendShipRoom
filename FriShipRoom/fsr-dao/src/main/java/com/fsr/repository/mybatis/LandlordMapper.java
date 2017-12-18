package com.fsr.repository.mybatis;

import com.fsr.domain.Contract;
import com.fsr.domain.Landlord;
import com.fsr.repository.ContractRepository;
import com.fsr.repository.LandlordRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
@Mapper
public interface LandlordMapper extends LandlordRepository {
    @Override
    List<Landlord> getLandlordsByPage(@Param("offset") Integer offset, @Param("perPage") Integer perPage);

    @Override
    Long selectCount();

    @Override
    List<Landlord> getAllLandlords();

    @Override
    Integer insertLandlord(Landlord landlord);


}
