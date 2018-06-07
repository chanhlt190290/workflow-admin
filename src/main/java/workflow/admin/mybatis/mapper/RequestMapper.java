package workflow.admin.mybatis.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import workflow.admin.mybatis.model.Request;


@Mapper
public interface RequestMapper{

    public Request getRequest(@Param("id") int id);

}