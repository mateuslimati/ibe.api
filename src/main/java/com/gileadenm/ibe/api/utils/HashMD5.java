package com.gileadenm.ibe.api.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashMD5 {

	public static String getCriptografado(String str){
		MessageDigest algoritmo = null;
		try {
			algoritmo = MessageDigest.getInstance("MD5");
			algoritmo.update(str.getBytes(), 0, str.length());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return new BigInteger(1, algoritmo.digest()).toString(16);
	}
	
}