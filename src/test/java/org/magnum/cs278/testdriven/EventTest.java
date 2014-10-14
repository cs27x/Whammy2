package org.magnum.cs278.testdriven;

import static org.junit.Assert.*;

import org.junit.Test;

public class EventTest {
	@Test
	public void testToString() throws Exception {
		Event event = new Event("testEvent", "eventLocation", "testAttendance", "testMonth", "testDate");
		assertEquals(event.toString(), "testEvent / eventLocation / testAttendance / testMonth / testDate");
	}
}