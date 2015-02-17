package com.mygwt.mymvn.server.handlers;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

import com.mygwt.mymvn.client.rpc.AddAction;
import com.mygwt.mymvn.client.rpc.AddResult;
import com.mygwt.mymvn.server.logic.PhoneRecordsDAOFactory;

public class AddActionHandler implements
		ActionHandler<AddAction, AddResult>
{
	@Override
	public AddResult execute(AddAction action, ExecutionContext context)
			throws ActionException
	{
		long id = PhoneRecordsDAOFactory.getInstance().get().add(action.getRecord());
		return new AddResult(id);
	}

	@Override
	public Class<AddAction> getActionType()
	{
		return AddAction.class;
	}

	@Override
	public void rollback(AddAction action, AddResult result,
			ExecutionContext context) throws ActionException
	{
	}
}
