package com.sathkumara.churro.client.json;

import java.util.ArrayList;

import com.google.gwt.core.client.JavaScriptObject;

public class Subreddit extends JavaScriptObject {
	
	/**
	 * number of users active in last 15 minutes
	 */
	int accounts_active;
	
	/**
	 * sidebar text
	 */
	String description;
	
	/**
	 * sidebar text, escaped HTML format
	 */
	String description_html;
	
	/**
	 * human name of the subreddit
	 */
	String display_name;
	
	/**
	 * full URL to the header image, or null
	 */
	String header_img;
	
	
	/**
	 * width and height of the header image, or null
	 */
	ArrayList<?> header_size;
	
	/**
	 * description of header image shown on hover, or null
	 */
	String header_title;
	
	/**
	 * is_nsfw?
	 */
	Boolean over18;
	
	/**
	 * Description shown in subreddit search results?
	 */
	String public_description;
	
	/**
	 * the number of redditors subscribed to this subreddit
	 */
	long subscribers;
	
	/**
	 * title of the main page
	 */
	String title;
	
	/**
	 * The relative URL of the subreddit. Ex: "/r/pics/"
	 */
	String url;
	
}
