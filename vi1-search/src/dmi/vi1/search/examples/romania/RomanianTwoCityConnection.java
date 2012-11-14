/**
 * 
 */
package dmi.vi1.search.examples.romania;

import dmi.vi1.search.framework.Action;

/**
 * @author bdimic@uns.ac.rs
 *
 */
public class RomanianTwoCityConnection{
	
	

	private String city1;
	private String city2;
	private int distance;
	
	
	/**
	 * @param city1
	 * @param city2
	 */
	public RomanianTwoCityConnection(String city1, String city2) {
		super();
		this.city1 = city1;
		this.city2 = city2;
	}
	
	
	/**
	 * @param city1
	 * @param city2
	 * @param distance
	 */
	public RomanianTwoCityConnection(String city1, String city2, int distance) {
		super();
		this.city1 = city1;
		this.city2 = city2;
		this.distance = distance;
	}

	/**
	 * @return the city1
	 */
	public String getCity1() {
		return city1;
	}


	/**
	 * @param city1 the city1 to set
	 */
	public void setCity1(String city1) {
		this.city1 = city1;
	}


	/**
	 * @return the city2
	 */
	public String getCity2() {
		return city2;
	}


	/**
	 * @param city2 the city2 to set
	 */
	public void setCity2(String city2) {
		this.city2 = city2;
	}


	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}


	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public boolean isCityIncluded(String cityName){
		return getCity1().equals(cityName) || getCity2().equals(cityName);
	}
	
	
	
	

}
