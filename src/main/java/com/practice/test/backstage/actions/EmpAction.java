package com.practice.test.backstage.actions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.practice.test.backstage.beans.Emp;
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

	@Value("${uploadImageUrl_windows}")
	private String uploadImageUrl_windows;
	
	/**
	 * 跳转至人员管理界面
	 * 
	 * @param mode
	 * @return
	 */
	@RequestMapping("/empList")
	public String toEmp(Model model, Emp emp,HttpServletRequest request) {
		
		
		//获取查询数据数量
		model.addAttribute("pagers", empService.getEmpForPage(emp,emp.getSkip(), emp.getSize(), request.getRequestURI()));
		
		model.addAttribute("bean", emp);
		
		model.addAttribute("deptList", deptService.getList());
		
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
	public String save(Emp emp,Model model,@RequestParam(required=false) String[] tmpPhoto) {
		
		if(emp.getId() == null) {
			empService.insert(emp);
		}else {
			empService.update(emp);
		}
		
		//回收垃圾图片
		if(tmpPhoto != null) {
			for(String photoSrc : tmpPhoto) {
				if(!photoSrc.equals(emp.getPhotoSrc())) {
					File file = new File(uploadImageUrl_windows,photoSrc);
					if(file.exists()) {
						file.delete();
					}
				}
			}
		}
		
		return "redirect:/emp/empList";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(name = "id") Long[] ids,@RequestParam(name = "delPhotoSrc") String[] delPhotoSrcs) {
	
		empService.delete(ids,delPhotoSrcs);
		
		return "redirect:/emp/empList";
	}
	
	@RequestMapping("/uploadPhoto")
	@ResponseBody
	public Map uploadPhoto(@RequestParam("upfile") MultipartFile upfile, HttpServletRequest request) {

		Map result = new HashMap();

		if (upfile != null) {
			// 如果文件大小不为0
			if (upfile.getSize() > 0) {

				// 生成文件名
				String filename = UUID.randomUUID().toString()
						+ upfile.getOriginalFilename().substring(upfile.getOriginalFilename().lastIndexOf("."));
				
				File tempFile = new File(uploadImageUrl_windows, filename);
				
				if (tempFile.getParent().isEmpty()) {
					tempFile.mkdirs();
				}
				
				try {
					// 保存文件
					upfile.transferTo(tempFile);
					// 更新数据
					result.put("flag", true);
					result.put("photoSrc", filename);
					return result;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		result.put("flag", false);
		result.put("photoSrc", null);
		return result;
	}

	public String getUploadImageUrl_windows() {
		return uploadImageUrl_windows;
	}

	public void setUploadImageUrl_windows(String uploadImageUrl_windows) {
		this.uploadImageUrl_windows = uploadImageUrl_windows;
	}
	
}
