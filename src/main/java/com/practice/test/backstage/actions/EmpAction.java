package com.practice.test.backstage.actions;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.test.backstage.beans.Emp;
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

	/**
	 * 跳转至人员管理界面
	 * 
	 * @param mode
	 * @return
	 */
	@RequestMapping("/empList")
	public String toEmp(Model model, Emp emp,@RequestParam(required = false, defaultValue = "0") Integer skip,
			@RequestParam(required = false, defaultValue = "5") Integer size) {
		List<Emp> emps = empService.getEmpForPage(skip, size);
		//获取查询数据数量
		model.addAttribute("emps", emps);
		model.addAttribute("emp", emp);
		return "backstage/emp/empList";
	}

}
