package com.vending.platform.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

@Controller
public class UtilsAction implements Serializable {
	private static final long serialVersionUID = -8348417258576966571L;
	private HttpServletResponse response;

	@Description("进入home页")
	@RequestMapping(value = "/home")
	public String getHome() {
		return "genview/home";
	}

	public void write(Object object) throws IOException {
		try {
			// 设置响应数据类型和字符编码
			response.setContentType("text/html;charset=utf-8");
			// 向客户端发送数据
			response.getWriter().write(object.toString());
			// 将缓冲区中的当前页面内容立刻输出到客户端
			response.getWriter().flush(); // 关闭
			response.getWriter().close();
		} catch (IOException e) {
			try {// 异常时输出空字符
				response.getWriter().write("");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			throw e;
		}

	}

	/**
	 * 将对象转换成json字符然后用响应对象输出到前端
	 * 
	 * @param object
	 * @throws IOException
	 */
	public void writeJson(Object object) throws IOException {
		/* 获取响应对象 */
		try {
			/* 用户json插件将对象转换成json字符串，并将时间类型格式化成：yyyy-MM-dd HH:mm:ss */
			String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			/* 设置响应数据类型和字符编码 */
			response.setContentType("text/html;charset=utf-8");
			/* 向客户端发送数据 */
			response.getWriter().write(json);
			/* 将缓冲区中的当前页面内容立刻输出到客户端 */
			response.getWriter().flush();
			/* 关闭 */
			response.getWriter().close();
		} catch (IOException e) {
			try {
				/* 异常时输出空字符 */
				response.getWriter().write("");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			throw e;
		}
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	@Resource
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

}
