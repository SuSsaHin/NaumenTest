package com.mygwt.mymvn.client;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.mygwt.mymvn.client.places.RecordAddPlace;
import com.mygwt.mymvn.client.places.RecordCardPlace;
import com.mygwt.mymvn.client.rpc.AddAction;
import com.mygwt.mymvn.client.rpc.AddResult;
import com.mygwt.mymvn.client.widgets.RecordEditWidget;
import com.mygwt.mymvn.shared.PhoneRecord;

public class RecordAddActivity extends AbstractActivity implements
		RecordEditWidget.RecordEditPresenter
{
	private final DispatchAsync dispatcher;
	private final RecordEditWidget display;
	private final ClientFactory clientFactory;

	public RecordAddActivity(RecordAddPlace place, ClientFactory clientFactory)
	{
		this.clientFactory = clientFactory;
		dispatcher = clientFactory.getDispatcher();
		display = clientFactory.getRecordEditWidget();
	}

	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus)
	{
		Window.setTitle("Add");
		
		display.setPresenter(this);
		display.setName("");
		display.setPhone("");
		
		panel.setWidget(display.asWidget());
	}

	@Override
	public void save(String name, String phone)
	{
		dispatcher.execute(
				new AddAction(new PhoneRecord(name, phone)),
				new AsyncCallback<AddResult>()
				{
					public void onFailure(final Throwable cause)
					{
						Window.alert(Messages.SERVER_ERROR);
					}

					public void onSuccess(final AddResult result)
					{
						if (result.getId() < 0)
						{
							Window.alert(Messages.ALREADY_EXISTED_RECORD);
							return;
						}
						
						clientFactory.getPlaceController().goTo(new RecordCardPlace(Long.toString(result.getId())));
					}
				});
	}
}
