package com.mygwt.mymvn.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class RecordCardPlace extends Place
{
	public static final String tokenPrefix = "open";
	private Long recordId;

	public RecordCardPlace(String token)
	{
		try
		{
			recordId = Long.parseLong(token);
		}
		catch (NumberFormatException ex)
		{}
	}

	public Long getRecordId()
	{
		return recordId;
	}

	@Prefix(value = tokenPrefix)
	public static class Tokenizer implements PlaceTokenizer<RecordCardPlace>
	{
		@Override
		public String getToken(RecordCardPlace place)
		{
			return place.getRecordId().toString();
		}

		@Override
		public RecordCardPlace getPlace(String token)
		{
			return new RecordCardPlace(token);
		}
	}
}
