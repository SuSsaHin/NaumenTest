package com.mygwt.mymvn.client;

import net.customware.gwt.dispatch.client.DefaultExceptionHandler;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.client.standard.StandardDispatchAsync;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.mygwt.mymvn.client.widgets.RecordCardView;
import com.mygwt.mymvn.client.widgets.RecordCardWidget;
import com.mygwt.mymvn.client.widgets.RecordsView;
import com.mygwt.mymvn.client.widgets.RecordsWidget;

public class ClientFactoryImpl implements ClientFactory
{
	private final EventBus eventBus = new SimpleEventBus();
	private final PlaceController placeController = new PlaceController(eventBus);
	private final RecordsWidget recordsWidget = new RecordsView();
	private final RecordCardWidget recordCardWidget = new RecordCardView();
	private final DispatchAsync dispatcher = new StandardDispatchAsync(
			new DefaultExceptionHandler());
	
	@Override
	public EventBus getEventBus()
	{
		return eventBus;
	}
	
	@Override
	public PlaceController getPlaceController()
	{
		return placeController;
	}
	
	@Override
	public RecordsWidget getRecordsWidget()
	{
		return recordsWidget;
	}

	@Override
	public DispatchAsync getDispatcher()
	{
		return dispatcher;
	}

	@Override
	public RecordCardWidget getRecordCardWidget()
	{
		return recordCardWidget;
	}
}
