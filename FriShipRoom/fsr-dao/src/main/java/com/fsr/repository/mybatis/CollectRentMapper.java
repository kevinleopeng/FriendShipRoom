package com.fsr.repository.mybatis;

import com.fsr.domain.CollectRent;
import com.fsr.domain.Contract;
import com.fsr.repository.CollectRentRepository;
import com.fsr.repository.ContractRepository;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Hasee on 2017/4/25.
 */
@Mapper
public interface CollectRentMapper extends CollectRentRepository {
    @Override
    List<CollectRent> getCollectRentContractsByPageAndType(@Param("offset") Integer offset, @Param("perPage") Integer perPage, @Param("type") Integer type);

    @Override
    Long selectCountByType(Integer type);

    @Override
    Integer insertCollectRent(CollectRent collectRent);

    @Override
    Long getCollectRentCountByTypeAndPayDate(@Param("type") Integer type, @Param("payDate") Date payDate, @Param("id")Long id);
}
