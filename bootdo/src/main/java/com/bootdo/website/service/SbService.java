package com.bootdo.website.service;

import com.bootdo.website.domain.SbDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zmy
 * @email 260173295@qq.com
 * @date 2018-04-28 12:50:21
 */
public interface SbService {
	
	SbDO get(String sbId);
	
	List<SbDO> list(Map<String, Object> map);
	/**
	 * 去重科目
	 * @param map
	 * @return
	 */
	List<SbDO> listDistinct(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SbDO sb);
	
	int update(SbDO sb);
	
	int remove(String sbId);
	
	int batchRemove(String[] sbIds);
}
