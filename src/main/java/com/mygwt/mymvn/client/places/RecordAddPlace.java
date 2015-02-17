package com.mygwt.mymvn.client.places;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class RecordAddPlace extends Place
{
	public static final String tokenPrefix = "add";

	public RecordAddPlace()
	{
	}

	@Prefix(value = tokenPrefix)
	public static class Tokenizer implements PlaceTokenizer<RecordAddPlace>
	{
		@Override
		public String getToken(RecordAddPlace place)
		{
			return "";
		}

		@Override
		public RecordAddPlace getPlace(String token)
		{
			return new RecordAddPlace();
		}
	}
}
