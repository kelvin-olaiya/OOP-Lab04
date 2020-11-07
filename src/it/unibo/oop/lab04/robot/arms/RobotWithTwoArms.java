package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms {
	private static final int MAX_ITEMS = 2;
	private static final double EXTRA_ENERGY_WHEN_CARRYING_ITEMS = 1;

	private final BasicArm rightArm;
	private final BasicArm leftArm;
	private int carryiedItems;
	
	public RobotWithTwoArms(String robotName) {
		super(robotName);
		
		rightArm = new BasicArm("Right arm");
		leftArm = new BasicArm("Left arm");
		this.carryiedItems = 0;
	}

	public boolean pickUp() {
		if (this.getCarriedItemsCount() < MAX_ITEMS && this.isBatteryEnough(BasicArm.CONSUMPTION_FOR_PICK_UP)) {
			this.carryiedItems++;
		} else {
			return false;
		}
		return rightArm.pickUp() || leftArm.pickUp();
	}

	public boolean dropDown() {
		if (this.getCarriedItemsCount() > 0 && this.isBatteryEnough(BasicArm.CONSUMPTION_FOR_DROP_DOWN)) {
			this.carryiedItems--;
		} else {
			return false;
		}
		return rightArm.dropDown() || leftArm.dropDown();
	}

	public int getCarriedItemsCount() {
		return this.carryiedItems;
	}
	
	protected double getBatteryRequirementForMovement() {
        return BaseRobot.MOVEMENT_DELTA_CONSUMPTION + getCarriedItemsCount() * EXTRA_ENERGY_WHEN_CARRYING_ITEMS;
    }
}
