package fanglab.framework.business;

import java.util.*;

public class SlSearchDefine {
	/*
	 * 静态构造函数
	 */
	public static HashMap<String, SlSearchDefine> Settings = new HashMap<String, SlSearchDefine>();

	static {

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("baidu.mobi");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Baidu);
			searchDefine.setKeyParameters("(word),(kw)");
			Settings.put("baidu.mobi", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("image.baidu.com");
			searchDefine.setEncoding("gb2312");
			searchDefine.setGroupType(SlSearchGroupType.Baidu);
			searchDefine.setKeyParameters("(word),(q)");
			Settings.put("image.baidu.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("m.baidu.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Baidu);
			searchDefine.setKeyParameters("(word),(wd),(kw)");
			Settings.put("m.baidu.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("m1.baidu.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Baidu);
			searchDefine.setKeyParameters("(word),(wd),(kw)");
			Settings.put("m1.baidu.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("m2.baidu.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Baidu);
			searchDefine.setKeyParameters("(word),(wd),(kw)");
			Settings.put("m2.baidu.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("m3.baidu.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Baidu);
			searchDefine.setKeyParameters("(word),(wd),(kw)");
			Settings.put("m3.baidu.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("m4.baidu.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Baidu);
			searchDefine.setKeyParameters("(word),(wd),(kw)");
			Settings.put("m4.baidu.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("m5.baidu.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Baidu);
			searchDefine.setKeyParameters("(word),(wd),(kw)");
			Settings.put("m5.baidu.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("m6.baidu.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Baidu);
			searchDefine.setKeyParameters("(word),(wd),(kw)");
			Settings.put("m6.baidu.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("m7.baidu.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Baidu);
			searchDefine.setKeyParameters("(word),(wd),(kw)");
			Settings.put("m7.baidu.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("m8.baidu.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Baidu);
			searchDefine.setKeyParameters("(word),(wd),(kw)");
			Settings.put("m8.baidu.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("m9.baidu.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Baidu);
			searchDefine.setKeyParameters("(word),(wd),(kw)");
			Settings.put("m9.baidu.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("3g.baidu.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Baidu);
			searchDefine.setKeyParameters("(word),(wd),(kw)");
			Settings.put("3g.baidu.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("wap.baidu.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Baidu);
			searchDefine.setKeyParameters("(word),(wd),(kw)");
			Settings.put("wap.baidu.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("news.baidu.com");
			searchDefine.setEncoding("gb2312");
			searchDefine.setGroupType(SlSearchGroupType.Baidu);
			searchDefine.setKeyParameters("(word),(q)");
			Settings.put("news.baidu.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.baidu.com");
			searchDefine.setEncoding("gb2312");
			searchDefine.setGroupType(SlSearchGroupType.Baidu);
			searchDefine.setKeyParameters("(word),(wd),(q)");
			Settings.put("www.baidu.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("groups.google.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("groups.google.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("images.google.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("images.google.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("images.google.com.hk");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("images.google.com.hk", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("images.google.com.my");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("images.google.com.my", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("images.google.com.tw");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("images.google.com.tw", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("ipv6.google.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("ipv6.google.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("ipv6.google.com.hk");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("ipv6.google.com.hk", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("mail.google.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("mail.google.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("maps.google.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("maps.google.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("maps.google.com.hk");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("maps.google.com.hk", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("maps.google.com.tw");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("maps.google.com.tw", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("news.google.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("news.google.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("news.google.com.au");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("news.google.com.au", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("news.google.com.hk");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("news.google.com.hk", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("news.google.com.my");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("news.google.com.my", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("news.google.com.sg");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("news.google.com.sg", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("news.google.com.tw");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("news.google.com.tw", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("plus.url.google.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("plus.url.google.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.ae");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.ae", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.am");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.am", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.as");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.as", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.at");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.at", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.az");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.az", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.ba");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.ba", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.be");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.be", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.bg");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.bg", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.bs");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.bs", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.ca");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.ca", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.cat");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.cat", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.ch");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.ch", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.cl");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.cl", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.cm");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.cm", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.cn");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.cn", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.co.bw");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.co.bw", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.co.cr");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.co.cr", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.co.id");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.co.id", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.co.il");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.co.il", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.co.in");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.co.in", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.co.jp");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.co.jp", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.co.ke");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.co.ke", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.co.kr");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.co.kr", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.co.ma");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.co.ma", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.co.nz");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.co.nz", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.co.th");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.co.th", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.co.tz");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.co.tz", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.co.uk");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.co.uk", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.co.uz");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.co.uz", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.co.ve");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.co.ve", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.co.za");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.co.za", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.co.zw");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.co.zw", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.ag");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.ag", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.ai");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.ai", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.ar");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.ar", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.au");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.au", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.bd");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.bd", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.bn");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.bn", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.bo");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.bo", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.br");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.br", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.bz");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.bz", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.co");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.co", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.cy");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.cy", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.do");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.do", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.ec");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.ec", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.eg");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.eg", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.et");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.et", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.fj");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.fj", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.gh");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.gh", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.gt");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.gt", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.hk");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.hk", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.hk.");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.hk.", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.jm");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.jm", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.kh");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.kh", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.kw");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.kw", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.lb");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.lb", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.mt");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.mt", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.mx");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.mx", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.my");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.my", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.na");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.na", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.ng");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.ng", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.np");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.np", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.om");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.om", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.pa");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.pa", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.pe");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.pe", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.ph");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.ph", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.pk");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.pk", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.pr");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.pr", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.qa");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.qa", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.sa");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.sa", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.sb");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.sb", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.sg");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.sg", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.tn");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.tn", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.tr");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.tr", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.tw");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.tw", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.ua");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.ua", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.uy");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.uy", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.vc");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.vc", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.com.vn");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.com.vn", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.combj-ibook.cn");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.combj-ibook.cn", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.cz");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.cz", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.de");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.de", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.dk");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.dk", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.ee");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.ee", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.es");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.es", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.fi");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.fi", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.fm");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.fm", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.fr");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.fr", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.ge");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.ge", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.gr");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.gr", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.hn");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.hn", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.ht");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.ht", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.hu");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.hu", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.ie");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.ie", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.iq");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.iq", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.is");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.is", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.it");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.it", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.jo");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.jo", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.kg");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.kg", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.kz");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.kz", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.lt");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.lt", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.lu");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.lu", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.lv");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.lv", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.md");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.md", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.mn");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.mn", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.mu");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.mu", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.nl");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.nl", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.no");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.no", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.nr");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.nr", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.pl");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.pl", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.pt");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.pt", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.ro");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.ro", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.ru");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.ru", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.se");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.se", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.sk");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.sk", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.tn");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.tn", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.google.ws");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Google);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.google.ws", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("news.sogou.com");
			searchDefine.setEncoding("gb2312");
			searchDefine.setGroupType(SlSearchGroupType.Sogou);
			searchDefine.setKeyParameters("(query)");
			Settings.put("news.sogou.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("pic.sogou.com");
			searchDefine.setEncoding("gb2312");
			searchDefine.setGroupType(SlSearchGroupType.Sogou);
			searchDefine.setKeyParameters("(query)");
			Settings.put("pic.sogou.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("quan.sogou.com");
			searchDefine.setEncoding("gb2312");
			searchDefine.setGroupType(SlSearchGroupType.Sogou);
			searchDefine.setKeyParameters("(query)");
			Settings.put("quan.sogou.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.sogou.com");
			searchDefine.setEncoding("gb2312");
			searchDefine.setGroupType(SlSearchGroupType.Sogou);
			searchDefine.setKeyParameters("(query)");
			Settings.put("www.sogou.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("wap.sogou.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Sogou);
			searchDefine.setKeyParameters("(keyword)");
			Settings.put("wap.sogou.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("m.sogou.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Sogou);
			searchDefine.setKeyParameters("(keyword)");
			Settings.put("m.sogou.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("image.soso.com");
			searchDefine.setEncoding("gb2312");
			searchDefine.setGroupType(SlSearchGroupType.Soso);
			searchDefine.setKeyParameters("(w)");
			Settings.put("image.soso.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("news.soso.com");
			searchDefine.setEncoding("gb2312");
			searchDefine.setGroupType(SlSearchGroupType.Soso);
			searchDefine.setKeyParameters("(w)");
			Settings.put("news.soso.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.soso.com");
			searchDefine.setEncoding("gb2312");
			searchDefine.setGroupType(SlSearchGroupType.Soso);
			searchDefine.setKeyParameters("(w)");
			Settings.put("www.soso.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("wap.soso.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Soso);
			searchDefine.setKeyParameters("(key)");
			Settings.put("wap.soso.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("cn.bing.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Bing);
			searchDefine.setKeyParameters("(q)");
			Settings.put("cn.bing.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("image.youdao.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Youdao);
			searchDefine.setKeyParameters("(q)");
			Settings.put("image.youdao.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("news.youdao.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Youdao);
			searchDefine.setKeyParameters("(q)");
			Settings.put("news.youdao.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.youdao.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Youdao);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.youdao.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("au.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("au.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("br.yhs.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("br.yhs.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("ca.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("ca.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("ca.yhs4.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("ca.yhs4.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("cade.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("cade.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("cn.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("cn.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("de.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("de.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("es.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("es.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("fr.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("fr.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("hk.image.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("hk.image.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("hk.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("hk.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("image.yahoo.cn");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(q)");
			Settings.put("image.yahoo.cn", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("images.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("images.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("in.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("in.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("it.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("it.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("kr.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("kr.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("maktoob.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("maktoob.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("malaysia.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("malaysia.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("mx.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("mx.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("news.yahoo.cn");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(q)");
			Settings.put("news.yahoo.cn", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("nl.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("nl.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("se.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("se.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("search.yahoo.co.jp");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("search.yahoo.co.jp", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("sg.images.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("sg.images.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("sg.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("sg.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("tw.image.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("tw.image.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("tw.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("tw.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("tw.yhs4.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("tw.yhs4.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("uk.images.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("uk.images.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("uk.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("uk.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("us.yhs.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("us.yhs.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("us.yhs4.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("us.yhs4.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("video.search.yahoo.co.jp");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("video.search.yahoo.co.jp", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("vn.search.yahoo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(p)");
			Settings.put("vn.search.yahoo.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.yahoo.cn");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yahoo);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.yahoo.cn", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("news.so.360.cn");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.So360);
			searchDefine.setKeyParameters("(q)");
			Settings.put("news.so.360.cn", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("news.so.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.So360);
			searchDefine.setKeyParameters("(q)");
			Settings.put("news.so.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("so.360.cn");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.So360);
			searchDefine.setKeyParameters("(q)");
			Settings.put("so.360.cn", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("so.v.360.cn");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.So360);
			searchDefine.setKeyParameters("kw");
			Settings.put("so.v.360.cn", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("video.so.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.So360);
			searchDefine.setKeyParameters("(q)");
			Settings.put("video.so.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("m.so.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.So360);
			searchDefine.setKeyParameters("(q)");
			Settings.put("m.so.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.so.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.So360);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.so.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("www.easou.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Easou);
			searchDefine.setKeyParameters("(q)");
			Settings.put("www.easou.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("pad.easou.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Easou);
			searchDefine.setKeyParameters("(q)");
			Settings.put("pad.easou.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("i.easou.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Easou);
			searchDefine.setKeyParameters("(q)");
			Settings.put("i.easou.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("wap.easou.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Easou);
			searchDefine.setKeyParameters("(q)");
			Settings.put("wap.easou.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("n.easou.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Easou);
			searchDefine.setKeyParameters("(q)");
			Settings.put("n.easou.com", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("page.yicha.cn");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yicha);
			searchDefine.setKeyParameters("(key)");
			Settings.put("page.yicha.cn", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("tnews.yicha.cn");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Yicha);
			searchDefine.setKeyParameters("(key)");
			Settings.put("tnews.yicha.cn", searchDefine);
		}

		{
			SlSearchDefine searchDefine = new SlSearchDefine();
			searchDefine.setDomain("wap.roboo.com");
			searchDefine.setEncoding("utf-8");
			searchDefine.setGroupType(SlSearchGroupType.Roboo);
			searchDefine.setKeyParameters("(q)");
			Settings.put("wap.roboo.com", searchDefine);
		}
	}

	private String domain;

	public void setDomain(String value) {
		this.domain = value;
	}

	public String getDomain() {
		return this.domain;
	}

	private String keyParameters;

	public void setKeyParameters(String value) {
		this.keyParameters = value;
	}

	public String getKeyParameters() {
		return this.keyParameters;
	}

	private SlSearchGroupType groupType;

	public void setGroupType(SlSearchGroupType value) {
		this.groupType = value;
	}

	public SlSearchGroupType getGroupType() {
		return this.groupType;
	}

	private String encoding;

	public void setEncoding(String value) {
		this.encoding = value;
	}

	public String getEncoding() {
		return this.encoding;
	}

	/*
	 * 重写Equals
	 * 
	 * @param Object obj，对象
	 * 
	 * @return boolean，结果
	 */
	public boolean equals(Object obj) {
		SlSearchDefine other = null;
		if (obj instanceof SlSearchDefine) {
			other = (SlSearchDefine) obj;
			return this.getDomain().equals(other.getDomain());
		}
		return false;
	}

	/*
	 * 重写hashCode
	 * 
	 * @return int，结果
	 */
	public int hashCode() {
		return this.getDomain().hashCode();
	}
}
