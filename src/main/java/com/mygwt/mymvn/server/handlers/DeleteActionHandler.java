package com.mygwt.mymvn.server.handlers;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

import com.mygwt.mymvn.client.rpc.DeleteAction;
import com.mygwt.mymvn.client.rpc.DeleteResult;
import com.mygwt.mymvn.server.logic.PhoneRecordsDAOFactory;

public class DeleteActionHandler implements
		ActionHandler<DeleteAction, DeleteResult>
{
	@Override
	public DeleteResult execute(DeleteAction action, ExecutionContext context)
			throws ActionException
	{
		PhoneRecordsDAOFactory.getInstance().get().delete(action.getDeletedId());
		return new DeleteResult();
	}

	@Override
	public Class<DeleteAction> getActionType()
	{
		return DeleteAction.class;
	}

	@Override
	public void rollback(DeleteAction action, DeleteResult result,
			ExecutionContext context) throws ActionException
	{
	}
}
