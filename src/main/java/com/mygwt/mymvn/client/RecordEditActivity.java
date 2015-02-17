package com.mygwt.mymvn.client;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.mygwt.mymvn.client.places.RecordCardPlace;
import com.mygwt.mymvn.client.places.RecordEditPlace;
import com.mygwt.mymvn.client.rpc.EditAction;
import com.mygwt.mymvn.client.rpc.EditResult;
import com.mygwt.mymvn.client.rpc.GetByIdAction;
import com.mygwt.mymvn.client.rpc.GetByIdResult;
import com.mygwt.mymvn.client.widgets.RecordEditWidget;
import com.mygwt.mymvn.shared.PhoneRecord;

public class RecordEditActivity extends AbstractActivity implements
		RecordEditWidget.RecordEditPresenter
{
	private final DispatchAsync dispatcher;
	private final RecordEditWidget display;
	private ClientFactory clientFactory;
	private final long recordId;

	public RecordEditActivity(RecordEditPlace place, ClientFactory clientFactory)
	{
		this.clientFactory = clientFactory;
		dispatcher = clientFactory.getDispatcher();
		display = clientFactory.getRecordEditWidget();
		recordId = place.getRecordId();
	}

	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus)
	{
		Window.setTitle("Edit");
		
		final RecordEditWidget.RecordEditPresenter presenter = this;
		
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
						
						display.setPresenter(presenter);
						display.setName(record.getName());
						display.setPhone(record.getPhone());
						
						panel.setWidget(display.asWidget());
					}
				});
	}

	@Override
	public void save(String name, String phone)
	{
		dispatcher.execute(
				new EditAction(recordId, new PhoneRecord(name, phone)),
				new AsyncCallback<EditResult>()
				{
					public void onFailure(final Throwable cause)
					{
						Window.alert(Messages.SERVER_ERROR);
					}

					public void onSuccess(final EditResult result)
					{
						if (!result.isUpdated())
						{
							Window.alert(Messages.ALREADY_EXISTED_RECORD);
							return;
						}
						
						clientFactory.getPlaceController().goTo(new RecordCardPlace(Long.toString(recordId)));
					}
				});
	}
}
