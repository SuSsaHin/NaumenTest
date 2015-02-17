package com.mygwt.mymvn.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;
import com.mygwt.mymvn.client.places.AppActivityMapper;
import com.mygwt.mymvn.client.places.AppPlaceHistoryMapper;
import com.mygwt.mymvn.client.places.RecordsPlace;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MyGwt implements EntryPoint
{
	private Place defaultPlace = new RecordsPlace("");
	private SimplePanel appWidget = new SimplePanel();

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad()
	{
		//ClientFactory clientFactory = GWT.create(ClientFactory.class);
		ClientFactory clientFactory = new ClientFactoryImpl();
		EventBus eventBus = clientFactory.getSimpleEventBus();
		PlaceController placeController = clientFactory.getPlaceController();

		ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
		ActivityManager activityManager = new ActivityManager(activityMapper,
				eventBus);
		activityManager.setDisplay(appWidget);

		AppPlaceHistoryMapper historyMapper = GWT
				.create(AppPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(
				historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);

		RootPanel.get().add(appWidget);

		historyHandler.handleCurrentHistory();
	}
}
