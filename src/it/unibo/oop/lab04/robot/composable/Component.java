package it.unibo.oop.lab04.robot.composable;

public abstract class Component {
	private boolean on;
	private final String componentName;
	private boolean running;
	private ComposableRobot attachedRobot;
	
	public Component(String componentName) {
		this.componentName = componentName;
		this.on = true;
	}
	
	public boolean isOn() {
		return this.on;
	}
	
	public boolean isOff() {
		return !this.on;
	}
	
	public void turnOn() {
		this.on = true;
	}
	
	public void turnOff() {
		this.on = false;
	}
	
	public boolean isRunning() {
		return this.running;
	}
	
	public boolean isAttachedToRobot() {
		return this.attachedRobot != null;
	}
	
	public boolean attachToRobot(ComposableRobot robot) {
		if (!isAttachedToRobot()) {
			this.attachedRobot = robot;
			return true;
		}
		return false;
	}
	
	protected ComposableRobot getAttachedRobot() {
		return this.attachedRobot;
	}
	
	public abstract double getBatteryConsumption();
	protected abstract void run();
	
}
