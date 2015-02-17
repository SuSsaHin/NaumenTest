package com.mygwt.mymvn.shared;

import java.io.Serializable;

public class PhoneRecord implements Serializable
{
	private static final long serialVersionUID = 936611318649062911L;
	private long id;
	private String name;
	private String phone;
	
	public static final int fieldsCount = 2; 

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
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PhoneRecord other = (PhoneRecord) obj;

        return (name.equals(other.name) && phone.equals(other.phone));
    }

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}
}
