package com.ecdatainfo.wechat.base.utils;

import com.ecdatainfo.wechat.base.constant.Constant;
import com.ecdatainfo.wechat.model.po.sys.User;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.UUID;

/**
 * Created by changtong on 2016/11/15.
 */
public class TokenUtils {

    public static final String MAGIC_KEY = "obfuscate";


    /**
     * base64进制解密
     * @param cipherText
     * @return
     */
    public static String encrytBase64(String cipherText) {
        byte[] bytes = cipherText.getBytes();
        return Base64.encodeToString(bytes);
    }

    /**
     * base64进制解密
     * @param cipherText
     * @return
     */
    public static String decryptBase64(String cipherText) {
        return Base64.decodeToString(cipherText);
    }

    public static String encrytPassword(String password){
        byte[] bytes = password.getBytes();
        ByteSource p = ByteSource.Util.bytes(bytes);
        String cipherText_md5= new Md5Hash(p.getBytes(),null,1).toHex();
        return cipherText_md5;
    }

    public static String computeSignature(User user) {
        AesCipherService aesCipherService=new AesCipherService();
        aesCipherService.setKeySize(128);
        Key key=aesCipherService.generateNewKey();
        String token= aesCipherService.encrypt(user.getUserPhone().getBytes(),key.getEncoded()).toHex();
        return token;
    }

    public static String extractAuthTokenFromRequest(HttpServletRequest httpRequest) {
		/* Get token from header */
        String authToken = httpRequest.getHeader(Constant.AUTHORIZATION);

		/* If token not found get it from request parameter */
        if (authToken == null) {
            authToken = httpRequest.getParameter(Constant.TOKEN);
        }

        return authToken;
    }
}
