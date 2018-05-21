package com.bootdo.website.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.website.dao.CatalogDao;
import com.bootdo.website.domain.CatalogDO;
import com.bootdo.website.service.CatalogService;



@Service
public class CatalogServiceImpl implements CatalogService {
	@Autowired
	private CatalogDao catalogDao;
	
	@Override
	public CatalogDO get(Integer catalogId){
		return catalogDao.get(catalogId);
	}
	
	@Override
	public List<CatalogDO> list(Map<String, Object> map){
		return catalogDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return catalogDao.count(map);
	}
	
	@Override
	public int save(CatalogDO catalog){
		return catalogDao.save(catalog);
	}
	
	@Override
	public int update(CatalogDO catalog){
		return catalogDao.update(catalog);
	}
	
	@Override
	public int remove(Integer catalogId){
		return catalogDao.remove(catalogId);
	}
	
	@Override
	public int batchRemove(Integer[] catalogIds){
		return catalogDao.batchRemove(catalogIds);
	}

	@Override
	public boolean checkUnique(CatalogDO catalog) {
		return catalogDao.checkUnique(catalog);
	}
	
}
