package com.mygwt.mymvn.server.logic;

import java.util.ArrayList;

import com.mygwt.mymvn.shared.PhoneRecord;

public interface PhoneRecordsDAO
{
	long add(final PhoneRecord added);

	void delete(final long deletedId);

	boolean update(final long updatedId, final PhoneRecord dest);
	
	PhoneRecord get(final long id);
	
	ArrayList<PhoneRecord> get(final String namePart);

	ArrayList<PhoneRecord> getAll();
}
