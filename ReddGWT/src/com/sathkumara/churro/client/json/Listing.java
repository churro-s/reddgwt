package com.sathkumara.churro.client.json;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * Used to paginate content that is too long to display 
 * in one go. Add the query argument before or after 
 * with the value given to get the previous or next 
 * page. This is usually used in conjunction with a 
 * count argument. Exception: Unlike the other classes 
 * documented on this page, Listing is not a thing 
 * subclass, as it inherits directly from the Python 
 * base class, Object. Although it does have data and 
 * kind as parameters, it does not have id and name. 
 * A listing's kind will always be Listing and its data 
 * will be a List of things.
 * 
 * @author Churro
 */
public class Listing<X extends Thing> extends JavaScriptObject {
	
	protected Listing() { }
	
	public final native String getKind() /*-{ return this.kind; }-*/;
	public final native String getModHash() /*-{ return this.data.modhash; }-*/;
	public final native JsArray<X> getData() /*-{ return this.data.children; }-*/;
	public final native String getAfter() /*-{ return this.data.after; }-*/;
	public final native String getBefore() /*-{ return this.data.before; }-*/;
}
