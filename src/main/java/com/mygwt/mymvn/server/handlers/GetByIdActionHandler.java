package com.mygwt.mymvn.server.handlers;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

import com.mygwt.mymvn.client.rpc.GetByIdAction;
import com.mygwt.mymvn.client.rpc.GetByIdResult;
import com.mygwt.mymvn.server.logic.PhoneRecordsDAOFactory;
import com.mygwt.mymvn.shared.PhoneRecord;

public class GetByIdActionHandler implements ActionHandler<GetByIdAction, GetByIdResult>
{
	@Override
	public GetByIdResult execute(GetByIdAction action, ExecutionContext context)
			throws ActionException
	{
		PhoneRecord geted = PhoneRecordsDAOFactory.getInstance().get().get(action.getId());
		return new GetByIdResult(geted);
	}

	@Override
	public Class<GetByIdAction> getActionType()
	{
		return GetByIdAction.class;
	}

	@Override
	public void rollback(GetByIdAction action, GetByIdResult result,
			ExecutionContext context) throws ActionException
	{
	}
}