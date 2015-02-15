package com.mygwt.mymvn.client;

import net.customware.gwt.dispatch.client.DefaultExceptionHandler;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.client.standard.StandardDispatchAsync;
import net.customware.gwt.presenter.client.DefaultEventBus;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MyGwt implements EntryPoint {
  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
	  final DefaultEventBus eventBus = new DefaultEventBus();
		final GreetingView greetingView = new GreetingView();
		final DispatchAsync dispatcher = new StandardDispatchAsync(new DefaultExceptionHandler());
		
		final GreetingPresenter greetingPresenter = new GreetingPresenter(greetingView, eventBus, dispatcher);
		final AppPresenter appPresenter = new AppPresenter(greetingPresenter);
		
		appPresenter.go(RootPanel.get());
		
		
  }
}
