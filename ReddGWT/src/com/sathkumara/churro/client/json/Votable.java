package com.sathkumara.churro.client.json;

/**
 * All things that implement votable have these attributes:
 * 
 * @author Churro
 */
public interface Votable {

	/**
	 * int ups; the number of upvotes. (includes own)
	 * @return ups
	 */
	Integer getUps();
	
	/**
	 * int downs; the number of downvote. (includes own)
	 * @return downs
	 */
	Integer getDowns();
	
	/**
	 * true if thing is liked by the user, false if 
	 * thing is disliked, null if the user has not 
	 * voted or you are not logged in. Certain 
	 * languages such as Java may need to use a 
	 * boolean wrapper that supports null assignment.
	 * @return likes
	 */
	Boolean getLiked();
}
