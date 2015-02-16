package com.mygwt.mymvn.client;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({RecordsPlace.Tokenizer.class, RecordCardPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper
{
}
