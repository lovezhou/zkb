package com.bootdo.website.dao;

import com.bootdo.website.domain.SbDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author zmy
 * @email 260173295@qq.com
 * @date 2018-04-28 12:50:21
 */
@Mapper
public interface SbDao {

	SbDO get(String sbId);
	
	List<SbDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SbDO sb);
	
	int update(SbDO sb);
	
	int remove(String sb_id);
	
	int batchRemove(String[] sbIds);

	List<SbDO> listDistinct(Map<String, Object> map);
}
