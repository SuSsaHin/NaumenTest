package com.mygwt.mymvn.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import com.mygwt.mymvn.shared.PhoneRecord;

public class RecordCardPlace extends Place
{
	private PhoneRecord record;
	private static final String tokenPrefix = "edit";
	private static final String separator = ":";

	public RecordCardPlace(String token)
	{
		String[] parts = token.split(separator);
		if (parts.length != PhoneRecord.fieldsCount)
		{
			record = null;
			return;
		}
		this.record = new PhoneRecord(parts[0], parts[1]);
	}

	public PhoneRecord getRecord()
	{
		return record;
	}

	@Prefix(value = tokenPrefix)
	public static class Tokenizer implements PlaceTokenizer<RecordCardPlace>
	{
		public String getToken(RecordCardPlace place)
		{
			return place.getRecord().getName() + separator + place.getRecord().getPhone();
		}

		public RecordCardPlace getPlace(String token)
		{
			return new RecordCardPlace(token);
		}
	}
}
