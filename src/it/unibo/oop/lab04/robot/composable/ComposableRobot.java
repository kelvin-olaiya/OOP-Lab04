package it.unibo.oop.lab04.robot.composable;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class ComposableRobot extends BaseRobot {
	private static final int MAX_COMPONENTS = 10;
	private Component[] components;
	private int componentCount;
	
	public ComposableRobot(String robotName) {
		super(robotName);
		components = new Component[MAX_COMPONENTS];
		componentCount = 0;
	}
	
	public boolean attachComponent(Component component) {
		if (component.attachToRobot(this)) {
			this.components[componentCount] = component;
			this.componentCount++;
			return true;
		}
		return false;
	}
	
	public void runAllActiveComponents() {
		
		for (Component c : components) {
			if (c != null && this.isBatteryEnough(c.getBatteryConsumption()) && c.isOn() && !c.isRunning()) {
				c.run();
				this.consumeBattery(c.getBatteryConsumption());
			}
		}
	}
	
}
