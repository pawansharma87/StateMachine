package fsm.state.machine;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class CashCounting {

	private static Logger LOGGER = Logger.getLogger(CashCounting.class.getName());

	private State state = null;

	public State getState() {
		return this.state;
	}

	static Scanner scanner = new Scanner(System.in);

	CashCounting() {
		state = State.S0;
		System.out.println("Intial state is " + state);
	}

	public void nextEvent(String event) {
		state = state.nextState(event);
	}

	public static void main(String[] args) {

		boolean flag = true;
		CashCounting cashCounting = new CashCounting();
		try {
			while (flag) {
				if (State.CANCELLED == cashCounting.state) {
					System.out.println("Your purchage has been cancelled");
					break;
				} else if (State.S4 == cashCounting.state) {
					cashCounting.nextEvent("BUY");
				} else if (State.COMPLETED == cashCounting.state) {
					cashCounting.nextEvent("COMPLETED");
					System.out.println("Thank you");
					break;
				} else {
					System.out.println("Enter next event");
					String event = scanner.next();
					cashCounting.nextEvent(event);
				}
			}
		} catch (Exception err) {
			LOGGER.error(err.getMessage());
		}

	}

}
