package com.sathkumara.churro.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ScrollEvent;
import com.google.gwt.event.dom.client.ScrollHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sathkumara.churro.client.handler.JSONHandlerBase;
import com.sathkumara.churro.client.json.Link;
import com.sathkumara.churro.client.json.Listing;
import com.sathkumara.churro.client.widget.Post;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ReddGWT implements EntryPoint {
	
	public static final String BASE_URL = "http://www.reddit.com";

	// http://www.reddit.com/api/info.json?jsonp=foo&url=http://www.reddit.com/buttons
	public static final String API_URL = "http://www.reddit.com/api/";

	// http://www.reddit.com/.json?limit=1&jsonp=alert
	public static final String REG_URL = URL.encode("http://www.reddit.com/.json?limit=100");

	private static final String CALLBACK_ARG = "&jsonp=";
	
	
	RootPanel content = RootPanel.get("content");
	
	
	private static String lastID;
	private static boolean loaded = false;
	
	VerticalPanel feedBody = new VerticalPanel();
	ScrollPanel scroller = new ScrollPanel(feedBody);
	
	int lastScrollPos = 0;


	@Override
	public void onModuleLoad() {
		content.add(scroller);
		scroller.setWidth(Window.getClientWidth()+"px");
		scroller.setHeight(Window.getClientHeight()-scroller.getAbsoluteTop() +"px");
		
		Window.addResizeHandler(new ResizeHandler() {
			@Override public void onResize(ResizeEvent event) {
				scroller.setWidth(event.getWidth()-1 + "px");
				scroller.setHeight(Window.getClientHeight()-scroller.getAbsoluteTop() + "px");
				System.err.println("height: " + event.getHeight() + " width: " + event.getWidth());
			}
		});
		
		scroller.addScrollHandler(new ScrollHandler() {
			@Override public void onScroll(ScrollEvent event) {
				int oldScrollPos = lastScrollPos;
				lastScrollPos = scroller.getVerticalScrollPosition();
				if (oldScrollPos >= lastScrollPos) {
					return;
				}
				int maxScrollTop = scroller.getWidget().getOffsetHeight()
						- scroller.getOffsetHeight();
				
				//System.err.println("last scroll pos: " + lastScrollPos + " max scroll: " + maxScrollTop);
				if (!loaded && lastScrollPos >= maxScrollTop) {
					// We are near the end, so increase the page size.
					loaded = true;
					String url = REG_URL + "&after=" + lastID + CALLBACK_ARG;
					getPosts(url);
				}
			}
		});
		
		
		String url = REG_URL + CALLBACK_ARG;
		getPosts(url);
		
	}
	
	void getPosts(String URL) {
		new JSONHandlerBase<Listing<Link>>(URL) {

			@Override
			public void onComplete(JavaScriptObject result) {
				populate(result);
			}
		};
	}
	
	@SuppressWarnings("unchecked")
	public void populate(JavaScriptObject result) {
		if (result == null) return;
		Listing<Link> listing = (Listing<Link>) result;
		JsArray<Link> data = listing.getData();
		
		//content.clear();
		
		for (int i = 0; i < data.length(); i++) {
			Link l = (Link) data.get(i);
			feedBody.add(new Post(l));
		}
		
		Link last = (Link) data.get(data.length()-1);
		lastID = "t3_" + last.getId();
		loaded = false;
		System.err.println("Last ID was set to " + lastID);
	}
	
	
	
	/*if (result == null) return;
	@SuppressWarnings("unchecked")
	Listing<Link> listing = (Listing<Link>) result;
	
	System.err.println("Kind : " + listing.getKind());
	System.err.println("ModHash : " + listing.getModHash());
	System.err.println("After : " + listing.getAfter());
	System.err.println("Before : " + listing.getBefore());
	
	JsArray<Link> data = listing.getData();
	//System.err.println("Child size: " + data.length());
	
	Link last = (Link) data.get(data.length()-1);
	String lastID = last.getId();*/

	/*System.err.println("Thing");
	System.err.println("ID: " + l.getId());
	System.err.println("Name: " + l.getName());
	System.err.println("Kind: " + l.getKind());
	System.err.println("Data: " + l.getData());
	System.err.println("Link");
	System.err.println("Domain: " + l.getDomain());
	System.err.println("subreddit: " + l.getSubreddit());
	System.err.println("subreddit_id: " + l.getSubredditId());
	System.err.println("clicked: " + l.getClicked());
	System.err.println("Title: " + l.getTitle());
	System.err.println("score: " + l.getScore());
	System.err.println("over_18: " + l.getIsNSFW());
	System.err.println("hidden: " + l.getHidden());
	System.err.println("thumbnail: " + l.getThumbnail());
	System.err.println("edited: " + l.getEdited());
	System.err.println("downs: " + l.getDowns());
	System.err.println("saved: " + l.getSaved());
	System.err.println("is_self: " + l.getIsSelf());
	System.err.println("permalink: " + l.getPermalink());
	System.err.println("Created: " + l.getCreated());
	System.err.println("URL: " + l.getURL());
	System.err.println("Author: " + l.getAuthor());
	System.err.println("created_utc: " + l.getCreatedUTC());
	System.err.println("ups: " + l.getUps());
	System.err.println("num_comments: " + l.getNumComments());
	System.err.println(" //////////////////////////////// ");*/

}
