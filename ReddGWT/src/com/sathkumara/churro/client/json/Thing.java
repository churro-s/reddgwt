package com.sathkumara.churro.client.json;

import com.google.gwt.core.client.JavaScriptObject;


/**
 * All things have these attributes. 
 * Exception: Listing things have neither name nor 
 * id because they are indefinite objects. That 
 * is, they are system generated, not user 
 * submitted, and are subject to change quickly 
 * and expire.
 * 
 * @author Churro
 */
public class Thing extends JavaScriptObject {
	
	protected Thing() { }
	

	
	public final native String getName() /*-{ return this.name; }-*/;
	public final native String getKind() /*-{ return this.kind; }-*/;
	public final native Object getData() /*-{ return this.data; }-*/;
	
}
