package com.mygwt.mymvn.client;

import java.util.ArrayList;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HasValue;
import com.mygwt.mymvn.client.RecordsPresenter.RecordsDisplay;
import com.mygwt.mymvn.client.rpc.SearchAction;
import com.mygwt.mymvn.client.rpc.SearchResult;
import com.mygwt.mymvn.shared.PhoneRecord;

public class RecordsPresenter extends WidgetPresenter<RecordsDisplay>
{

	public interface RecordsDisplay extends WidgetDisplay
	{
		HasClickHandlers getSearch();

		HasValue<String> getSearchText();

		HTMLTable getTable();

		void setTableSize(int rowsCount, int columnsCount);
	}

	private final DispatchAsync dispatcher;

	public RecordsPresenter(final RecordsDisplay display,
			final EventBus eventBus, final DispatchAsync dispatcher)
	{
		super(display, eventBus);
		this.dispatcher = dispatcher;

		bind();
		sendSearch();
	}

	private void sendSearch()
	{
		dispatcher.execute(
				new SearchAction(display.getSearchText().getValue()),
				new AsyncCallback<SearchResult>()
				{

					public void onFailure(final Throwable cause)
					{
						Window.alert(Messages.SERVER_ERROR);
					}

					public void onSuccess(final SearchResult result)
					{
						ArrayList<PhoneRecord> records = result.getRecords();
						int recordsSize = records.size();
						display.setTableSize(recordsSize, 2);
						HTMLTable table = display.getTable();
						for (int row = 0; row < recordsSize; ++row)
						{
							table.setText(row, 0, records.get(row).getName());
							table.setText(row, 1, records.get(row).getPhone());
						}
					}
				});
		// eventBus.fireEvent(event);
	}

	@Override
	protected void onBind()
	{
		display.getSearch().addClickHandler(new ClickHandler()
		{
			public void onClick(final ClickEvent event)
			{
				sendSearch();
			}
		});
	}

	@Override
	protected void onUnbind()
	{
	}

	@Override
	protected void onRevealDisplay()
	{
	}
}
