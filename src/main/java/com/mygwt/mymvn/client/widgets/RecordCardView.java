package com.mygwt.mymvn.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;

public class RecordCardView extends Composite implements RecordCardWidget
{
	private final Label name;
	private final Label phone;
	private final Button editButton;
	private final Button deleteButton;

	private RecordCardWidget.RecordCardPresenter presenter;

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
		presenter.edit();
	}
	
	private void onDeleteClick()
	{
		presenter.delete();
	}

	@Override
	public void setPresenter(RecordCardPresenter presenter)
	{
		this.presenter = presenter;
	}

	@Override
	public void setName(String name)
	{
		this.name.setText(name);
	}

	@Override
	public void setPhone(String phone)
	{
		this.phone.setText(phone);
	}
}
