package com.soft.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	/**
	 * 发送get请求
	 * 
	 */
	public static String sendGet(String kw) {
		// 返回的数据
		String resultData = null;
		// 获得Http客户端
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		// 参数
		StringBuffer params = new StringBuffer();
		
		try {
			// 字符数据最好encoding以下;这样一来，某些特殊字符才能传过去
			params.append("kw=" + URLEncoder.encode(kw, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

		// 创建Get请求
		HttpGet httpGet = new HttpGet("https://service.xiaoyuan.net.cn/garbage/index/search" + "?" + params);
		// 响应模型
		CloseableHttpResponse response = null;
		try {
			// 配置信息
			RequestConfig requestConfig = RequestConfig.custom()
					// 设置连接超时时间(单位毫秒)
					.setConnectTimeout(5000)
					// 设置请求超时时间(单位毫秒)
					.setConnectionRequestTimeout(5000)
					// socket读写超时时间(单位毫秒)
					.setSocketTimeout(5000)
					// 设置是否允许重定向(默认为true)
					.setRedirectsEnabled(true).build();

			// 将上面的配置信息 运用到这个Get请求里
			httpGet.setConfig(requestConfig);

			// 由客户端执行(发送)Get请求
			response = httpClient.execute(httpGet);

			// 从响应模型中获取响应实体
			HttpEntity responseEntity = response.getEntity();
			System.out.println("响应状态为:" + response.getStatusLine());
			if (responseEntity != null) {
				System.out.println("响应内容长度为:" + responseEntity.getContentLength());
				resultData = EntityUtils.toString(responseEntity);	
				System.out.println("响应内容为:" + resultData);

			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 释放资源
				if (httpClient != null) {
					httpClient.close();
				}
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return resultData;

	}
}
