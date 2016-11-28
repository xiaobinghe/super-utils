package com.locensate.superlibray.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * -------------------------------------
 * <p>
 * 项目名称： lepro
 * <p>
 * 版权：locensate.com 版权所有 2016
 * <p>
 * 公司主页：http://www.locensate.com/
 * <p>
 * 描述：Md5加密工具类
 * <p>
 * 作者： xiaobinghe
 * <p>
 * 时间： 2016/11/16
 * <p>
 * 修改历史：
 * <p>
 * 修改时间：
 * <p>
 * 修改描述：
 * <p>
 * -------------------------------------
 */
public class MD5Utils {

	/** SHA1编码  */
	public static String SHA1Encode(String source) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			return byte2String(md.digest(source.getBytes()));
		} catch (Exception ex) {
			throw new RuntimeException("md5 encode error");
		}
	}

	/** byte数组转换为字符串  */
	public static String byte2String(byte[] bytes) {
		StringBuffer buf = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			if (((int) bytes[i] & 0xff) < 0x10) {
				buf.append("0");
			}
			buf.append(Long.toString((int) bytes[i] & 0xff, 16));
		}
		return buf.toString();
	}

	/**
	 * 标准的md5加密
	 * 
	 * @param password
	 *            明文
	 * @return 密文
	 */
	public static String getMD5Standard(String password) {

		try {
			// 信息摘要器
			MessageDigest digest = MessageDigest.getInstance("md5");
			try {
				digest.reset();
				digest.update(password.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				LogUtils.log(e);
			}
			// 1.把明文变成-byte
			byte[] reusl = digest.digest();
			// 2.遍历byte数组与8个二进制位做与运算
			StringBuffer buffer = new StringBuffer();
			for (byte b : reusl) {
				// 标准的md5加密
				int number = b & 0xff;// 密码学-加盐
				// 3.转换成16进制
				String strNumber = Integer.toHexString(number);
				// 4.补全
				if (strNumber.length() == 1) {
					buffer.append("0");
				}
				buffer.append(strNumber);
			}
			// 标准的md5加密后的结果了
			return buffer.toString().toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			LogUtils.log(e);
			return "";
		}

	}

	/**
	 * 自定义md5加密
	 * 
	 * @param password
	 *            明文
	 * @return 密文
	 */
	public static String getMD5Custom(String password) {

		try {
			// 信息摘要器
			MessageDigest digest = MessageDigest.getInstance("md5");
			try {
				digest.reset();
				digest.update(password.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				LogUtils.log(e);
			}
			// 1.把明文变成-byte
			byte[] reusl = digest.digest();
			// 2.遍历byte数组与8个二进制位做与运算
			StringBuffer buffer1 = new StringBuffer();
			for (byte b : reusl) {
				// 标准的md5加密
				int number = b & 0xfff;// 密码学-加盐
				// 3.转换成16进制
				String strNumber = Integer.toHexString(number);
				// 4.补全
				if (strNumber.length() == 1) {
					buffer1.append("0");
				}
				buffer1.append(strNumber);
			}
			/**
			 * 二次加密
			 */
			reusl = digest.digest(buffer1.toString().getBytes());
			// 2.遍历byte数组与8个二进制位做与运算
			StringBuffer buffer2 = new StringBuffer();
			for (byte b : reusl) {
				// 自定义加盐
				int number = b & 0xffff;// 密码学-加盐
				// 3.转换成16进制
				String strNumber = Integer.toHexString(number);
				// 4.补全
				if (strNumber.length() == 1) {
					buffer2.append("0");
				}
				buffer2.append(strNumber);
			}
			// 自定义的md5加密后的结果了
			return buffer2.toString();
		} catch (NoSuchAlgorithmException e) {
			LogUtils.log(e);
			return "";
		}
	}
}
