package com.mygwt.mymvn.client;

import com.google.gwt.user.client.ui.HasWidgets;

public class AppPresenter
{
	private HasWidgets container;
	private RecordsPresenter recordsPresenter;

	public AppPresenter(final RecordsPresenter recordsPresenter)
	{
		this.recordsPresenter = recordsPresenter;
	}

	private void showMain()
	{
		container.clear();
		container.add(recordsPresenter.getDisplay().asWidget());
	}

	public void go(final HasWidgets container)
	{
		this.container = container;

		showMain();
	}
}