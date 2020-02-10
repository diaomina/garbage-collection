package com.soft.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.model.GarbageType;
import com.soft.service.GarbageTypeService;

/**
 * 
 * @ClassName: GarbageTypeAction 
 * @Description: 垃圾类型管理
 * @author: ljy
 * @date: 2019年12月13日 上午12:37:52
 */
@Controller
@RequestMapping("/garbageType")
public class GarbageTypeAction {
	
	@Autowired
	private GarbageTypeService garbageTypeService;
	
	// 跳转到垃圾类型管理界面
	@RequestMapping("/toGarbageTypeManager")
	public String toGarbageTypeManager(Map<String, Object> map) {
		List<GarbageType> garbageTypeList = garbageTypeService.getAll();
		map.put("garbageTypeList", garbageTypeList);
		return "admin/garbageTypeManager";
	}
	
	// 添加垃圾类型
	@RequestMapping("/add")
	public String add(GarbageType garbageType, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		// 表单校验
		if(garbageType !=null && garbageType.getGarbagetypename()!=null && garbageType.getGarbagetip()!=null
				&&  !"".equals(garbageType.getGarbagetypename()) && !"".equals(garbageType.getGarbagetip())) {
			// 添加
			garbageTypeService.add(garbageType);
			// 重定向
			return "redirect:toGarbageTypeManager";
		} else {
			System.out.println("请输入完整并且正确的信息！");
			out.write("<script>alert('请输入完整并且正确的信息！');"
					+ "window.location.href='/garbage-collection/garbageType/toGarbageTypeManager'</script>");
		}
		
		return "redirect:toGarbageTypeManager";
	}
	
	
	// 修改垃圾类型
	@RequestMapping("update")
	public String update(GarbageType garbageType, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		// 表单校验
		if(garbageType !=null && garbageType.getGarbagetypename()!=null && garbageType.getGarbagetip()!=null
				&&  !"".equals(garbageType.getGarbagetypename()) && !"".equals(garbageType.getGarbagetip())) {
			// 修改
			GarbageType newGarbageType = garbageTypeService.getById(garbageType.getId());
			newGarbageType.setGarbagetypename(garbageType.getGarbagetypename());
			newGarbageType.setGarbagetip(garbageType.getGarbagetip());
			garbageTypeService.update(newGarbageType);
			// 重定向
			return "redirect:toGarbageTypeManager";
		} else {
			System.out.println("请输入完整并且正确的信息！");
			out.write("<script>alert('请输入完整并且正确的信息！');"
					+ "window.location.href='/garbage-collection/garbageType/toGarbageTypeManager'</script>");
		}
		
		return "redirect:toGarbageTypeManager";
	}
	
	
	// 删除垃圾类型
	@RequestMapping("/delete")
	public String delete(Integer id) {
		garbageTypeService.delete(id);
		return "redirect:toGarbageTypeManager";
	}

}
