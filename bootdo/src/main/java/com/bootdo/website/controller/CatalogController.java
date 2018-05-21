package com.bootdo.website.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.website.domain.CatalogDO;
import com.bootdo.website.service.CatalogService;

/**
 * 
 * 网站目录
 * @author zmy
 * @email 260173295@qq.com
 * @date 2018-04-21 23:02:42
 */
 
@Controller
@RequestMapping("/website/catalog")
public class CatalogController {
	@Autowired
	private CatalogService catalogService;
	
	@GetMapping()
	@RequiresPermissions("website:catalog:catalog")
	String Catalog(){
	    return "website/catalog/catalog";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("website:catalog:catalog")
	public  List<CatalogDO>  list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CatalogDO> catalogList = catalogService.list(query);
		return catalogList;
	}
	
	@GetMapping("/add/{pId}")
	@RequiresPermissions("website:catalog:add")
	String add(@PathVariable("pId") Integer pId, Model model) {
		model.addAttribute("pId", pId);
		if (pId == 0) {
			model.addAttribute("pName", "根目录");
		} else {
			model.addAttribute("pName", catalogService.get(pId).getName());
		}
		return "website/catalog/add";
	}

	@GetMapping("/edit/{catalogId}")
	@RequiresPermissions("website:catalog:edit")
	String edit(@PathVariable("catalogId") Integer catalogId,Model model){
		CatalogDO catalog = catalogService.get(catalogId);
		model.addAttribute("pName", catalog.getParentId()==0?"根目录":catalogService.get(catalog.getParentId()).getName());
		model.addAttribute("catalog", catalog);
	    return "website/catalog/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("website:catalog:add")
	public R save( CatalogDO catalog){
		//唯一性校验
		boolean flag=catalogService.checkUnique(catalog);
		if(flag){
			return R.error("目录名称["+catalog.getName()+"]已存在系统");
		}
		if(catalogService.save(catalog)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("website:catalog:edit")
	public R update( CatalogDO catalog){
		//唯一性校验
		/*boolean flag=catalogService.checkUnique(catalog);
		if(flag){
			return R.error("目录名称["+catalog.getName()+"]已存在系统");
		}*/
		catalogService.update(catalog);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("website:catalog:remove")
	public R remove( Integer catalogId){
		if(catalogService.remove(catalogId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("website:catalog:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] catalogIds){
		catalogService.batchRemove(catalogIds);
		return R.ok();
	}
	
}
