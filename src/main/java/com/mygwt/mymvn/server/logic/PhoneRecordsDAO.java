package com.mygwt.mymvn.server.logic;

import java.util.ArrayList;

import com.mygwt.mymvn.shared.PhoneRecord;

public interface PhoneRecordsDAO
{
	long add(PhoneRecord added);

	void delete(long deletedId);

	boolean update(long updatedId, PhoneRecord dest);
	
	PhoneRecord get(long id);
	
	ArrayList<PhoneRecord> get(String namePart);

	ArrayList<PhoneRecord> getAll();
}
