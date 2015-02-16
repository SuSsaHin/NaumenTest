package com.mygwt.mymvn.server;

import net.customware.gwt.dispatch.server.guice.ActionHandlerModule;

import com.mygwt.mymvn.client.rpc.ContainsAction;
import com.mygwt.mymvn.client.rpc.DeleteAction;
import com.mygwt.mymvn.client.rpc.SearchAction;

public class RpcCommandHandlerModule extends ActionHandlerModule
{
	@Override
	protected void configureHandlers()
	{
		bindHandler(SearchAction.class, SearchActionHandler.class);
		bindHandler(DeleteAction.class, DeleteActionHandler.class);
		bindHandler(ContainsAction.class, ContainsActionHandler.class);
		// . . .
	}
}