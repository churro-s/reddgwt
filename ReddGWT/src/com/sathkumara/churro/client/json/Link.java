package com.sathkumara.churro.client.json;


public class Link extends Thing {
	
	protected Link() { }
	
	//Following method is stolen from Thing because the structure is different
	public final native String getId() /*-{ return this.data.id; }-*/;
	
	public final native String getDomain() /*-{ return this.data.domain; }-*/;
	public final native String getBannedBy() /*-{ return this.data.banned_by; }-*/;
	public final native Object getMediaEmbed() /*-{ return this.data.media_embed; }-*/;
	public final native String getSelfTextHtml() /*-{ return this.data.selftext_html; }-*/;
	public final native String getSelfText() /*-{ return this.data.selftext; }-*/;
	
	public final native String getLikes() /*-{ return this.data.likes; }-*/;
	public final native String getLinkFlairText() /*-{ return this.data.link_flair_text; }-*/;
	public final native boolean getClicked() /*-{ return this.data.clicked; }-*/;
	public final native String getTitle() /*-{ return this.data.title; }-*/;
	public final native int getScore() /*-{ return this.data.score; }-*/;
	public final native String getApprovedBy() /*-{ return this.data.approved_by; }-*/;
	
	public final native boolean getIsNSFW() /*-{ return this.data.over_18; }-*/;
	public final native boolean getHidden() /*-{ return this.data.hidden; }-*/;
	public final native boolean getEdited() /*-{ return this.data.edited ? true : false; }-*/;
	
	public final native String getThumbnail() /*-{ return this.data.thumbnail; }-*/;
	public final native String getSubredditId() /*-{ return this.data.subreddit_id; }-*/;
	public final native String getSubreddit() /*-{ return this.data.subreddit; }-*/;
	
	public final native String getLinkFlairCSSClass() /*-{ return this.data.link_flair_css_class; }-*/;
	public final native int getDowns() /*-{ return this.data.downs; }-*/;
	
	public final native boolean getSaved() /*-{ return this.data.saved; }-*/;
	public final native boolean getIsSelf() /*-{ return this.data.is_self; }-*/;
	
	public final native String getPermalink() /*-{ return this.data.permalink; }-*/;
	
	public final native int getCreated() /*-{ return this.data.created; }-*/;
	public final native String getURL() /*-{ return this.data.url; }-*/;
	
	public final native String getAuthorFlairText() /*-{ return this.data.author_flair_text; }-*/;
	public final native String getAuthor() /*-{ return this.data.author; }-*/;
	public final native int getCreatedUTC() /*-{ return this.data.created_utc; }-*/;
	public final native int getUps() /*-{ return this.data.ups; }-*/;
	public final native int getNumComments() /*-{ return this.data.num_comments; }-*/;
	public final native int getNumReports() /*-{ return this.data.num_reports; }-*/;

	public final native String getDistinguished() /*-{ return this.data.distinguished; }-*/;

	public final native Boolean getLiked() /*-{ return this.data.likes; }-*/;
}

/*

*//**
 * the account name of the poster. null if this is a promotional link
 *//*
String author;

*//**
 * the CSS class of the author's flair. subreddit specific
 *//*
String author_flair_css_class;

*//**
 * the text of the author's flair. subreddit specific
 *//*
String author_flair_text;

*//**
 * probably always returns false
 *//*
Boolean clicked;

*//**
 * the domain of this link. Self posts will be self.reddit.com 
 * while other examples include en.wikipedia.org and s3.amazon.com
 *//*
String domain;

*//**
 * true if the post is hidden by the logged in user. false if not 
 * logged in or not hidden.
 *//*
Boolean hidden;

*//**
 * true if this link is a selfpost
 *//*
Boolean is_self;

*//**
 * the CSS class of the link's flair.
 *//*
String link_flair_css_class;

*//**
 * the text of the link's flair.
 *//*
String link_flair_text;

*//**
 * Used for streaming video. Detailed information about the video 
 * and it's origins are placed here
 *//*
Object media;

*//**
 * Used for streaming video. Technical embed specific information 
 * is found here.
 *//*
Object media_embed;

*//**
 * the number of comments that belong to this link. includes 
 * removed comments.
 *//*
int num_comments;

*//**
 * true if the post is tagged as NSFW. False if otherwise
 *//*
Boolean over_18;

*//**
 * relative url of the permanent link for this link
 *//*
String permalink;

*//**
 * true if this post is saved by the logged in user
 *//*
Boolean saved;

*//**
 * the net-score of the link. note: A submission's score is simply 
 * the number of upvotes minus the number of downvotes. If five 
 * users like the submission and three users don't it will have a 
 * score of 2. Please note that the vote numbers are not "real" 
 * numbers, they have been "fuzzed" to prevent spam bots etc. So 
 * taking the above example, if five users upvoted the submission, 
 * and three users downvote it, the upvote/downvote numbers may say 
 * 23 upvotes and 21 downvotes, or 12 upvotes, and 10 downvotes. 
 * The points score is correct, but the vote totals are "fuzzed".
 *//*
int score;

*//**
 * the raw text. this is the unformatted text which includes the 
 * raw markup characters such as ** for bold. <, >, and & are 
 * escaped. Empty if not present.
 *//*
String selftext;

*//**
 * the formatted escaped html text. this is the html formatted 
 * version of the marked up text. Items that are boldened by ** 
 * or *** will now have <em> or *** tags on them. Additionally, 
 * bullets and numbered lists will now be in html list format. 
 * NOTE: The html string will be escaped. You must unescape to 
 * get the raw html. Null if not present.
 *//*
String selftext_html;

*//**
 * subreddit of thing excluding the /r/ prefix. "pics"
 *//*
String subreddit;

*//**
 * the id of the subreddit which is the thing is located in
 *//*
String subreddit_id;

*//**
 * full url to the thumbnail for this link; "self" if this is 
 * a self post
 *//*
String thumbnail;

*//**
 * the title of the link. may contain newlines for some reason
 *//*
String title;

*//**
 * the link of this post. the permalink if this is a self-post
 *//*
String url;

*//**
 * Indicates if link has been edited. Will be the edit timestamp 
 * if the link has been edited and return false otherwise. 
 * https://github.com/reddit/reddit/issues/581
 *//*
long edited;

*//**
 * to allow determining whether they have been distinguished by 
 * moderators/admins. null = not distinguished. moderator = the 
 * green [M]. admin = the red [A]. special = various other special 
 * distinguishes http://bit.ly/ZYI47B
 *//*
String distinguished;


@Override
public long getCreated() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public long getCreated_utc() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int getUps() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int getDowns() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public Boolean getLiked() {
	// TODO Auto-generated method stub
	return null;
}*/

