package com.mygwt.mymvn.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class RecordsPlace extends Place
{
	private String namesPart;
	private static final String TOKEN_PREFIX = "find";

	public RecordsPlace(String token)
	{
		this.namesPart = token;
	}

	public String getNamesPart()
	{
		return namesPart;
	}

	@Prefix(value = TOKEN_PREFIX)
	public static class Tokenizer implements PlaceTokenizer<RecordsPlace>
	{
		public String getToken(RecordsPlace place)
		{
			return place.getNamesPart();
		}

		public RecordsPlace getPlace(String token)
		{
			return new RecordsPlace(token);
		}
	}
}
