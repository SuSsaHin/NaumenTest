package com.mygwt.mymvn.client;

import com.google.gwt.user.client.ui.HasWidgets;

public class AppPresenter {
 private HasWidgets container;
 private GreetingPresenter greetingPresenter;

 public AppPresenter(//final DispatchAsync dispatcher,
       final GreetingPresenter greetingPresenter) {
  this.greetingPresenter = greetingPresenter;  
 }
 
 private void showMain() {
  container.clear();
  container.add(greetingPresenter.getDisplay().asWidget());
 }
  
 public void go(final HasWidgets container) {
  this.container = container;
  
  showMain();
 }
}