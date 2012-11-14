/**
 * 
 */
package dmi.vi1.search.examples.iksoks;

import dmi.vi1.search.datastructure.XYLocation;
import dmi.vi1.search.framework.Action;

/**
 * @author Bojana Dimic Surla <bdimic@uns.ac.rs>
 *
 */
public class IksOksAction implements Action {

	private XYLocation xyLocation ;
	private String mark;
	
	
	public IksOksAction(XYLocation loc, String mark) {
		this.xyLocation = loc;
		this.mark = mark;
		
	}
	
	@Override
	public boolean isNoOpAction() {	
		return false;
	}

	/**
	 * @return the xyLocation
	 */
	public XYLocation getXyLocation() {
		return xyLocation;
	}

	/**
	 * @param xyLocation the xyLocation to set
	 */
	public void setXyLocation(XYLocation xyLocation) {
		this.xyLocation = xyLocation;
	}

	/**
	 * @return the mark
	 */
	public String getMark() {
		return mark;
	}

	/**
	 * @param mark the mark to set
	 */
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	
	@Override
	public String toString() {	
		return "Put "+mark+" to "+xyLocation.getPositionX()+","+xyLocation.getPositionY();
	}

}
