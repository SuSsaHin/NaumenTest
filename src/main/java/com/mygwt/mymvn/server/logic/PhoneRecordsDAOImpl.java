package com.mygwt.mymvn.server.logic;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.mygwt.mymvn.shared.PhoneRecord;

public class PhoneRecordsDAOImpl implements PhoneRecordsDAO
{
	@Override
	public long add(final PhoneRecord added) throws HibernateException
	{
		Session session = HibernateUtil.getCurrentSession();
		Transaction trans = session.beginTransaction();
		long id;
		
		try
		{
			id = (long) session.save(added);
			trans.commit();
		}
		catch(HibernateException ex)
		{
			trans.rollback();
			return -1;
		}
	
		return id;
	}

	@Override
	public boolean update(final long updatedId, final PhoneRecord dest)
			throws HibernateException
	{
		PhoneRecord record = new PhoneRecord(dest.getName(), dest.getPhone());
		record.setId(updatedId);
		
		Session session = HibernateUtil.getCurrentSession();
		Transaction trans = session.beginTransaction();
		
		try
		{
			session.merge(record);
			trans.commit();
		}
		catch(HibernateException ex)
		{
			trans.rollback();
			return false;
		}


		return true;
	}

	@Override
	public ArrayList<PhoneRecord> getAll() throws HibernateException
	{
		Session session = HibernateUtil.getCurrentSession();
		Transaction trans = session.beginTransaction();
		
		List<PhoneRecord> records = session.createCriteria(PhoneRecord.class)
				.list();
		
		trans.commit();
		return new ArrayList<PhoneRecord>(records);
	}

	@Override
	public ArrayList<PhoneRecord> get(final String namePart)
			throws HibernateException
	{
		Session session = HibernateUtil.getCurrentSession();
		Transaction trans = session.beginTransaction();
		
		List<PhoneRecord> records = session.createCriteria(PhoneRecord.class)
				.add(Restrictions.like("name", "%" + namePart + "%")).list();

		trans.commit();
		return new ArrayList<PhoneRecord>(records);
	}

	@Override
	public void delete(long deletedId)
	{
		Session session = HibernateUtil.getCurrentSession();
		Transaction trans = session.beginTransaction();
		
		session.delete(session.load(PhoneRecord.class, deletedId));
		
		trans.commit();
	}

	@Override
	public PhoneRecord get(final long id)
	{
		Session session = HibernateUtil.getCurrentSession();
		Transaction trans = session.beginTransaction();

		PhoneRecord record = (PhoneRecord) session.get(PhoneRecord.class, id);
		trans.commit();
		return record;
	}

}
