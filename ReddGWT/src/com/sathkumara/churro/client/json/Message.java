package com.sathkumara.churro.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class Message extends JavaScriptObject {
	
	String author;
	
	/**
	 * the message itself
	 */
	String body;
	
	/**
	 * the message itself with html formatting
	 */
	String body_html;
	
	/**
	 * does not seem to return null but an empty string instead.
	 */
	String context;
	
	/**
	 * either null or the first message's ID represented as 
	 * base 10 (wtf)
	 */
	Message first_message;
	
	/**
	 * ex: "t4_8xwlg"
	 */
	String name;
	
	/**
	 * unread? not sure
	 */
	Boolean isNew;
	
	/**
	 * null if no parent is attached
	 */
	String parent_id;
	
	/**
	 * Again, an empty string if there are no replies.
	 */
	String replies;
	
	/**
	 * subject of message
	 */
	String subject;
	
	/**
	 * null if not a comment.
	 */
	String subreddit;
	
	Boolean was_comment;
	
}
