package com.mygwt.mymvn.server.logic;

public interface PhoneRecordsRepository {
	void add(PhoneRecord added);
	void delete(PhoneRecord deleted);
	void edit(PhoneRecord source, PhoneRecord dest);
	PhoneRecord[] get();
	PhoneRecord[] get(String namePart);
}
