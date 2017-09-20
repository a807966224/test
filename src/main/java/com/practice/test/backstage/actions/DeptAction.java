package com.practice.test.backstage.actions;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.test.backstage.beans.Dept;
import com.practice.test.backstage.currency.BaseController;
import com.practice.test.backstage.service.DeptService;

/**
 * 部门控制器
 * 
 * @author Scott
 *
 */
// 注册到spring容器中
@Controller
@RequestMapping("/dept")
public class DeptAction extends BaseController{

	@Resource
	DeptService deptService;

	/**
	 * 跳转至人员管理界面
	 * 
	 * @param mode
	 * @return
	 */
	@RequestMapping("/deptList")
	public String toDept(Model model, Dept dept,HttpServletRequest request) {
		
		
		//获取查询数据数量
		model.addAttribute("pagers", deptService.getDeptForPage(dept.getSkip(), dept.getSize(), request.getRequestURI()));
		
		model.addAttribute("dept", dept);
		
		return "backstage/dept/deptList";
	}
	
	@RequestMapping("/edit")
	public String edit(Dept dept,Model model,@RequestParam(required=false) boolean readOnly) {
		
		Integer tmpSkip = dept.getSkip();
		
		//获取唯一数据
		if(dept.getId() != null) {
			dept = deptService.get(dept);
		}
		
		dept.setSkip(tmpSkip);
		//存放至封装类中去
		model.addAttribute("bean", dept);
		
		model.addAttribute("readOnly", readOnly);
		
		return "backstage/dept/deptEdit";
	}
	
	@RequestMapping("/save")
	public String save(Dept dept,Model model) {
		
		Integer tmpSkip = dept.getSkip();
		
		if(dept.getId() == null) {
			deptService.insert(dept);
		}else {
			deptService.update(dept);
		}
		
		return "redirect:/dept/deptList?skip="+tmpSkip;
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(name = "id") Long[] ids,@RequestParam(name = "skip") Integer skip) {
		
		deptService.delete(ids);
		
		return "redirect:/dept/deptList?skip="+skip;
	}
	
}
