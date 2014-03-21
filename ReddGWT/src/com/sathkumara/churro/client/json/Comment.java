package com.sathkumara.churro.client.json;

import com.google.gwt.core.client.JavaScriptObject;

public class Comment extends JavaScriptObject {
	
	/**
	 * who approved this comment. null if nobody or you are 
	 * not a mod
	 */
	String approved_by;
	
	/**
	 * the account name of the poster
	 */
	String author;
	
	/**
	 * the CSS class of the author's flair. subreddit specific
	 */
	String author_flair_css_class;
	
	/**
	 * the text of the author's flair. subreddit specific
	 */
	String author_flair_text;
	
	/**
	 * who removed this comment. null if nobody or you are not 
	 * a mod
	 */
	String banned_by;
	
	/**
	 * the raw text. this is the unformatted text which 
	 * includes the raw markup characters such as ** for bold. 
	 * <, >, and & are escaped.
	 */
	String body;
	
	/**
	 * the formatted HTML text as displayed on reddit. For 
	 * example, text that is emphasised by * will now have &lt;em&gt;
	 * tags wrapping it. Additionally, bullets and numbered lists
	 *  will now be in html list format. NOTE: The html string 
	 * will be escaped. You must unescape to get the raw html.
	 */
	String body_html;
	
	/**
	 * false if not edited, edit date in UTC epoch-seconds otherwise
	 */
	Object edited;
	
	/**
	 * the number of times this comment received reddit gold
	 */
	int gilded;
	
	/**
	 * ID of the link this comment is in
	 */
	String link_id;
	
	/**
	 * only present at /r/subreddit/comments/.json, contains what it
	 *  says
	 */
	String link_title;
	
	/**
	 * how many times this comment has been reported, null if not a
	 *  mod
	 */
	int num_reports;
	
	/**
	 * ID of the thing this comment is a reply to, either the link 
	 * or a comment in it
	 */
	String parent_id;
	
	/**
	 * subreddit of thing excluding the /r/ prefix. "pics"
	 */
	String subreddit;
	
	/**
	 * the id of the subreddit which is the thing is located in
	 */
	String subreddit_id;
	
	/**
	 * to allow determining whether they have been distinguished 
	 * by moderators/admins. null = not distinguished. moderator = 
	 * the green [M]. admin = the red [A]. special = various other 
	 * special distinguishes http://bit.ly/ZYI47B
	 */
	String distinguished;

}
