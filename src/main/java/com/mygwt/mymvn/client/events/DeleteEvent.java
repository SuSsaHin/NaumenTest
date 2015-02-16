package com.mygwt.mymvn.client.events;

import com.google.gwt.event.shared.GwtEvent;
import com.mygwt.mymvn.shared.PhoneRecord;

public class DeleteEvent extends GwtEvent<DeleteEventHandler>
{
	private static Type<DeleteEventHandler> TYPE = new Type<DeleteEventHandler>();
	private PhoneRecord record;
	
	public DeleteEvent(PhoneRecord record)
	{
		super();
		this.record = record;
	}
	
	public PhoneRecord getRecord()
	{
		return record;
	}
	
	public static Type<DeleteEventHandler> getType() {
        return TYPE;
    }
	
    @Override
    public Type<DeleteEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(DeleteEventHandler handler) {
        handler.onDelete(this);
    }
}
