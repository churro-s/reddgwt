package com.sathkumara.churro.client.handler;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public abstract class JSONHandlerBase<T extends JavaScriptObject> {

	private JavaScriptObject theData;
	
	
	public JSONHandlerBase(String url) {
		if (url == null) return;
		
		int requestID = (int) (Math.random()*1000);
		getJson(requestID, url, this);
	}
	
	void handleJsonResponse(JavaScriptObject jso) {
		this.theData = jso;
		onComplete(getTheData());
	}

	/**
	 * Cast JavaScriptObject as JsArray of StockData.
	 */
	public final native JsArray<T> asArrayOfStockData(JavaScriptObject jso) /*-{
		return jso;
	}-*/;

	private JavaScriptObject getTheData() {
		return theData;
	}

	public abstract void onComplete(JavaScriptObject result);
	

	@SuppressWarnings("rawtypes")
	public native static void getJson(int requestId, String url, JSONHandlerBase handler) /*-{
		var callback = "callback" + requestId;
		//console.log("callback is: " + callback);
		
		// [1] Create a script element.
		var script = document.createElement("script");
		script.setAttribute("src", url + callback);
		console.log("set URL to : " + url + callback);
		script.setAttribute("type", "text/javascript");

		// [2] Define the callback function on the window object.
		window[callback] = function(jsonObj) {
			// [3]
			//console.log("reached window[callback] = function(jsonObj)");
			handler.@com.sathkumara.churro.client.handler.JSONHandlerBase::handleJsonResponse(Lcom/google/gwt/core/client/JavaScriptObject;)(jsonObj);
			window[callback + "done"] = true;
		};

		// [4] JSON download has 1-second timeout.
		setTimeout( function() {
			//console.log("reached setTimeout function()");
			if (!window[callback + "done"]) {
				handler.@com.sathkumara.churro.client.handler.JSONHandlerBase::handleJsonResponse(Lcom/google/gwt/core/client/JavaScriptObject;)(null);
			}

			// [5] Cleanup. Remove script and callback elements.
			document.body.removeChild(script);
			delete window[callback];
			delete window[callback + "done"];
		}, 2000);

		// [6] Attach the script element to the document body.
		document.body.appendChild(script);
	}-*/;
	
}
