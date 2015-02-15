package com.mygwt.mymvn.shared;

import java.io.Serializable;

public class PhoneRecord implements Serializable
{
	private static final long serialVersionUID = 936611318649062911L;
	private String name;
	private String phone;

	private PhoneRecord()
	{
	}

	public PhoneRecord(String name, String phone)
	{
		this.name = name;
		this.phone = phone;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}
}
