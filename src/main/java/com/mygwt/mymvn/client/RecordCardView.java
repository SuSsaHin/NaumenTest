package com.mygwt.mymvn.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;

public class RecordCardView extends Composite implements RecordCardWidget
{
	private final Label name;
	private final Label phone;
	private final Button editButton;
	private final Button deleteButton;

	private RecordCardWidget.RecordCardPresenter recordCardPresenter;

	public RecordCardView()
	{
		Grid grid = new Grid(3, 2); 
		initWidget(grid);

		name = new Label();
		phone = new Label();
		
		editButton = new Button("Edit");
		editButton.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event)
			{
				onEditClick();
			}
		});

		deleteButton = new Button("Delete");
		deleteButton.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event)
			{
				onDeleteClick();
			}
		});

		grid.setWidget(0, 0, new Label("Name"));
		grid.setWidget(0, 1, new Label("Phone"));
		grid.setWidget(1, 0, name);
		grid.setWidget(1, 1, phone);
		grid.setWidget(2, 0, editButton);
		grid.setWidget(2, 1, deleteButton);
	}
	
	private void onEditClick()
	{
		
	}
	
	private void onDeleteClick()
	{
		recordCardPresenter.delete();
	}

	public void setPresenter(RecordCardPresenter recordCardPresenter)
	{
		this.recordCardPresenter = recordCardPresenter;
	}

	public void setName(String name)
	{
		this.name.setText(name);
	}

	public void setPhone(String phone)
	{
		this.phone.setText(phone);
	}
}
