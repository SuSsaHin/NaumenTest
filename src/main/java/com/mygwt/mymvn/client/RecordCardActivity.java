package com.mygwt.mymvn.client;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.mygwt.mymvn.client.places.RecordCardPlace;
import com.mygwt.mymvn.client.places.RecordEditPlace;
import com.mygwt.mymvn.client.places.RecordsPlace;
import com.mygwt.mymvn.client.rpc.DeleteAction;
import com.mygwt.mymvn.client.rpc.DeleteResult;
import com.mygwt.mymvn.client.rpc.GetByIdAction;
import com.mygwt.mymvn.client.rpc.GetByIdResult;
import com.mygwt.mymvn.client.widgets.RecordCardWidget;
import com.mygwt.mymvn.shared.PhoneRecord;

public class RecordCardActivity extends AbstractActivity implements
		RecordCardWidget.RecordCardPresenter
{
	private final DispatchAsync dispatcher;
	private final RecordCardWidget widget;
	private final PlaceController placeController;
	
	private final long recordId;

	public RecordCardActivity(RecordCardPlace place, ClientFactory clientFactory)
	{
		placeController = clientFactory.getPlaceController();
		dispatcher = clientFactory.getDispatcher();
		widget = clientFactory.getRecordCardWidget();
		recordId = place.getRecordId();
	}

	@Override
	public void start(final AcceptsOneWidget panel, com.google.gwt.event.shared.EventBus eventBus)
	{
		Window.setTitle("Card");
		if (recordId == -1)
		{
			Window.alert(Messages.BAD_URL);
			return;
		}
		
		final RecordCardWidget.RecordCardPresenter presenter = this;
		
		dispatcher.execute(
				new GetByIdAction(recordId),
				new AsyncCallback<GetByIdResult>()
				{
					public void onFailure(final Throwable cause)
					{
						Window.alert(Messages.SERVER_ERROR);
					}

					public void onSuccess(final GetByIdResult result)
					{
						PhoneRecord record = result.getRecord();
						if (record == null)
						{
							Window.alert(Messages.NONEXISTENT_RECORD);
							return;
						}
						
						widget.setPresenter(presenter);
						widget.setName(record.getName());
						widget.setPhone(record.getPhone());
						
						panel.setWidget(widget.asWidget());
					}
				});
	}

	@Override
	public void delete()
	{
		if(!Window.confirm(Messages.CONFIRM_DELETE))
			return;
		
		dispatcher.execute(
				new DeleteAction(recordId),
				new AsyncCallback<DeleteResult>()
				{
					public void onFailure(final Throwable cause)
					{
						Window.alert(Messages.SERVER_ERROR);
					}

					public void onSuccess(final DeleteResult result)
					{
						back();
					}
				});
	}

	@Override
	public void edit()
	{
		placeController.goTo(new RecordEditPlace(Long.toString(recordId)));
	}

	@Override
	public void back()
	{
		placeController.goTo(new RecordsPlace(""));
	}
}
