package com.mygwt.mymvn.client;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.mygwt.mymvn.client.RecordsPresenter.RecordsDisplay;

public class RecordsView extends Composite implements RecordsDisplay
{
	private final TextBox searchText;
	private final Button searchButton;
	private final Grid records;

	public RecordsView()
	{
		FlowPanel panel = new FlowPanel();
		initWidget(panel);

		searchText = new TextBox();
		panel.add(searchText);

		searchButton = new Button("Search");
		panel.add(searchButton);

		records = new Grid();
		panel.add(records);

		RootPanel.get("searchTextContainer").add(searchText);
		RootPanel.get("searchButtonContainer").add(searchButton);
		RootPanel.get("recordsTable").add(records);
	}

	public HasClickHandlers getSearch()
	{
		return searchButton;
	}

	public HasValue<String> getSearchText()
	{
		return searchText;
	}

	public HTMLTable getTable()
	{
		return records;
	}

	public void setTableSize(int rowsCount, int columnsCount)
	{
		records.clear();
		records.resize(rowsCount, columnsCount);
	}
}
