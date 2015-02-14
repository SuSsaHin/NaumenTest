package com.mygwt.mymvn.client;

import net.customware.gwt.presenter.client.DefaultEventBus;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MyGwt implements EntryPoint {
  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network "
      + "connection and try again.";

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

  private final Messages messages = GWT.create(Messages.class);

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
	  final DefaultEventBus eventBus = new DefaultEventBus();
		final GreetingView greetingView = new GreetingView();
		final GreetingPresenter greetingPresenter = new GreetingPresenter(greetingView, eventBus);
		final AppPresenter appPresenter = new AppPresenter(greetingPresenter);
		
		appPresenter.go(RootPanel.get());
  }
}
