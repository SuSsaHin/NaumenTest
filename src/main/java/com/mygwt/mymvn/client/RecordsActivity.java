package com.mygwt.mymvn.client;

import java.util.ArrayList;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.mygwt.mymvn.client.rpc.DeleteAction;
import com.mygwt.mymvn.client.rpc.DeleteResult;
import com.mygwt.mymvn.client.rpc.SearchAction;
import com.mygwt.mymvn.client.rpc.SearchResult;
import com.mygwt.mymvn.shared.PhoneRecord;

public class RecordsActivity extends AbstractActivity implements
		RecordsWidget.RecordsPresenter
{
	private final DispatchAsync dispatcher;
	private final RecordsWidget display;
	private final ClientFactory clientFactory;
	private final String searchedText; 
	private ArrayList<PhoneRecord> records;

	public RecordsActivity(RecordsPlace place, ClientFactory clientFactory)
	{
		this.clientFactory = clientFactory;
		dispatcher = clientFactory.getDispatcher();
		display = clientFactory.getRecordsWidget();
		searchedText = place.getNamesPart();
		records = new ArrayList<PhoneRecord>();
	}

	public void updateTableContent()
	{
		dispatcher.execute(
				new SearchAction(searchedText),
				new AsyncCallback<SearchResult>()
				{
					public void onFailure(final Throwable cause)
					{
						Window.alert(Messages.SERVER_ERROR);
					}

					public void onSuccess(final SearchResult result)
					{
						records = result.getRecords();
						updateDisplayTable();
					}
				});
	}
	
	private void updateDisplayTable()
	{
		String[][] tableContent = new String[records.size()][PhoneRecord.fieldsCount];

		for (int row = 0; row < records.size(); ++row)
		{
			tableContent[row][0] = records.get(row).getName();
			tableContent[row][1] = records.get(row).getPhone();
		}
		display.setTableContent(tableContent);
	}

	public void start(AcceptsOneWidget panel,
			com.google.gwt.event.shared.EventBus eventBus)
	{
		display.setSearchText(searchedText);
		display.setPresenter(this);
		updateTableContent();
		
		panel.setWidget(display.asWidget());
	}
	
	public void goTo(Place place) {
        clientFactory.getPlaceController().goTo(place);
    }

	public void delete(final int rowIndex)
	{
		dispatcher.execute(
				new DeleteAction(records.get(rowIndex)),
				new AsyncCallback<DeleteResult>()
				{
					public void onFailure(final Throwable cause)
					{
						Window.alert(Messages.SERVER_ERROR);
					}

					public void onSuccess(final DeleteResult result)
					{
						records.remove(rowIndex);
					}
				});
	}
	
	public void edit(final int rowIndex)
	{
		PhoneRecord edited = records.get(rowIndex);
		Window.open("../MyGwt.html#edit:" + edited.getName() + ":" + edited.getPhone(), "Edit", "resizable = false");
	}
}
