package com.mygwt.mymvn.client;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.mygwt.mymvn.client.events.DeleteEvent;
import com.mygwt.mymvn.client.places.RecordCardPlace;
import com.mygwt.mymvn.client.rpc.ContainsAction;
import com.mygwt.mymvn.client.rpc.ContainsResult;
import com.mygwt.mymvn.client.rpc.DeleteAction;
import com.mygwt.mymvn.client.rpc.DeleteResult;
import com.mygwt.mymvn.client.widgets.RecordCardWidget;
import com.mygwt.mymvn.shared.PhoneRecord;

public class RecordCardActivity extends AbstractActivity implements
		RecordCardWidget.RecordCardPresenter
{
	private final DispatchAsync dispatcher;
	private final RecordCardWidget display;
	private final ClientFactory clientFactory;
	private final PhoneRecord record;

	public RecordCardActivity(RecordCardPlace place, ClientFactory clientFactory)
	{
		this.clientFactory = clientFactory;
		dispatcher = clientFactory.getDispatcher();
		display = clientFactory.getRecordCardWidget();
		record = place.getRecord();
	}

	public void start(AcceptsOneWidget panel,
			com.google.gwt.event.shared.EventBus eventBus)
	{
		dispatcher.execute(
				new ContainsAction(record),
				new AsyncCallback<ContainsResult>()
				{
					public void onFailure(final Throwable cause)
					{
						Window.alert(Messages.SERVER_ERROR);
					}

					public void onSuccess(final ContainsResult result)
					{
						if (result.getResult())
							return;
						
						Window.alert(Messages.BAD_RECORD);
						closeWindow();
					}
				});

		display.setPresenter(this);
		display.setName(record.getName());
		display.setPhone(record.getPhone());
		
		panel.setWidget(display.asWidget());
	}

	public void delete()
	{
		dispatcher.execute(
				new DeleteAction(record),
				new AsyncCallback<DeleteResult>()
				{
					public void onFailure(final Throwable cause)
					{
						Window.alert(Messages.SERVER_ERROR);
					}

					public void onSuccess(final DeleteResult result)
					{
					}
				});
		EventBus eventBus = clientFactory.getEventBus();
		eventBus.fireEvent(new DeleteEvent(record));
		closeWindow();
	}

	private native void closeWindow()/*-{
		$wnd.close();
	}-*/;
}
