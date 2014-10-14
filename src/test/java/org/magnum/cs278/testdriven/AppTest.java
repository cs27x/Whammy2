package org.magnum.cs278.testdriven;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class AppTest {

		private App app = new App();
		
		@Test
		public void testNothing() {
			assertTrue(true);
		}
		
		
		@Test
		public void testGetEventsWithLocation() throws Exception {
			String location = "Riverfront Park/Court of Flags";
			// There are exactly 2 events with this
			// location.
			int count = 2;
			
			List<Event> events = app.getEventsWithLocation(location);
			
			assertEquals(count, events.size());
			
			// Make sure that these are the events
			// that we expect
			for (Event event : events) {
				assertEquals(location, event.getLocation());
			}
		}
}
