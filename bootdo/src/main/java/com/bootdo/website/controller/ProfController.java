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
import com.bootdo.website.domain.ProfDO;
import com.bootdo.website.service.ProfService;

/**
 * 
 * 
 * @author zmy
 * @email 260173295@qq.com
 * @date 2018-04-28 12:50:21
 */
 
@Controller
@RequestMapping("/website/prof")
public class ProfController {
	@Autowired
	private ProfService profService;
	
	@GetMapping()
	@RequiresPermissions("website:prof:prof")
	String Prof(){
	    return "website/prof/prof";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("website:prof:prof")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ProfDO> profList = profService.list(query);
		int total = profService.count(query);
		PageUtils pageUtils = new PageUtils(profList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("website:prof:add")
	String add(){
	    return "website/prof/add";
	}

	@GetMapping("/edit/{profId}")
	@RequiresPermissions("website:prof:edit")
	String edit(@PathVariable("profId") String profId,Model model){
		ProfDO prof = profService.get(profId);
		model.addAttribute("prof", prof);
	    return "website/prof/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("website:prof:add")
	public R save( ProfDO prof){
		prof.setOpertor("1");//1：新建
		boolean flag = profService.checkUnique(prof);
		if(flag){
			return R.error("专业代码["+prof.getProfId()+"]或者专业名称["+prof.getProfName()+"]已存在系统");
		}
		if(profService.save(prof)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("website:prof:edit")
	public R update( ProfDO prof){
		prof.setOpertor("2");//1：编辑
		boolean flag = profService.checkUnique(prof);
		if(flag){
			return R.error("专业名称["+prof.getProfName()+"]已存在系统");
		}
		profService.update(prof);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("website:prof:remove")
	public R remove( String profId){
		if(profService.remove(profId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("website:prof:batchRemove")
	public R remove(@RequestParam("ids[]") String[] profIds){
		profService.batchRemove(profIds);
		return R.ok();
	}
	
}
