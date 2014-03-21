package com.sathkumara.churro.client.json;

/**
 * All things that implement created have these 
 * attributes.
 * 
 * @author Churro
 */
public interface Created {
	
	/**
	 * the time of creation in local epoch-
	 * second format. ex: 1331042771.0
	 * @return created
	 */
	Long getCreated();
	
	/**
	 * the time of creation in UTC epoch-second 
	 * format. Note that neither of these ever 
	 * have a non-zero fraction.
	 * @return created_utc
	 */
	Long getCreatedUTC();
	
}
