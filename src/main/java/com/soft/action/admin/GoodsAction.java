package com.soft.action.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.soft.model.Goods;
import com.soft.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsAction {

	@Autowired
	private GoodsService goodsService;
	
	// 跳转到商品管理界面
	@RequestMapping("/toGoodsManager")
	public String toGoodsManager(Map<String, Object> map) {
		// 获取所有商品信息
		List<Goods> goodsList = goodsService.getAll();
		map.put("goodsList", goodsList);
		return "admin/goodsManager";
	}
	
	// 添加商品
	@RequestMapping("/addGoods")
	public void addGoods(Goods goods, MultipartFile imageFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PrintWriter out = response.getWriter();
		
		if(goods!=null && imageFile!=null && goods.getGoodsname()!=null && goods.getGoodsdesc()!=null 
				&& goods.getGoodstype()!=null && goods.getNumber()!=null && goods.getPrice()!=null) {
			//使用UUID给图片重命名，并去掉四个“-”
			String name = UUID.randomUUID().toString().replaceAll("-", "");
			//获取文件的扩展名
			String ext = FilenameUtils.getExtension(imageFile.getOriginalFilename());
			//设置图片上传路径
			String url = request.getSession().getServletContext().getRealPath("/upload");
			System.out.println(url);
			//以绝对路径保存重名命后的图片
			imageFile.transferTo(new File(url+"/"+name + "." + ext));
			//把图片存储路径保存到数据库
			goods.setImageurl("upload/"+name + "." + ext);
			//添加商品
			if(goodsService.add(goods) == 1) {
				//返回商品管理界面
				System.out.println("添加成功！");
				out.write(
						"<script>alert('添加成功！');" + "window.location.href='/garbage-collection/goods/toGoodsManager'</script>");
			} else {
				//返回商品管理界面
				System.out.println("添加失败！");
				out.write(
						"<script>alert('添加失败！');" + "window.location.href='/garbage-collection/goods/toGoodsManager'</script>");
			}
			
			
			
		} else {
			System.out.println("请输入完整并正确的信息！");
			out.write(
					"<script>alert('请输入完整并正确的信息！');" + "window.location.href='/garbage-collection/goods/toGoodsManager'</script>");
			
		}
	}
	
	
	
	// 删除商品
	@RequestMapping("/deleteGoods")
	public void deleteGoods(Integer id, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		if(goodsService.delete(id) == 1) {
			System.out.println("删除成功！");
			out.write(
					"<script>alert('删除成功！');" + "window.location.href='/garbage-collection/goods/toGoodsManager'</script>");
		}
		
		System.out.println("删除失败！");
		out.write(
				"<script>alert('删除失败！');" + "window.location.href='/garbage-collection/goods/toGoodsManager'</script>");
		
	}
	
	
	// 跳转到修改商品的界面
	@RequestMapping("/toUpdateGoods")
	public String toUpdateGoods(Integer id, Map<String, Object> map) {
		Goods goods = goodsService.getById(id);
		map.put("goods", goods);
		return "admin/updateGoods";
	}
	
	// 修改商品
	@RequestMapping("/updateGoods")
	public void updateGoods(Goods goods, MultipartFile imageFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		PrintWriter out = response.getWriter();
		
		if(goods!=null && goods.getGoodsname()!=null && goods.getGoodsdesc()!=null 
				&& goods.getGoodstype()!=null && goods.getNumber()!=null && goods.getPrice()!=null) {
			
		
			if(!imageFile.isEmpty()) {
				
				System.err.println("图片"+imageFile);
				
				//使用UUID给图片重命名，并去掉四个“-”
				String name = UUID.randomUUID().toString().replaceAll("-", "");
				//获取文件的扩展名
				String ext = FilenameUtils.getExtension(imageFile.getOriginalFilename());
				//设置图片上传路径
				String url = request.getSession().getServletContext().getRealPath("/upload");
				System.out.println(url);
				//以绝对路径保存重名命后的图片
				imageFile.transferTo(new File(url+"/"+name + "." + ext));
				//把图片存储路径保存到数据库
				goods.setImageurl("upload/"+name + "." + ext);
			}
			
			System.err.println(goods.toString());
		
			//修改商品
			if(goodsService.update(goods) == 1) {
				//返回商品管理界面
				System.out.println("修改成功！");
				out.write(
						"<script>alert('修改成功！');" + "window.location.href='/garbage-collection/goods/toGoodsManager'</script>");
			} else {
				System.out.println("修改失败！");
				out.write(
						"<script>alert('修改失败！');" + "window.location.href='/garbage-collection/goods/toGoodsManager'</script>");
			}
			
		
		}
		else {
			System.out.println("请输入完整并正确的信息！");
			out.write(
					"<script>alert('请输入完整并正确的信息！');" + "window.location.href='/garbage-collection/goods/toGoodsManager'</script>");
			
		}
	}

	
}
