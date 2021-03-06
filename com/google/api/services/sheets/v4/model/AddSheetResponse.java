package com.google.api.services.sheets.v4.model;

import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.json.GenericJson;

public final class AddSheetResponse extends GenericJson
{
    @Key
    private SheetProperties properties;
    
    public SheetProperties getProperties() {
        /*SL:48*/return this.properties;
    }
    
    public AddSheetResponse setProperties(final SheetProperties properties) {
        /*SL:56*/this.properties = properties;
        /*SL:57*/return this;
    }
    
    public AddSheetResponse set(final String a1, final Object a2) {
        /*SL:62*/return (AddSheetResponse)super.set(a1, a2);
    }
    
    public AddSheetResponse clone() {
        /*SL:67*/return (AddSheetResponse)super.clone();
    }
}
