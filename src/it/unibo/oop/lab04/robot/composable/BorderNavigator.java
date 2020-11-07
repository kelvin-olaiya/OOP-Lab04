package it.unibo.oop.lab04.robot.composable;

public class BorderNavigator extends Component {
	private static final double BATTERY_CONSUMPTION = 2.5;

	public BorderNavigator(String componentName) {
		super(componentName);
	}

	public double getBatteryConsumption() {
		return BATTERY_CONSUMPTION;
	}

	protected void run() {
		if (this.isAttachedToRobot()) {
			while(this.getAttachedRobot().moveUp());
			while(this.getAttachedRobot().moveRight());
			while(this.getAttachedRobot().moveDown());
			while(this.getAttachedRobot().moveLeft());
		}
	}

}
