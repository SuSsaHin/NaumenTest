package com.mygwt.mymvn.server.logic;

public class PhoneRecordsDAOFactory
{
	private static PhoneRecordsDAOFactory instance;
	private PhoneRecordsDAO phoneRecordsDAO;
	
	private PhoneRecordsDAOFactory()
	{
		phoneRecordsDAO = new PhoneRecordsDAOImpl();
	}
	
	public static PhoneRecordsDAOFactory getInstance()
	{
		return instance == null ? instance = new PhoneRecordsDAOFactory() : instance;
	}
	
	public PhoneRecordsDAO get()
	{
		return phoneRecordsDAO;
	}
}
