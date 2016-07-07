package io.vertx.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import io.vertx.web.domain.TbIDAuth;

@Mapper
public interface TbIDAuthMapper {
	TbIDAuth selectById(int id);

	List<TbIDAuth> selectALL();

	List<TbIDAuth> selectByPhone(TbIDAuth auth);
}
