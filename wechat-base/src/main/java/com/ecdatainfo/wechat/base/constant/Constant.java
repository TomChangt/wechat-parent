package com.ecdatainfo.wechat.base.constant;

/**
 * 
* @ClassName: Constant 
* @Description: 系统常量
* @author tomchangt
* @date 2016年10月18日
 */
public class Constant {

    public final static String MALL_NAME="佰万仓";
	
	public final static String CORP_NAME="上海佰万仓网络科技有限公司";
	
	public final static String OPERATE_SUCCESS =  "操作成功！";
	
	public final static String DOT = ".";
	 //用户权限缓存
    public static final String USER_PERMISSION_CACHE = "lup"+DOT; //超时时间为30分钟
    //权限缓存
    public static final String PERMISSION_CACHE = "lp"+DOT; //超时时间为7天
    //系统所有角色的权限缓存（角色英文名称为key，角色对应的权限LIST为value）
    public static final String ROLE_PERMISSION_CACHE = "lrp"+DOT; //超时时间为7天 
    //已经匹配过的权限缓存
    public static final String RES_MATCH_CACHE ="lrm"+DOT; //超时时间为30分钟
    //用户信息的cache
    public static final String USER_INFO_CACHE="su"+DOT; 
    //cookie与user的映射
    public static final String COOKIE_USER_CACHE="sct"+DOT;
    //token与真实use的映射
    public static final String TOEKN_USER_CACHE="stuc"+DOT;
    //token与真实use的映射
    public static final String USER_MENU_CACHE="um"+DOT;
    
    //SSO使用的cookie的name
    public final static String SSO_COOKIE_NAME= "uo.auth.sso.cookie";
    
	//一周
	public final static Integer SEC_WEEK = 7*24*60*60;//seconds
	//一天
	public final static Integer SEC_ONEDAY = 24*60*60;//seconds
	//一个小时
	public final static Integer SEC_ANHOUR = 60*60;//seconds
	//半个小时
	public final static Integer SEC_HALFHOUR = 30*60;//seconds
	//一分钟
	public final static Integer SEC_ONEMINUTE = 60;//seconds
	
	//重试次数
	public final static Integer RETRY_TIME = 5;
	//连接超时时间
	public final static Integer CONNECT_TIMEOUT = 2000;
	//访问超时时间
	public final static Integer READ_TIMEOUT = 3000;
	
	//redis nxxx的expire定义
	public final static String EX = "EX"; //seconds
	//redis nxxx的expire定义
	public final static String PX = "PX"; //milliseconds

	public static Long SHOP_ID = 1L;
	
	
	// 用户全局唯一id
	public static final String GUID = "GUID"; 
	//用户信息json
	public static final String USERINFO_JSON = "USERINFO_JSON"; 
	// 请求ip
	public static final String REQUEST_IP = "REQUEST_IP"; 
	 //请求地址
	public static final String REQUEST_URL = "REQUEST_URL";
	//请求方式
	public static final String REQUEST_METHOD = "REQUEST_METHOD";
	//操作名称
	public static final String ACTION_NAME = "ACTION_NAME"; 
	// userAgent
	public static final String USER_AGENT = "USER_AGENT"; 
	//requestid 唯一标识一次请求
	public static final String REQUEST_ID = "request_Id";
	
	//CURRENT_USER 当前用户
	public static final String CURRENT_USER = "CURRENT_USER";




	public static final String AUTHORIZATION = "Authorization";

	public static final String TOKEN = "Token";


	public static final String SESSIONKEYPREFIX = "redis";




	
}