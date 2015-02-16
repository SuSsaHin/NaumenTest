package com.mygwt.mymvn.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface RecordsWidget extends IsWidget
{
	void setSearchText(String searchText);
	
	void setPresenter(final RecordsWidget.RecordsPresenter recordsPreseter);

	void setTableContent(String[][] tableContent);

	interface RecordsPresenter
	{
		void goTo(Place place);
		void delete(int rowIndex);
		void edit(int rowIndex);
	}
}
