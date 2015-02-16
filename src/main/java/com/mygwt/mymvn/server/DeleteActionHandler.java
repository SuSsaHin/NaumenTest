package com.mygwt.mymvn.server;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

import com.mygwt.mymvn.client.rpc.DeleteAction;
import com.mygwt.mymvn.client.rpc.DeleteResult;
import com.mygwt.mymvn.server.logic.TestRepository;

public class DeleteActionHandler implements
		ActionHandler<DeleteAction, DeleteResult>
{

	public DeleteResult execute(DeleteAction action, ExecutionContext context)
			throws ActionException
	{
		TestRepository.getInstance().delete(action.getDeleted());
		return new DeleteResult();
	}

	public Class<DeleteAction> getActionType()
	{
		return DeleteAction.class;
	}

	public void rollback(DeleteAction action, DeleteResult result,
			ExecutionContext context) throws ActionException
	{
	}
}
