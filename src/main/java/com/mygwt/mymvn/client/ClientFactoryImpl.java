package com.mygwt.mymvn.client;

import net.customware.gwt.dispatch.client.DefaultExceptionHandler;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.client.standard.StandardDispatchAsync;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public class ClientFactoryImpl implements ClientFactory
{
	private final EventBus eventBus = new SimpleEventBus();
	private final PlaceController placeController = new PlaceController(eventBus);
	private final RecordsWidget recordsWidget = new RecordsView();
	private final RecordCardWidget recordCardWidget = new RecordCardView();
	private final DispatchAsync dispatcher = new StandardDispatchAsync(
			new DefaultExceptionHandler());
	
	public EventBus getEventBus()
	{
		return eventBus;
	}
	
	public PlaceController getPlaceController()
	{
		return placeController;
	}
	
	public RecordsWidget getRecordsWidget()
	{
		return recordsWidget;
	}

	public DispatchAsync getDispatcher()
	{
		return dispatcher;
	}

	public RecordCardWidget getRecordCardWidget()
	{
		return recordCardWidget;
	}
}
