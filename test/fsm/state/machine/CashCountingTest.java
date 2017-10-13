package fsm.state.machine;

import static org.junit.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CashCountingTest {

	private CashCounting cashCounting;

	@BeforeMethod
	public void initializeCashCounting() {
		Reporter.log("Test Started....Creating intial state..");
		//Reporter.log("Before test executed.");
		cashCounting = new CashCounting();
	}

	@Test
	public void tsetInitialState() {
		cashCounting = new CashCounting();
		assertEquals("Initial state should be S0", State.S0.toString(),cashCounting.getState().toString());
		Reporter.log("tsetInitialState executed.");

	}

	@Test
	public void tsetCompletedState() {
		Reporter.log("tsetCompletedState executing started with initial state "
				+ cashCounting.getState());
		cashCounting.nextEvent("1R");
		assertEquals("Output sould be 1S", State.S1.toString(), cashCounting
				.getState().toString());
		cashCounting.nextEvent("1R");
		assertEquals("Output sould be 2S", State.S2.toString(), cashCounting
				.getState().toString());
		cashCounting.nextEvent("1R");
		assertEquals("Output sould be 3S", State.S3.toString(), cashCounting
				.getState().toString());
		cashCounting.nextEvent("1R");
		assertEquals("Output sould be 4S", State.S4.toString(), cashCounting
				.getState().toString());
		cashCounting.nextEvent("COMPLETE");
		assertEquals("Output sould be COMPLETED", State.COMPLETED.toString(),
				cashCounting.getState().toString());
		Reporter.log("tsetCompletedState executing started with final state "
				+ cashCounting.getState());
	}

	@Test
	public void tsetCancel() {
		Reporter.log("Cancel purchage executing with initial state "+ cashCounting.getState());
		cashCounting.nextEvent("1R");
		assertEquals("Output sould be 1S", State.S1.toString(), cashCounting
				.getState().toString());
		cashCounting.nextEvent("1R");
		assertEquals("Output sould be 2S", State.S2.toString(), cashCounting
				.getState().toString());
		cashCounting.nextEvent("CANCELLED");
		assertEquals("Output sould be CANCELLED", State.CANCELLED.toString(),
				cashCounting.getState().toString());
		Reporter.log("Cancel purchage executed with final state "
				+ cashCounting.getState());
	}

	@Test
	public void tsetCompletedState2() {
		Reporter.log("tsetCompletedState2 executing started with initial state "
				+ cashCounting.getState()); 
		cashCounting.nextEvent("2R");
		assertEquals("Output sould be 2S", State.S2.toString(), cashCounting
				.getState().toString());
		cashCounting.nextEvent("2R");
		assertEquals("Output sould be 4S", State.S4.toString(), cashCounting
				.getState().toString());
		cashCounting.nextEvent("COMPLETE");
		assertEquals("Output sould be COMPLETED", State.COMPLETED.toString(),
				cashCounting.getState().toString());
		Reporter.log("tsetCompletedState2 executed with final state "
				+ cashCounting.getState());
	}
	
	@Test
	public void tsetCompletedState3() {
		Reporter.log("tsetCompletedState3 executing started with initial state "
				+ cashCounting.getState()); 
		cashCounting.nextEvent("1R");
		assertEquals("Output sould be 1S", State.S1.toString(), cashCounting
				.getState().toString());
		cashCounting.nextEvent("2R");
		assertEquals("Output sould be 3S", State.S3.toString(), cashCounting
				.getState().toString());
		cashCounting.nextEvent("1R");
		assertEquals("Output sould be 4S", State.S4.toString(), cashCounting
				.getState().toString());
		cashCounting.nextEvent("COMPLETE");
		assertEquals("Output sould be COMPLETED", State.COMPLETED.toString(),
				cashCounting.getState().toString());
		Reporter.log("tsetCompletedState3 executed with final state "
				+ cashCounting.getState());
	}
	
	@Test
	public void tsetCompletedState4() {
		Reporter.log("tsetCompletedState4 executing started with initial state "
				+ cashCounting.getState()); 
		cashCounting.nextEvent("2R");
		assertEquals("Output sould be 2S", State.S2.toString(), cashCounting
				.getState().toString());
		cashCounting.nextEvent("1R");
		assertEquals("Output sould be 3S", State.S3.toString(), cashCounting
				.getState().toString());
		cashCounting.nextEvent("1R");
		assertEquals("Output sould be 4S", State.S4.toString(), cashCounting
				.getState().toString());
		cashCounting.nextEvent("COMPLETE");
		assertEquals("Output sould be COMPLETED", State.COMPLETED.toString(),
				cashCounting.getState().toString());
		Reporter.log("tsetCompletedState4 executed with final state "
				+ cashCounting.getState());
	}
	
	@Test
	public void tsetCancelledState() {
		Reporter.log("tsetCompletedState5 executing started with initial state "
				+ cashCounting.getState()); 
		cashCounting.nextEvent("2R");
		assertEquals("Output sould be 2S", State.S2.toString(), cashCounting
				.getState().toString());
		cashCounting.nextEvent("1R");
		assertEquals("Output sould be 3S", State.S3.toString(), cashCounting
				.getState().toString());
		cashCounting.nextEvent("2R");
		assertEquals("Output sould be CANCELLED", State.CANCELLED.toString(), cashCounting
				.getState().toString());
		Reporter.log("tsetCompletedState5 executed with final state "
				+ cashCounting.getState());
	}
	
	@Test
	public void tsetWrongEvent() {
		Reporter.log("tsetCompletedState6 executing started with initial state "
				+ cashCounting.getState()); 
		cashCounting.nextEvent("CANCELLED");
		Reporter.log("tsetCompletedState5 executed with final state "
				+ cashCounting.getState());
	}
	
	@Test(expectedExceptions={Exception.class})
	public void exceptionTest() throws Exception {
		Reporter.log("Executing exception test case"); 
		throw new Exception("Exception came while processing events");
	}

}
