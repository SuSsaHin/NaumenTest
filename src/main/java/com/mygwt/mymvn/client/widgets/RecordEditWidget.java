package com.mygwt.mymvn.client.widgets;

import com.google.gwt.user.client.ui.IsWidget;

public interface RecordEditWidget extends IsWidget
{
	void setPresenter(final RecordEditWidget.RecordEditPresenter presenter);
	void setName(String name);
	void setPhone(String phone);

	interface RecordEditPresenter
	{
		void save(String name, String text);
	}
}

