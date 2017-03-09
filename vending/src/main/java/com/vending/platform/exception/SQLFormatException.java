package com.vending.platform.exception;

/**
 * 自定义异常类
 * 
 * @author Miley_Ren
 */
public class SQLFormatException extends Exception {

	private static final long serialVersionUID = -6217306577418889634L;

	public SQLFormatException(String message) {
		super(message);
	}
}
