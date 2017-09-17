package com.practice.test.backstage.actions;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.test.backstage.beans.Dept;
import com.practice.test.backstage.currency.PagerList;
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
public class DeptAction {

	@Resource
	DeptService deptService;

	/**
	 * 跳转至人员管理界面
	 * 
	 * @param mode
	 * @return
	 */
	@RequestMapping("/deptList")
	public String toDept(Model model, Dept dept,@RequestParam(required = false, defaultValue = "1") Integer skip,
			@RequestParam(required = false, defaultValue = "2") Integer size,HttpServletRequest request) {
		
		
		//获取查询数据数量
		model.addAttribute("pagers", deptService.getDeptForPage(skip, size, request.getRequestURI()));
		
		model.addAttribute("dept", dept);
		
		return "backstage/dept/deptList";
	}
	
	@RequestMapping("/edit")
	public String edit(Dept dept,Model model) {
		
		//获取唯一数据
		if(dept.getId() != null) {
			dept = deptService.get(dept);
		}
		
		//存放至封装类中去
		model.addAttribute("bean", dept);
		
		//待添加      查询部门集合   放置在人员编辑界面
		
		return "backstage/dept/deptEdit";
	}
	
	@RequestMapping("/save")
	public String save(Dept dept,Model model) {
		
		if(dept.getId() == null) {
			deptService.insert(dept);
		}else {
			deptService.update(dept);
		}
		
		return "redirect:/dept/deptList";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(name = "id") Long[] ids) {
		
		deptService.delete(ids);
		
		return "redirect:/dept/deptList";
	}
	
}
