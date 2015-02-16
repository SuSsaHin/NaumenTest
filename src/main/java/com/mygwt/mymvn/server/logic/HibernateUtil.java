package com.mygwt.mymvn.server.logic;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class HibernateUtil
{
	private static final SessionFactory sessionFactory;
	
	static
	{
		try
		{
			sessionFactory = new Configuration().configure()
					.buildSessionFactory(
							new StandardServiceRegistryBuilder().build());
		}
		catch (Throwable ex)
		{
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}
