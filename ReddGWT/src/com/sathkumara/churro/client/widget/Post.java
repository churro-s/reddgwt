package com.sathkumara.churro.client.widget;


import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.CalendarUtil;
import com.sathkumara.churro.client.ReddGWT;
import com.sathkumara.churro.client.json.Link;

public class Post extends Composite {

	private static PostUiBinder uiBinder = GWT.create(PostUiBinder.class);
	interface PostUiBinder extends UiBinder<Widget, Post> { }
	
	
	@UiField AnchorElement thumbnailAnchor, authorLink;
	@UiField Image thumbnail;
	@UiField HeadingElement title;
	
	@UiField SpanElement domain, subreddit, author, score, ups, downs, duration;
	

	public Post(Link l) {
		initWidget(uiBinder.createAndBindUi(this));
		
		final String theURL = ReddGWT.BASE_URL + l.getPermalink();
		
		int created = l.getCreatedUTC();
		long createdLong = Integer.valueOf(created).longValue();
		Date createdDate = new Date(createdLong);
		int days = CalendarUtil.getDaysBetween(createdDate, new Date());
		duration.setInnerText(days + " days ago");
		
		thumbnailAnchor.setHref(theURL);
		
		String authorURL = ReddGWT.BASE_URL + "/u/" + l.getAuthor();
		authorLink.setHref(authorURL);
		
		thumbnail.setUrl(l.getThumbnail());
		
		title.setInnerText(l.getTitle());
		
		domain.setInnerText(l.getDomain());
		subreddit.setInnerText(l.getSubreddit());
		author.setInnerText(l.getAuthor());
		score.setInnerText(l.getScore() + "");
		ups.setInnerText(l.getUps() + "");
		downs.setInnerText(l.getDowns() + "");
		
		
		
		this.addDomHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				Window.Location.assign(theURL);
				//Window.Location.assign(theURL);
			}
		}, ClickEvent.getType());
	}

}
