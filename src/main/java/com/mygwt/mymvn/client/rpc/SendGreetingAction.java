package com.mygwt.mymvn.client.rpc;

import net.customware.gwt.dispatch.shared.Action;

public class SendGreetingAction implements Action<SendGreetingResult> {

 private String name;

 public SendGreetingAction(final String name) {
  this.name = name;
 }

 public String getName() {
  return name;
 }
}
