package com.mygwt.mymvn.client;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.mygwt.mymvn.client.widgets.RecordCardWidget;
import com.mygwt.mymvn.client.widgets.RecordEditWidget;
import com.mygwt.mymvn.client.widgets.RecordsWidget;

public interface ClientFactory
{
    EventBus getEventBus();
    PlaceController getPlaceController();
    RecordsWidget getRecordsWidget();
    RecordCardWidget getRecordCardWidget();
    DispatchAsync getDispatcher();

	RecordEditWidget getRecordEditWidget();
}
