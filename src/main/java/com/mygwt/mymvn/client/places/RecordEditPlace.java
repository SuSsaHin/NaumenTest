package com.mygwt.mymvn.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class RecordEditPlace extends Place
{
	public static final String tokenPrefix = "edit";
	private Long recordId;

	public RecordEditPlace(String token)
	{
		try
		{
			recordId = Long.parseLong(token);
		}
		catch (NumberFormatException ex)
		{
			recordId = -1L;
		}
	}

	public Long getRecordId()
	{
		return recordId;
	}

	@Prefix(value = tokenPrefix)
	public static class Tokenizer implements PlaceTokenizer<RecordEditPlace>
	{
		@Override
		public String getToken(RecordEditPlace place)
		{
			return place.getRecordId().toString();
		}

		@Override
		public RecordEditPlace getPlace(String token)
		{
			return new RecordEditPlace(token);
		}
	}
}
