package com.mygwt.mymvn.shared;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "phonebook", 
	uniqueConstraints=	@UniqueConstraint(columnNames = {"name", "phone"}))
public class PhoneRecord implements Serializable
{
	private static final long serialVersionUID = 3620555030421888938L;

	private long id;
	
	@Column(name = "name")
	private String name;
	
	private String phone;
	
	public static final int fieldsCount = 2; 

	public PhoneRecord()
	{
	}

	public PhoneRecord(String name, String phone)
	{
		this.name = name;
		this.phone = phone;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
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
        
        if (name.equalsIgnoreCase(other.name))
        	return false;
        
        String phone1 = phone.replaceAll("\\D", "");
        String phone2 = other.phone.replaceAll("\\D", "");

        return phone1.equals(phone2);
    }

	public static boolean verifyName(String name)
	{
		if (name == null || name.length() < 3)
			return false;
		
		return name.matches("[A-Za-z ]+");
	}
	
	public static boolean verifyPhone(String phone)
	{
		if (phone == null || phone.isEmpty())
			return false;
		
		return phone.matches("[1-9][0-9- ]+");
	}
}
