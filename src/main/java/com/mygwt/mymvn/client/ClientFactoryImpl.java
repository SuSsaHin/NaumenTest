package com.mygwt.mymvn.client;

import net.customware.gwt.dispatch.client.DefaultExceptionHandler;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.client.standard.StandardDispatchAsync;
import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.mygwt.mymvn.client.widgets.RecordCardView;
import com.mygwt.mymvn.client.widgets.RecordCardWidget;
import com.mygwt.mymvn.client.widgets.RecordEditView;
import com.mygwt.mymvn.client.widgets.RecordEditWidget;
import com.mygwt.mymvn.client.widgets.RecordsView;
import com.mygwt.mymvn.client.widgets.RecordsWidget;

public class ClientFactoryImpl implements ClientFactory
{
	private final com.google.web.bindery.event.shared.EventBus simpleEventBus = new SimpleEventBus();
	private final EventBus eventBus = new DefaultEventBus();
	private final DispatchAsync dispatcher = new StandardDispatchAsync(
			new DefaultExceptionHandler());
	
	private final RecordsWidget recordsWidget = new RecordsView();
	private final RecordCardWidget recordCardWidget = new RecordCardView();
	private final RecordEditWidget recordEditWidget = new RecordEditView();
	
	private final PlaceController placeController = new PlaceController(simpleEventBus);
	
	@Override
	public com.google.web.bindery.event.shared.EventBus getSimpleEventBus()
	{
		return simpleEventBus;
	}
	
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

	@Override
	public RecordEditWidget getRecordEditWidget()
	{
		return recordEditWidget;
	}
}
