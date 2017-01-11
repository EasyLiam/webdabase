package com.webdata.mapper;

import com.webdata.pojo.DcUser;
import com.webdata.pojo.DcUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DcUserMapper {
    int countByExample(DcUserExample example);

    int deleteByExample(DcUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DcUser record);

    int insertSelective(DcUser record);

    List<DcUser> selectByExample(DcUserExample example);

    DcUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DcUser record, @Param("example") DcUserExample example);

    int updateByExample(@Param("record") DcUser record, @Param("example") DcUserExample example);

    int updateByPrimaryKeySelective(DcUser record);

    int updateByPrimaryKey(DcUser record);
}