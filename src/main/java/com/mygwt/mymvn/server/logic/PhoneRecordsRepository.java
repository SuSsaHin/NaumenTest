package com.mygwt.mymvn.server.logic;

import java.util.ArrayList;

import com.mygwt.mymvn.shared.PhoneRecord;

public interface PhoneRecordsRepository
{
	void add(PhoneRecord added);

	void delete(PhoneRecord deleted);

	void edit(PhoneRecord source, PhoneRecord dest);

	ArrayList<PhoneRecord> get();

	ArrayList<PhoneRecord> get(String namePart);
}
