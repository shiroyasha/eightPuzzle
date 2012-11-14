/**
 * 
 */
package dmi.vi1.search.examples.romania;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dmi.vi1.search.framework.Action;
import dmi.vi1.search.framework.GraphSearch;
import dmi.vi1.search.framework.Problem;
import dmi.vi1.search.framework.TreeSearch;
import dmi.vi1.search.informed.AStarSearch;
import dmi.vi1.search.informed.GreedyBestFirstEvaluationFunction;
import dmi.vi1.search.informed.GreedyBestFirstSearch;
import dmi.vi1.search.uninformed.BreadthFirstSearch;
import dmi.vi1.search.uninformed.DepthFirstSearch;
import dmi.vi1.search.uninformed.UniformCostSearch;

/**
 * @author bdimic@uns.ac.rs
 *
 */
public class RomanianMap {
	
	private static List<RomanianTwoCityConnection> connected = new ArrayList<RomanianTwoCityConnection>();
	
	public static String startCity = "Arad";
	public static String goalCity = "Bucharest";
	public static List<Object[]> connectedCities=  new ArrayList<Object[]>();
	public static HashMap<String, Integer> straightLineDistanceToBucharest = new HashMap<String, Integer>(); 
	
	
	
	public static void initMap(){	
		connected.add(new RomanianTwoCityConnection("Arad", "Zerind", 75));		
		connected.add(new RomanianTwoCityConnection("Arad", "Sibiu", 140));		
		connected.add(new RomanianTwoCityConnection("Arad", "Timisoara", 118));		
		connected.add(new RomanianTwoCityConnection("Zerind", "Oradea", 71));
		connected.add(new RomanianTwoCityConnection("Oradea", "Sibiu", 151));
		connected.add(new RomanianTwoCityConnection("Sibiu", "Fagaras", 99));		
		connected.add(new RomanianTwoCityConnection("Sibiu", "Rimnicu Vilcea", 80));
		connected.add(new RomanianTwoCityConnection("Timisoara", "Lugoj", 111));		
		connected.add(new RomanianTwoCityConnection("Lugoj", "Mehadia", 70));
		connected.add(new RomanianTwoCityConnection("Mehadia", "Drobeta", 75));
		connected.add(new RomanianTwoCityConnection("Drobeta", "Craiova", 120));
		connected.add(new RomanianTwoCityConnection("Rimnicu Vilcea", "Craiova", 146));
		connected.add(new RomanianTwoCityConnection("Rimnicu Vilcea", "Pitesti", 97));
		connected.add(new RomanianTwoCityConnection("Pitesti", "Bucharest", 101));
		connected.add(new RomanianTwoCityConnection("Fagaras", "Bucharest", 211));
		connected.add(new RomanianTwoCityConnection("Bucharest", "Glurgin", 90));
		connected.add(new RomanianTwoCityConnection("Bucharest", "Urziceni", 85));
		connected.add(new RomanianTwoCityConnection("Urziceni", "Hirsova", 98));
		connected.add(new RomanianTwoCityConnection("Hirsova", "Eforie", 86));
		connected.add(new RomanianTwoCityConnection("Urziceni", "Vaslui", 142));
		connected.add(new RomanianTwoCityConnection("Vaslui", "Iasi", 92));
		connected.add(new RomanianTwoCityConnection("Iasi", "Neamt", 87));
		
		straightLineDistanceToBucharest.put("Arad",366);
		straightLineDistanceToBucharest.put("Bucharest", 0);
		straightLineDistanceToBucharest.put("Craiova", 160);
		straightLineDistanceToBucharest.put("Drobeta", 242);
		straightLineDistanceToBucharest.put("Eforie", 161);
		straightLineDistanceToBucharest.put("Fagaras", 176);
		straightLineDistanceToBucharest.put("Giurgiu", 77);
		straightLineDistanceToBucharest.put("Hirsova", 151);
		straightLineDistanceToBucharest.put("Iasi", 226);
		straightLineDistanceToBucharest.put("Lugoj", 244);
		straightLineDistanceToBucharest.put("Mehadia", 241);
		straightLineDistanceToBucharest.put("Neamt", 234);
		straightLineDistanceToBucharest.put("Oradea", 380);
		straightLineDistanceToBucharest.put("Pitesti", 100);
		straightLineDistanceToBucharest.put("Rimnicu Vilcea", 193);
		straightLineDistanceToBucharest.put("Sibiu", 253);
		straightLineDistanceToBucharest.put("Timisoara", 329);
		straightLineDistanceToBucharest.put("Urziceni", 80);
		straightLineDistanceToBucharest.put("Visliu", 199);
		straightLineDistanceToBucharest.put("Zerind", 374);
		
		
		
		
	}
	
	
	public static List<String> getConnected(String townName){
		List<String> connectedList = new ArrayList<>();
		for(RomanianTwoCityConnection rtc:connected){
			if(rtc.getCity1().equals(townName)){
				connectedList.add(rtc.getCity2());				
			}
			if(rtc.getCity2().equals(townName)){
				connectedList.add(rtc.getCity1());
			}
		}
		return connectedList;
	}
	
	public static List<Action> getActionsInCity(String cityName){
		List<Action> retVal = new ArrayList<Action>();
		for(RomanianTwoCityConnection rtc:connected){
			if(rtc.getCity1().equals(cityName))
				retVal.add(new GoToCityAction(rtc.getCity2()));
			if(rtc.getCity2().equals(cityName))
				retVal.add(new GoToCityAction(rtc.getCity1()));
			
		}
		return retVal;
	}
	
	public static String getDestinantion(String cityName, GoToCityAction action){		
		return action.getDestination();
	}
	
	public static double getDistance(String city1, String city2){
		for(RomanianTwoCityConnection rtc:connected){
			if(rtc.getCity1().equals(city1) && rtc.getCity2().equals(city2))
				return rtc.getDistance();
			if(rtc.getCity1().equals(city2) && rtc.getCity2().equals(city1))
				return rtc.getDistance();
		}
		return 0;
	}

	public static int getStrightLineDistanceToBucharest(String cityName){		
		return straightLineDistanceToBucharest.get(cityName);
	}
	
	public static void main(String[] args){
		
		System.out.println("Inicijalizacija...");
		initMap();
		RomanianMapActionsFunctions actionsFunction = new RomanianMapActionsFunctions();
		RomanianMapResultFunction resultFunction = new RomanianMapResultFunction();
		RomanianMapGoalTest goalTest = new RomanianMapGoalTest();
		RomanianMapStepCostFunction stepCostFunction =  new RomanianMapStepCostFunction();
		Problem romanianMapProblem  = new Problem("Arad", actionsFunction, resultFunction, goalTest, stepCostFunction);
		BreadthFirstSearch bfSearch = new BreadthFirstSearch();
		DepthFirstSearch dfSearch = new DepthFirstSearch(new GraphSearch());
		UniformCostSearch ucSearch = new UniformCostSearch();
		GreedyBestFirstSearch gbf = new GreedyBestFirstSearch(new TreeSearch(), new RomanianMapHeuristicFunction());
		AStarSearch astars = new AStarSearch(new TreeSearch(), new RomanianMapHeuristicFunction()); 
		try {
			System.out.println("Pretraga...");
			//List<Action> actions = bfSearch.search(romanianMapProblem);
			//List<Action> actions = dfSearch.search(romanianMapProblem);
			//List<Action> actions = ucSearch.search(romanianMapProblem);
			List<Action> actions = astars.search(romanianMapProblem);			
			System.out.println("Rezultat...");
			for(Action a:actions){
				System.out.println(a.toString());
			}
		} catch (Exception e) {		
			e.printStackTrace();
		}		
	}
	
	

}
