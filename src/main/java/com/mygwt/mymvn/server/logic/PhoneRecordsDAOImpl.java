package com.mygwt.mymvn.server.logic;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.mygwt.mymvn.shared.PhoneRecord;

public class PhoneRecordsDAOImpl implements PhoneRecordsDAO
{
	@Override
	public long add(PhoneRecord added) throws HibernateException
	{
		Session session = null;
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(added);
			session.getTransaction().commit();
		}
		finally
		{
			if (session != null && session.isOpen())
			{
				session.close();
			}
		}
		
		return -1;
	}

	@Override
	public boolean update(long updatedId, PhoneRecord dest) throws HibernateException
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<PhoneRecord> getAll() throws HibernateException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PhoneRecord> get(String namePart) throws HibernateException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long deletedId)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhoneRecord get(long id)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
