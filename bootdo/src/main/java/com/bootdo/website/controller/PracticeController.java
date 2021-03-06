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
import com.bootdo.website.domain.PracticeDO;
import com.bootdo.website.service.PracticeService;

/**
 * 
 * 
 * @author zmy
 * @email 260173295@qq.com
 * @date 2018-05-15 15:44:43
 */
 
@Controller
@RequestMapping("/website/practice")
public class PracticeController {
	@Autowired
	private PracticeService practiceService;
	
	@GetMapping()
	@RequiresPermissions("website:practice:practice")
	String Practice(){
	    return "website/practice/practice";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("website:practice:practice")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PracticeDO> practiceList = practiceService.list(query);
		int total = practiceService.count(query);
		PageUtils pageUtils = new PageUtils(practiceList, total);
		return pageUtils;
	}
	
	
	@GetMapping("/add")
	@RequiresPermissions("website:practice:add")
	String add(){
	    return "website/practice/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("website:practice:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		PracticeDO practice = practiceService.get(id);
		model.addAttribute("practice", practice);
	    return "website/practice/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("website:practice:add")
	public R save( PracticeDO practice){
		if(practiceService.save(practice)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("website:practice:edit")
	public R update( PracticeDO practice){
		practiceService.update(practice);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("website:practice:remove")
	public R remove( Integer id){
		if(practiceService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("website:practice:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		practiceService.batchRemove(ids);
		return R.ok();
	}
	
}
