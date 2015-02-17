package com.mygwt.mymvn.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class DeleteEvent extends GwtEvent<DeleteEventHandler>
{
	private static Type<DeleteEventHandler> TYPE = new Type<DeleteEventHandler>();
	private long id;
	
	public DeleteEvent(long id)
	{
		super();
		this.id = id;
	}
	
	public long getRecordId()
	{
		return id;
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
