package it.unibo.oop.lab04.robot.composable;

public class AtomicBattery extends Component {
	private static final double BATTERY_CONSUMPTION = 1.2;

	public AtomicBattery(String componentName) {
		super(componentName);
	}
	
	public double getBatteryConsumption() {
		return BATTERY_CONSUMPTION;
	}

	protected void run() {
		if (this.isAttachedToRobot() && this.getAttachedRobot().getBatteryLevel() < 50) {
			this.getAttachedRobot().recharge();
		}
	}

}
