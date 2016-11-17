package com.ecdatainfo.wechat.base.constant;

/**
 * Created with IntelliJ IDEA.
 * User: tomchangt
 * Date: 2016-10-18
 * 微信相关常量
 */
public class WeixinConstant {
    public final static String BWC = "BWC";
    //ACCESS_TOKEN_CACHE
    public static final String BWC_ACCESS_TOKEN_CACHE = String.format("wechatAccessToken:%s", BWC);
    /**
     * 微信基础接口地址
     */
    // 获取普通access_token接口(GET)  可以使用中控服务器管理（获取/存储）--access_token是公众号的全局唯一接口调用凭据，公众号调用各接口时都需使用access_token。
    public final static String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={0}&secret={1}";
    // oauth2授权接口(GET)
    public final static String OAUTH2_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type={2}&scope={3}&state={4}#wechat_redirect";
    //code换取网页授权access_token(GET)  --网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
    public final static String OAUTH2_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid={0}&secret={1}&code={2}&grant_type=authorization_code";
    // 刷新access_token接口（GET）
    public final static String REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
    // 菜单创建接口（POST）
    public final static String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token={0}";
    // 菜单查询（GET）
    public final static String MENU_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
    // 菜单删除（GET）
    public final static String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
    //长链转短链(POST)
    public final static String LONG2SHORT_URL = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token={0}";

    /**
     * 微信消息接口
     */
    //发送模板消息(POST)
    public final static String MESSAGE_SEND = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token={0}";


}