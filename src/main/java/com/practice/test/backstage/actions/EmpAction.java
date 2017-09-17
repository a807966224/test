package com.practice.test.backstage.actions;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.test.backstage.beans.Emp;
import com.practice.test.backstage.currency.PagerList;
import com.practice.test.backstage.service.DeptService;
import com.practice.test.backstage.service.EmpService;

/**
 * 人员控制器
 * 
 * @author Scott
 *
 */
// 注册到spring容器中
@Controller
@RequestMapping("/emp")
public class EmpAction {

	@Resource
	EmpService empService;
	
	@Resource
	DeptService deptService;

	/**
	 * 跳转至人员管理界面
	 * 
	 * @param mode
	 * @return
	 */
	@RequestMapping("/empList")
	public String toEmp(Model model, Emp emp,@RequestParam(required = false, defaultValue = "1") Integer skip,
			@RequestParam(required = false, defaultValue = "2") Integer size,HttpServletRequest request) {
		
		
		//获取查询数据数量
		model.addAttribute("pagers", empService.getEmpForPage(skip, size, request.getRequestURI()));
		
		model.addAttribute("emp", emp);
		
		return "backstage/emp/empList";
	}
	
	@RequestMapping("/edit")
	public String edit(Emp emp,Model model,@RequestParam(required=false) boolean readOnly) {
		
		//获取唯一数据
		if(emp.getId() != null) {
			emp = empService.get(emp);
		}
		
		//存放至封装类中去
		model.addAttribute("bean", emp);
		
		model.addAttribute("readOnly", readOnly);
		
		//      查询部门集合   放置在人员编辑界面
		model.addAttribute("deptList", deptService.getList());
		
		
		return "backstage/emp/empEdit";
	}
	
	@RequestMapping("/save")
	public String save(Emp emp,Model model) {
		
		if(emp.getId() == null) {
			empService.insert(emp);
		}else {
			empService.update(emp);
		}
		
		return "redirect:/emp/empList";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(name = "id") Long[] ids) {
		
		empService.delete(ids);
		
		return "redirect:/emp/empList";
	}
	
}
