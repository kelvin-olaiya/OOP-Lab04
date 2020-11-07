package it.unibo.oop.lab04.robot.test;
import it.unibo.oop.lab04.robot.composable.*;

/**
 * Utility class for testing composable robots
 * 
 */
public final class TestComposableRobot {

    private static final int CYCLES = 200;

    private TestComposableRobot() {
    }

    public static void main(final String[] args) {

        /*
         * Write your own test.
         * 
         * You will need a robot with an atomic battery, two arms, and a
         * navigator system. Turn on the battery only when the level is below
         * 50%.
         */
    	
    	ComposableRobot composableRobot = new ComposableRobot("KelRobot");
    	composableRobot.attachComponent(new BorderNavigator("BorderNavigator"));
    	composableRobot.attachComponent(new AtomicBattery("Atomic Battery"));
    	composableRobot.attachComponent(new BorderNavigator("2BorderNavigator"));
    	
    	composableRobot.runAllActiveComponents();

    }
}
