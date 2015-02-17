package com.mygwt.mymvn.client.widgets;

import com.google.gwt.user.client.ui.IsWidget;

public interface RecordsWidget extends IsWidget
{
	void setSearchText(String searchText);
	
	void setPresenter(final RecordsWidget.RecordsPresenter preseter);

	void setTableContent(String[][] tableContent);
	
	void removeRow(int index);

	interface RecordsPresenter
	{
		void search(String text);
		void delete(int rowIndex);
		void open(int rowIndex);
		void edit(int rowIndex);
		void add();
	}
}
