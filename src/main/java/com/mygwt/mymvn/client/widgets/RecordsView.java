package com.mygwt.mymvn.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextBox;

public class RecordsView extends Composite implements RecordsWidget
{
	private final TextBox searchText;
	private final Button addButton;
	private final Button searchButton;
	private final FlexTable records;

	private RecordsWidget.RecordsPresenter recordsPreseter;

	public RecordsView()
	{
		FlowPanel panel = new FlowPanel();
		initWidget(panel);
		
		searchText = new TextBox();
		panel.add(searchText);

		searchButton = new Button("Search");
		searchButton.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event)
			{
				onSearchClick();
			}
		});
		panel.add(searchButton);
		
		addButton = new Button("Add");
		addButton.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event)
			{
				onAddClick();
			}
		});
		panel.add(addButton);
		
		records = new FlexTable();
		panel.add(records);
		
	}

	private void onSearchClick()
	{
		recordsPreseter.search(searchText.getText());
	}

	private void onDeleteClick(int rowIndex)
	{
		recordsPreseter.delete(rowIndex);
		records.removeRow(rowIndex);
	}
	
	private void onOpenClick(int rowIndex)
	{
		recordsPreseter.open(rowIndex);
	}
	
	private void onEditClick(int rowIndex)
	{
		
	}
	
	private void onAddClick()
	{
		
	}
	
	public void setPresenter(final RecordsWidget.RecordsPresenter recordsPreseter)
	{
		this.recordsPreseter = recordsPreseter;
	}

	public void setSearchText(String searchText)
	{
		this.searchText.setText(searchText);
	}

	public void setTableContent(String[][] tableContent)
	{
		records.clear(true);
		if (tableContent.length == 0)
			return;

		int tableWidth = tableContent[0].length;
		for (int row = 0; row < tableContent.length; ++row)
		{
			int rowLength = Math.min(tableWidth, tableContent[row].length);
			for (int col = 0; col < rowLength; ++col)
			{
				records.setText(row, col, tableContent[row][col]);
			}

			final int rowIndex = row;
			
			Button openBtn = new Button("Open");
			openBtn.addClickHandler(new ClickHandler()
			{
				public void onClick(ClickEvent event)
				{
					onOpenClick(rowIndex);
				}
			});
			
			Button editBtn = new Button("Edit");
			editBtn.addClickHandler(new ClickHandler()
			{
				public void onClick(ClickEvent event)
				{
					onEditClick(rowIndex);
				}
			});
			
			Button deleteBtn = new Button("Delete");
			deleteBtn.addClickHandler(new ClickHandler()
			{
				public void onClick(ClickEvent event)
				{
					onDeleteClick(rowIndex);
				}
			});
			
			records.setWidget(row, tableWidth, openBtn);
			records.setWidget(row, tableWidth + 1, editBtn);
			records.setWidget(row, tableWidth + 2, deleteBtn);
		}
	}

	public void removeRow(int rowIndex)
	{
		records.removeRow(rowIndex);
	}
}
