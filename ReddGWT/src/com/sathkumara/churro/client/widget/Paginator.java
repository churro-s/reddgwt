package com.sathkumara.churro.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Paginator extends Composite {

	private static PaginatorUiBinder uiBinder = GWT.create(PaginatorUiBinder.class);
	interface PaginatorUiBinder extends UiBinder<Widget, Paginator> { }
	
	@UiField AnchorElement prev, next;
	
	public Paginator() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	void setNextURL(String nextURL) {
		next.setHref(nextURL);
	}
	
	void setPrevURL(String prevURL) {
		prev.setHref(prevURL);
	}
}
