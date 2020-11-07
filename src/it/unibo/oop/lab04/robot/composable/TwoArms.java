package it.unibo.oop.lab04.robot.composable;

public class TwoArms extends Component {
	private static final double BATTERY_CONSUMPTION = 3;

	public TwoArms(String componentName) {
		super(componentName);
	}

	public double getBatteryConsumption() {
		return BATTERY_CONSUMPTION;
	}

	protected void run() {
		
	}

}
