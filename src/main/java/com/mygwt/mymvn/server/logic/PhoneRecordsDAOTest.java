package com.mygwt.mymvn.server.logic;

import java.util.ArrayList;

import com.mygwt.mymvn.shared.PhoneRecord;

public class PhoneRecordsDAOTest implements PhoneRecordsDAO
{
	private static long id = 1;
	private final ArrayList<PhoneRecord> records;

	PhoneRecordsDAOTest()
	{
		records = new ArrayList<PhoneRecord>();
		add(new PhoneRecord("n1", "8888"));
		add(new PhoneRecord("n2", "9999"));
		add(new PhoneRecord("n3", "1111"));
	}

	@Override
	public void add(PhoneRecord added)
	{
		added.setId(id++);
		if (records.contains(added))
			return;

		records.add(added);
	}

	@Override
	public void edit(PhoneRecord source, PhoneRecord dest)
	{
		int index = records.indexOf(source);
		if (index == -1)
			return;

		records.set(index, dest);
	}
	
	@Override
	public ArrayList<PhoneRecord> getAll()
	{
		return records;
	}

	@Override
	public ArrayList<PhoneRecord> get(String namePart)
	{
		ArrayList<PhoneRecord> result = new ArrayList<PhoneRecord>();
		for (PhoneRecord record : records)
		{
			if (!record.getName().contains(namePart))
				continue;

			result.add(record);
		}
		return result;
	}

	@Override
	public void delete(long deletedId)
	{
		records.removeIf(p->p.getId() == id);
	}

	@Override
	public PhoneRecord get(long id)
	{
		for (PhoneRecord record : records)
		{
			if (record.getId() == id)
			{
				return record;
			}
		}
		return null;
	}
}
