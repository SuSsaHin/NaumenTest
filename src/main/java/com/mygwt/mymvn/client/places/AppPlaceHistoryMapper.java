package com.mygwt.mymvn.client.places;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.mygwt.mymvn.client.places.RecordCardPlace;
import com.mygwt.mymvn.client.places.RecordsPlace;

@WithTokenizers({RecordsPlace.Tokenizer.class, RecordCardPlace.Tokenizer.class, RecordEditPlace.Tokenizer.class, RecordAddPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper
{
}
