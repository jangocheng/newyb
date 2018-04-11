package com.yiban.erp.dao;

import com.yiban.erp.dto.ReceiveListReq;
import com.yiban.erp.entities.RepertoryIn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface RepertoryInMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RepertoryIn record);

    int insertSelective(RepertoryIn record);

    RepertoryIn selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RepertoryIn record);

    int updateByPrimaryKey(RepertoryIn record);

    List<RepertoryIn> getList(ReceiveListReq listReq);

    RepertoryIn getByRefOrder(@Param("companyId") Integer companyId,
                              @Param("refType") String refType,
                              @Param("refOrderId") Long refOrderId);

    int setCheckStatus(@Param("id") Long repositoryOrderId,
                       @Param("status") String name,
                       @Param("updateBy") String nickname,
                       @Param("updateTime") Date date);

}