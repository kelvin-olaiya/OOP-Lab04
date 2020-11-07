package it.unibo.oop.lab04.robot.arms;
import it.unibo.oop.lab04.robot.composable.Component;
public class BasicArm extends Component {
	public static final double CONSUMPTION_FOR_PICK_UP = 1;
	public static final double CONSUMPTION_FOR_DROP_DOWN = 0.5;
	
	private boolean isCarryingObject;
	
	public BasicArm(String name) {
		super(name);
		this.isCarryingObject = false;
	}
	
	public boolean isGrabbing() {
		return this.isCarryingObject;
	}
	
	public boolean pickUp() {
		return this.operation(true);
	}
	
	public boolean dropDown() {
		return this.operation(false);
	}
	
	public double getConsuptionForPickUp() {
		return CONSUMPTION_FOR_PICK_UP;
	}
	
	public double getConsuptionForDropDown() {
		return CONSUMPTION_FOR_DROP_DOWN;
	}
	
	public String toString() {
		return "Basic Arm [name: " + this.toString() + "]";
	}
	
	private boolean operation(final boolean carryingStatus) {
		if (carryingStatus != this.isGrabbing()) {
			this.isCarryingObject = carryingStatus;
			return true;
		}
		return false;
	}

	@Override
	public double getBatteryConsumption() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void run() {
		// TODO Auto-generated method stub
		
	}
}
