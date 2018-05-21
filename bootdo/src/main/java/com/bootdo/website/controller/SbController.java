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

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.website.domain.SbDO;
import com.bootdo.website.service.SbService;

/**
 * 
 * 
 * @author zmy
 * @email 260173295@qq.com
 * @date 2018-04-28 12:50:21
 */
 
@Controller
@RequestMapping("/website/sb")
public class SbController {
	@Autowired
	private SbService sbService;
	
	@GetMapping()
	@RequiresPermissions("website:sb:sb")
	String Sb(){
	    return "website/sb/sb";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("website:sb:sb")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SbDO> sbList = sbService.list(query);
		int total = sbService.count(query);
		PageUtils pageUtils = new PageUtils(sbList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("website:sb:add")
	String add(){
	    return "website/sb/add";
	}

	@GetMapping("/edit/{sbId}")
	@RequiresPermissions("website:sb:edit")
	String edit(@PathVariable("sbId") String sbId,Model model){
		SbDO sb = sbService.get(sbId);
		model.addAttribute("sb", sb);
	    return "website/sb/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("website:sb:add")
	public R save( SbDO sb){
		if(sbService.save(sb)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("website:sb:edit")
	public R update( SbDO sb){
		sbService.update(sb);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("website:sb:remove")
	public R remove( String sbId){
		if(sbService.remove(sbId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("website:sb:batchRemove")
	public R remove(@RequestParam("ids[]") String[] sbIds){
		sbService.batchRemove(sbIds);
		return R.ok();
	}
	
}
