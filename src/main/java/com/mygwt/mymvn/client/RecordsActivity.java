package com.mygwt.mymvn.client;

import java.util.ArrayList;

import net.customware.gwt.dispatch.client.DispatchAsync;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.mygwt.mymvn.client.places.RecordAddPlace;
import com.mygwt.mymvn.client.places.RecordCardPlace;
import com.mygwt.mymvn.client.places.RecordEditPlace;
import com.mygwt.mymvn.client.places.RecordsPlace;
import com.mygwt.mymvn.client.rpc.DeleteAction;
import com.mygwt.mymvn.client.rpc.DeleteResult;
import com.mygwt.mymvn.client.rpc.SearchAction;
import com.mygwt.mymvn.client.rpc.SearchResult;
import com.mygwt.mymvn.client.widgets.RecordsWidget;
import com.mygwt.mymvn.shared.PhoneRecord;

public class RecordsActivity extends AbstractActivity implements
		RecordsWidget.RecordsPresenter
{
	private final DispatchAsync dispatcher;
	private final RecordsWidget display;
	private final PlaceController placeController;
	private final String searchedText;
	private ArrayList<PhoneRecord> records;

	public RecordsActivity(RecordsPlace place, ClientFactory clientFactory)
	{
		placeController = clientFactory.getPlaceController();
		dispatcher = clientFactory.getDispatcher();
		display = clientFactory.getRecordsWidget();
		searchedText = place.getNamesPart();
		records = new ArrayList<PhoneRecord>();
	}

	public void updateTableContent()
	{
		dispatcher.execute(new SearchAction(searchedText),
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

	@Override
	public void start(AcceptsOneWidget panel,
			com.google.gwt.event.shared.EventBus eventBus)
	{
		Window.setTitle("PhoneBook");

		display.setSearchText(searchedText);
		display.setPresenter(this);
		updateTableContent();

		panel.setWidget(display.asWidget());
	}

	@Override
	public void delete(final int rowIndex)
	{
		dispatcher.execute(new DeleteAction(records.get(rowIndex).getId()),
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

	@Override
	public void open(final int rowIndex)
	{
		PhoneRecord opened = records.get(rowIndex);
		placeController.goTo(new RecordCardPlace(Long.toString(opened.getId())));
	}

	@Override
	public void search(String text)
	{
		placeController.goTo(new RecordsPlace(text));
	}

	@Override
	public void edit(int rowIndex)
	{
		PhoneRecord edited = records.get(rowIndex);
		placeController.goTo(new RecordEditPlace(Long.toString(edited.getId())));
	}

	@Override
	public void add()
	{
		placeController.goTo(new RecordAddPlace());
	}
}
