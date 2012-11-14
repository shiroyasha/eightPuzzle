/**
 * 
 */
package dmi.vi1.search.framework;

/**
 * @author bdimic@uns.ac.rs
 *
 */
public class Problem {
	
	protected Object initialState;
	
	protected ActionsFunction actionsFunction;
	
	protected ResultFunction resultFunction;
	
	protected GoalTest goalTest;
	
	protected StepCostFunction stepCostFunction;
	
	
	public Problem(){
		
	}
	
	
	

	/**
	 * @param initialState
	 * @param actionsFunction
	 * @param resultFunction
	 * @param goalTest
	 */
	public Problem(Object initialState, ActionsFunction actionsFunction,
			ResultFunction resultFunction, GoalTest goalTest) {
		super();
		this.initialState = initialState;
		this.actionsFunction = actionsFunction;
		this.resultFunction = resultFunction;
		this.goalTest = goalTest;
	}




	/**
	 * @param initialState
	 * @param actionsFunction
	 * @param resultFunction
	 * @param goalTest
	 * @param stepCostFunction
	 */
	public Problem(Object initialState, ActionsFunction actionsFunction,
			ResultFunction resultFunction, GoalTest goalTest,
			StepCostFunction stepCostFunction) {
		super();
		this.initialState = initialState;
		this.actionsFunction = actionsFunction;
		this.resultFunction = resultFunction;
		this.goalTest = goalTest;
		this.stepCostFunction = stepCostFunction;
	}
	
	

	/**
	 * @return the initialState
	 */
	public Object getInitialState() {
		return initialState;
	}

	/**
	 * @param initialState the initialState to set
	 */
	public void setInitialState(Object initialState) {
		this.initialState = initialState;
	}

	/**
	 * @return the actionsFunction
	 */
	public ActionsFunction getActionsFunction() {
		return actionsFunction;
	}

	/**
	 * @param actionsFunction the actionsFunction to set
	 */
	public void setActionsFunction(ActionsFunction actionsFunction) {
		this.actionsFunction = actionsFunction;
	}

	/**
	 * @return the resultFunction
	 */
	public ResultFunction getResultFunction() {
		return resultFunction;
	}

	/**
	 * @param resultFunction the resultFunction to set
	 */
	public void setResultFunction(ResultFunction resultFunction) {
		this.resultFunction = resultFunction;
	}

	/**
	 * @return the goalTest
	 */
	public GoalTest getGoalTest() {
		return goalTest;
	}

	/**
	 * @param goalTest the goalTest to set
	 */
	public void setGoalTest(GoalTest goalTest) {
		this.goalTest = goalTest;
	}

	/**
	 * @return the stepCostFunction
	 */
	public StepCostFunction getStepCostFunction() {
		return stepCostFunction;
	}

	/**
	 * @param stepCostFunction the stepCostFunction to set
	 */
	public void setStepCostFunction(StepCostFunction stepCostFunction) {
		this.stepCostFunction = stepCostFunction;
	}
	
	
	
	
	
	
	

}
