package com.ecdatainfo.wechat.security.utils;

import com.ecdatainfo.wechat.model.po.sys.User;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.H64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;

import java.security.Key;
public final class EndecryptUtils {
    /** 
     * base64进制加密 
     * 
     * @param password 
     * @return 
     */ 
    public static String encrytBase64(String password) { 
        Preconditions.checkArgument(!Strings.isNullOrEmpty(password), "不能为空"); 
        byte[] bytes = password.getBytes(); 
        return Base64.encodeToString(bytes); 
    } 
    /** 
     * base64进制解密 
     * @param cipherText 
     * @return 
     */ 
    public static String decryptBase64(String cipherText) { 
        Preconditions.checkArgument(!Strings.isNullOrEmpty(cipherText), "消息摘要不能为空"); 
        return Base64.decodeToString(cipherText); 
    } 
    /** 
     * 16进制加密 
     * 
     * @param password 
     * @return 
     */ 
    public static String encrytHex(String password) { 
        Preconditions.checkArgument(!Strings.isNullOrEmpty(password), "不能为空"); 
        byte[] bytes = password.getBytes(); 
        return Hex.encodeToString(bytes); 
    } 
    /** 
     * 16进制解密 
     * @param cipherText 
     * @return 
     */ 
    public static String decryptHex(String cipherText) { 
        Preconditions.checkArgument(!Strings.isNullOrEmpty(cipherText), "消息摘要不能为空"); 
        return new String(Hex.decode(cipherText)); 
    } 
    public static String generateKey() 
    { 
        AesCipherService aesCipherService=new AesCipherService(); 
        Key key=aesCipherService.generateNewKey(); 
        return Base64.encodeToString(key.getEncoded()); 
    } 
    /** 
     * 对密码进行md5加密,并返回密文和salt，包含在User对象中 
     * @param username 用户名 
     * @param password 密码 
     * @return 密文和salt 
     */ 
    public static User md5Password(String username, String password){
//        Preconditions.checkArgument(!Strings.isNullOrEmpty(username),"username不能为空");
//        Preconditions.checkArgument(!Strings.isNullOrEmpty(password),"password不能为空");
//        SecureRandomNumberGenerator secureRandomNumberGenerator=new SecureRandomNumberGenerator();
//        String salt= secureRandomNumberGenerator.nextBytes().toHex();
//        //组合username,两次迭代，对密码进行加密
//        String password_cipherText= new Md5Hash(password,username+salt,2).toBase64();
//        User user=new User();
//        user.setPassword(password_cipherText);
//        user.setSalt(salt);
//        user.setUsername(username);
//        return user;
        return null;
    } 
    public static void main(String[] args) { 
        String password = "111111";
        byte[] bytes = password.getBytes();
        ByteSource p = ByteSource.Util.bytes(bytes);
        System.out.println("p:"+p);
        String cipherText = encrytHex(password); 
        System.out.println(password + "hex加密之后的密文是：" + cipherText); 
        String decrptPassword=decryptHex(cipherText); 
        System.out.println(cipherText + "hex解密之后的密码是：" + decrptPassword); 
        String cipherText_base64 = encrytBase64(password); 
        System.out.println(password + "base64加密之后的密文是：" + cipherText_base64); 
        String decrptPassword_base64=decryptBase64(cipherText_base64); 
        System.out.println(cipherText_base64 + "base64解密之后的密码是：" + decrptPassword_base64); 
        String h64=  H64.encodeToString(password.getBytes()); 
        System.out.println(h64); 
        String salt = null;
        String cipherText_md5= new Md5Hash(cipherText_base64.getBytes(),salt,1).toHex();
        System.out.println(password+"通过md5加密之后的密文是："+cipherText_md5); 
        System.out.println(generateKey()); 
        System.out.println("=========================================================="); 
        AesCipherService aesCipherService=new AesCipherService(); 
        aesCipherService.setKeySize(128); 
        Key key=aesCipherService.generateNewKey(); 
        String aes_cipherText= aesCipherService.encrypt(password.getBytes(),key.getEncoded()).toHex(); 
        System.out.println(password+" aes加密的密文是："+aes_cipherText); 
        String aes_mingwen=new String(aesCipherService.decrypt(Hex.decode(aes_cipherText),key.getEncoded()).getBytes()); 
        System.out.println(aes_cipherText+" aes解密的明文是："+aes_mingwen);

        String str = "111111";

        //String base64Encoded = Hex.encodeToString(str.getBytes());


        String cipherText_md52= new Md5Hash(Hex.encode(str.getBytes())).toString();
        //String str2 =new String(Hex.decode(base64Encoded.getBytes()));
        //String cryptedPwd = new Md5Hash("111111").toString();
        System.out.print("aaaa:"+cipherText_md52);



    } 
}