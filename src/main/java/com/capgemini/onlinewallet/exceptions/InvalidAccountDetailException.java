package com.capgemini.onlinewallet.exceptions;

public class InvalidAccountDetailException extends Exception
{
	private static final long serialVersionUID = 1L;

	public InvalidAccountDetailException(String s)
	{
		super(s);
	}

}
