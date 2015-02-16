package com.mygwt.mymvn.server;

import net.customware.gwt.dispatch.server.ActionHandler;
import net.customware.gwt.dispatch.server.ExecutionContext;
import net.customware.gwt.dispatch.shared.ActionException;

import com.mygwt.mymvn.client.rpc.ContainsAction;
import com.mygwt.mymvn.client.rpc.ContainsResult;
import com.mygwt.mymvn.server.logic.TestRepository;

public class ContainsActionHandler implements ActionHandler<ContainsAction, ContainsResult>
{

	public ContainsResult execute(ContainsAction action, ExecutionContext context)
			throws ActionException
	{
		boolean contains = TestRepository.getInstance().contains(action.getRecord());
		return new ContainsResult(contains);
	}

	public Class<ContainsAction> getActionType()
	{
		return ContainsAction.class;
	}

	public void rollback(ContainsAction action, ContainsResult result,
			ExecutionContext context) throws ActionException
	{
	}
}