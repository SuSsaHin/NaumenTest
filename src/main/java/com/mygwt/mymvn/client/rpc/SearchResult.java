package com.mygwt.mymvn.client.rpc;

import java.util.ArrayList;

import net.customware.gwt.dispatch.shared.Result;

import com.mygwt.mymvn.shared.PhoneRecord;

public class SearchResult implements Result
{
	private ArrayList<PhoneRecord> records;

	public SearchResult()
	{
	}

	public SearchResult(ArrayList<PhoneRecord> records)
	{
		this.records = records;
	}

	public ArrayList<PhoneRecord> getRecords()
	{
		return records;
	}
}
