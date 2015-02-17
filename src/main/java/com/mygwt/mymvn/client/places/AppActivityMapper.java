package com.mygwt.mymvn.client.places;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.mygwt.mymvn.client.ClientFactory;
import com.mygwt.mymvn.client.RecordAddActivity;
import com.mygwt.mymvn.client.RecordCardActivity;
import com.mygwt.mymvn.client.RecordEditActivity;
import com.mygwt.mymvn.client.RecordsActivity;

public class AppActivityMapper implements ActivityMapper
{
	private ClientFactory clientFactory;

	public AppActivityMapper(ClientFactory clientFactory)
	{
		super();
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place)
	{
		if (place instanceof RecordsPlace)
			return new RecordsActivity((RecordsPlace) place, clientFactory);
		if (place instanceof RecordCardPlace)
			return new RecordCardActivity((RecordCardPlace) place, clientFactory);
		if (place instanceof RecordEditPlace)
			return new RecordEditActivity((RecordEditPlace) place, clientFactory);
		if (place instanceof RecordAddPlace)
			return new RecordAddActivity((RecordAddPlace) place, clientFactory);
		return null;
	}
}