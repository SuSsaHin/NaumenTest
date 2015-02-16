package com.mygwt.mymvn.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper
{
	private ClientFactory clientFactory;

	public AppActivityMapper(ClientFactory clientFactory)
	{
		super();
		this.clientFactory = clientFactory;
	}

	public Activity getActivity(Place place)
	{
		if (place instanceof RecordsPlace)
			return new RecordsActivity((RecordsPlace) place, clientFactory);
		if (place instanceof RecordCardPlace)
			return new RecordCardActivity((RecordCardPlace) place, clientFactory);
		return null;
	}
}