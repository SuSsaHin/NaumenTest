package com.mygwt.mymvn.server.logic;

import java.util.ArrayList;

import com.mygwt.mymvn.shared.PhoneRecord;

public class TestRepository implements PhoneRecordsRepository
{

	private final ArrayList<PhoneRecord> records;
	private static TestRepository instance;

	private TestRepository()
	{
		records = new ArrayList<PhoneRecord>();
		records.add(new PhoneRecord("n1", "8888"));
		records.add(new PhoneRecord("n2", "9999"));
		records.add(new PhoneRecord("n3", "1111"));
	}

	public static TestRepository getInstance()
	{
		return instance == null ? instance = new TestRepository() : instance;
	}

	public void add(PhoneRecord added)
	{
		if (records.contains(added))
			return;

		records.add(added);
	}

	public void delete(PhoneRecord deleted)
	{
		records.remove(deleted);
	}

	public void edit(PhoneRecord source, PhoneRecord dest)
	{
		int index = records.indexOf(source);
		if (index == -1)
			return;

		records.set(index, dest);
	}

	public ArrayList<PhoneRecord> get()
	{
		return records;
	}

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

	public boolean contains(PhoneRecord record)
	{
		return records.contains(record);
	}
}
