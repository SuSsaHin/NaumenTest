package com.mygwt.mymvn.server.logic;

import java.util.ArrayList;

import com.mygwt.mymvn.shared.PhoneRecord;

public class PhoneRecordsDAOTest implements PhoneRecordsDAO
{
	private static long nextId = 1;
	private final ArrayList<PhoneRecord> records;

	PhoneRecordsDAOTest()
	{
		records = new ArrayList<PhoneRecord>();
		add(new PhoneRecord("qqqq", "8888"));
		add(new PhoneRecord("wwww", "9999"));
		add(new PhoneRecord("eeee", "1111"));
	}

	@Override
	public long add(final PhoneRecord added)
	{
		if (records.contains(added))
			return -1;
		
		added.setId(nextId);
		records.add(added);
		
		return nextId++;
	}

	@Override
	public boolean update(final long updatedId, final PhoneRecord dest)
	{
		PhoneRecord record = get(updatedId);
		if (record == null || records.contains(dest))
			return false;

		record.setName(dest.getName());
		record.setPhone(dest.getPhone());
		return true;
	}
	
	@Override
	public ArrayList<PhoneRecord> getAll()
	{
		return records;
	}

	@Override
	public ArrayList<PhoneRecord> get(final String namePart)
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
	public void delete(final long deletedId)
	{
		records.removeIf(p->p.getId() == deletedId);
	}

	@Override
	public PhoneRecord get(final long id)
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
