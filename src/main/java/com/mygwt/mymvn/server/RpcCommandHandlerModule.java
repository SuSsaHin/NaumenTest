package com.mygwt.mymvn.server;

import net.customware.gwt.dispatch.server.guice.ActionHandlerModule;

import com.mygwt.mymvn.client.rpc.AddAction;
import com.mygwt.mymvn.client.rpc.EditAction;
import com.mygwt.mymvn.client.rpc.GetByIdAction;
import com.mygwt.mymvn.client.rpc.DeleteAction;
import com.mygwt.mymvn.client.rpc.SearchAction;
import com.mygwt.mymvn.server.handlers.AddActionHandler;
import com.mygwt.mymvn.server.handlers.EditActionHandler;
import com.mygwt.mymvn.server.handlers.GetByIdActionHandler;
import com.mygwt.mymvn.server.handlers.DeleteActionHandler;
import com.mygwt.mymvn.server.handlers.SearchActionHandler;

public class RpcCommandHandlerModule extends ActionHandlerModule
{
	@Override
	protected void configureHandlers()
	{
		bindHandler(SearchAction.class, SearchActionHandler.class);
		bindHandler(DeleteAction.class, DeleteActionHandler.class);
		bindHandler(GetByIdAction.class, GetByIdActionHandler.class);
		bindHandler(AddAction.class, AddActionHandler.class);
		bindHandler(EditAction.class, EditActionHandler.class);
	}
}