package fsm.state.machine;

import org.apache.log4j.Logger;

//This is state enum here we can throw exception while wrong input
public enum State {

	S0 {
		@Override
		State nextState(String event) {
			switch (event) {
			case "1R":
				System.out.println("State is 1S");
				return S1;
			case "2R":
				System.out.println("State is 2S");
				return S2;
			case "CANCEL":
				System.out.println("Your purchage has been canceled.");
				return CANCELLED;
			default:
				System.out.println("Transition " + event + " is invalid. You can't make any purchage.");
				return CANCELLED;
			}
		}
	},
	S1 {
		@Override
		State nextState(String event) {
			switch (event) {
			case "1R":
				System.out.println("State is 2S");
				return S2;
			case "2R":
				System.out.println("State is 3S");
				return S3;
			case "CANCEL":
				System.out.println("Your purchage has been canceled.");
				return CANCELLED;
			default:
				System.out.println("Transition " + event + " is invalid. You can't make any purchage.");
				return CANCELLED;

			}
		}
	},
	S2 {
		@Override
		State nextState(String event) {
			switch (event) {
			case "1R":
				System.out.println("State is 3S");
				return S3;
			case "2R":
				System.out.println("State is 4S");
				return S4;
			case "CANCEL":
				System.out.println("Your purchage has been canceled.");
				return CANCELLED;
			default:
				System.out.println("Transition " + event + " is invalid. You can't make any purchage.");
				return CANCELLED;
			}

		}
	},
	S3 {
		@Override
		State nextState(String event) {
			switch (event) {
			case "1R":
				System.out.println("State is 4S");
				return S4;
			case "CANCEL":
				System.out.println("Your purchage has been canceled.");
				return CANCELLED;
			default:
				System.out.println("Transition " + event + " is invalid. You can't make any purchage.");
				return CANCELLED;
			}

		}
	},
	S4 {
		@Override
		State nextState(String event) {
			System.out.println("Item purchase is " + event);
			return COMPLETED;
		}
	},
	CANCELLED {
		@Override
		State nextState(String event) {
			System.out.println("Your purchase canceled.");
			return CANCELLED;
		}
	},
	COMPLETED {
		@Override
		State nextState(String event) {
			System.out.println("State is Completed. \n Thank you ");
			return COMPLETED;
		}
	};

	abstract State nextState(String aParameter);

	private static final Logger LOGGER = Logger.getLogger(State.class.getName());
}
