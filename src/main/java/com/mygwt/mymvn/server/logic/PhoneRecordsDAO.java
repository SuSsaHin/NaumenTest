package com.mygwt.mymvn.server.logic;

import java.util.ArrayList;

import com.mygwt.mymvn.shared.PhoneRecord;

public interface PhoneRecordsDAO
{
	void add(PhoneRecord added);

	void delete(long deletedId);

	void edit(PhoneRecord source, PhoneRecord dest);
	
	PhoneRecord get(long id);
	
	ArrayList<PhoneRecord> get(String namePart);

	ArrayList<PhoneRecord> getAll();
}
