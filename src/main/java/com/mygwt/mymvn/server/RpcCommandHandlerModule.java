package com.mygwt.mymvn.server;

import com.mygwt.mymvn.client.rpc.SendGreetingAction;

import net.customware.gwt.dispatch.server.guice.ActionHandlerModule;

public class RpcCommandHandlerModule extends ActionHandlerModule {
  @Override
  protected void configureHandlers() {
    bindHandler(SendGreetingAction.class, SendGreetingHandler.class);
    // . . .
  }
}