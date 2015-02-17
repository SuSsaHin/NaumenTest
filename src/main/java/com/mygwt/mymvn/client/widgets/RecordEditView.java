package com.mygwt.mymvn.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class RecordEditView extends Composite implements RecordEditWidget
{
	private final TextBox name;
	private final TextBox phone;
	private final Button saveButton;

	private RecordEditPresenter presenter;

	public RecordEditView()
	{
		Grid grid = new Grid(3, 2); 
		initWidget(grid);

		name = new TextBox();
		phone = new TextBox();
		
		saveButton = new Button("Save");
		saveButton.addClickHandler(new ClickHandler()
		{
			public void onClick(ClickEvent event)
			{
				onSaveClick();
			}
		});

		grid.setWidget(0, 0, new Label("Name"));
		grid.setWidget(0, 1, new Label("Phone"));
		grid.setWidget(1, 0, name);
		grid.setWidget(1, 1, phone);
		grid.setWidget(2, 0, saveButton);
	}
	
	private void onSaveClick()
	{
		presenter.save(name.getText(), phone.getText());
	}

	@Override
	public void setPresenter(RecordEditPresenter recordCardPresenter)
	{
		this.presenter = recordCardPresenter;
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
