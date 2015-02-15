package com.mygwt.mymvn.server;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

import com.mygwt.mymvn.client.rpc.SendGreetingAction;
import com.mygwt.mymvn.client.rpc.SendGreetingResult;

public class SendGreetingHandler implements ActionHandler<SendGreetingAction, SendGreetingResult> {
	
//@Override
  public SendGreetingResult execute(SendGreetingAction action, ExecutionContext context) 
		  throws ActionException {
    return new SendGreetingResult("You are entered: " + action.getName());
  }

//@Override
  public Class<SendGreetingAction> getActionType() {
    return SendGreetingAction.class;
  }
  
//  @Override
  public void rollback(SendGreetingAction action, SendGreetingResult result,
    ExecutionContext context) throws ActionException {  }
}