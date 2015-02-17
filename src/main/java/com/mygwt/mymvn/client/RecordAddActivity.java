package com.mygwt.mymvn.client;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.mygwt.mymvn.client.places.RecordAddPlace;
import com.mygwt.mymvn.client.places.RecordCardPlace;
import com.mygwt.mymvn.client.places.RecordsPlace;
import com.mygwt.mymvn.client.rpc.AddAction;
import com.mygwt.mymvn.client.rpc.AddResult;
import com.mygwt.mymvn.client.widgets.RecordEditWidget;
import com.mygwt.mymvn.shared.PhoneRecord;

public class RecordAddActivity extends AbstractActivity implements
		RecordEditWidget.RecordEditPresenter
{
	private final DispatchAsync dispatcher;
	private final RecordEditWidget widget;
	private final PlaceController placeController;

	public RecordAddActivity(RecordAddPlace place, ClientFactory clientFactory)
	{
		placeController = clientFactory.getPlaceController();
		dispatcher = clientFactory.getDispatcher();
		widget = clientFactory.getRecordEditWidget();
	}


	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus)
	{
		Window.setTitle("Add");
		
		widget.setPresenter(this);
		widget.setName("");
		widget.setPhone("");
		
		panel.setWidget(widget.asWidget());
	}

	@Override
	public void save(String name, String phone)
	{
		if (!PhoneRecord.verifyName(name))
		{
			Window.alert(Messages.BAD_NAME_FORMAT);
			return;
		}
		
		if (!PhoneRecord.verifyPhone(phone))
		{
			Window.alert(Messages.BAD_PHONE_FORMAT);
			return;
		}
		
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
						
						placeController.goTo(new RecordCardPlace(Long.toString(result.getId())));
					}
				});
	}

	@Override
	public void back()
	{
		placeController.goTo(new RecordsPlace(""));
	}
}
