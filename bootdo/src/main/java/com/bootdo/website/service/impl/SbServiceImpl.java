package com.bootdo.website.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootdo.website.dao.SbDao;
import com.bootdo.website.domain.SbDO;
import com.bootdo.website.service.SbService;



@Service
public class SbServiceImpl implements SbService {
	@Autowired
	private SbDao sbDao;
	
	@Override
	public SbDO get(String sbId){
		return sbDao.get(sbId);
	}
	
	@Override
	public List<SbDO> list(Map<String, Object> map){
		return sbDao.list(map);
	}
	
	@Override
	public List<SbDO> listDistinct(Map<String, Object> map){
		return sbDao.listDistinct(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sbDao.count(map);
	}
	
	@Override
	public int save(SbDO sb){
		sb.setSbId(sb.getProfId()+sb.getSbCode());
		return sbDao.save(sb);
	}
	
	@Override
	public int update(SbDO sb){
		return sbDao.update(sb);
	}
	
	@Override
	public int remove(String sbId){
		return sbDao.remove(sbId);
	}
	
	@Override
	public int batchRemove(String[] sbIds){
		return sbDao.batchRemove(sbIds);
	}
	
}
