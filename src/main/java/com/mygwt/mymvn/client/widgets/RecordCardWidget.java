package com.mygwt.mymvn.client.widgets;

import com.google.gwt.user.client.ui.IsWidget;

public interface RecordCardWidget extends IsWidget
{
	void setPresenter(final RecordCardWidget.RecordCardPresenter presenter);
	void setName(String name);
	void setPhone(String phone);

	interface RecordCardPresenter
	{
		void delete();
		void edit();
	}
}
