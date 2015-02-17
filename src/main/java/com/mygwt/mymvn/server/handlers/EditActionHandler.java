package com.mygwt.mymvn.server.handlers;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

import com.mygwt.mymvn.client.rpc.EditAction;
import com.mygwt.mymvn.client.rpc.EditResult;
import com.mygwt.mymvn.server.logic.PhoneRecordsDAOFactory;

public class EditActionHandler implements
		ActionHandler<EditAction, EditResult>
{
	@Override
	public EditResult execute(EditAction action, ExecutionContext context)
			throws ActionException
	{
		boolean updated = PhoneRecordsDAOFactory.getInstance().get().update(action.getEditedId(), action.getNewRecord());
		return new EditResult(updated);
	}

	@Override
	public Class<EditAction> getActionType()
	{
		return EditAction.class;
	}

	@Override
	public void rollback(EditAction action, EditResult result,
			ExecutionContext context) throws ActionException
	{
	}
}
