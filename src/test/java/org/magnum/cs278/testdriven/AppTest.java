package org.magnum.cs278.testdriven;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.joda.time.DateTime;

import org.junit.Test;

public class AppTest {

	private App app = new App();
	
	@Test
	public void testGetParkSpecialPermits() throws Exception {
		List<Event> events = app.getAll();
		assertTrue("The list of Park Special Permits is empty", events.size() > 0);
		assertEquals(390, events.size());
		for(Event event : events){
			assertNotNull(event);
			assertNotNull(event.getLocation());
			assertNotNull(event.getName());
			assertNotNull(event.getAttendance());
			assertNotNull(event.getDate());
		}
	}
	
	
	@Test
	public void testGetEventsForMonth() throws Exception {
		String month = "Mar-2014";
		List<Event> events = app.getEventsForMonth(month);
		assertEquals(17, events.size()); //assuming JSON input for events is static
		for (Event e : events) {
			assertEquals(month, e.getMonth());
		}
	}
	
	
	@Test
	public void testGetEventsLargerThanOneThousand() throws Exception {
		List<Event> events = app.getEventsLargerThan(1000);
		for (Event event : events)
			assertTrue(Integer.parseInt(event.getAttendance()) > 1000);
	}
	
	
	@Test
	public void testAttendanceGreaterThanFive() throws Exception{
		List<Event> events = app.getEventsLargerThan(5);
		
		for(Event event: events){
			assertTrue(Integer.parseInt(event.getAttendance()) > 5);
		}
	}

	
	@Test
	public void testGetEventsWithLocation() throws Exception {
		String loc = "riverfront park";
		List<Event> events = app.getEventsWithLocation(loc);
        assertEquals(19, events.size()); //assuming static JSON input
		for(Event event : events) {
			assertTrue(event.getLocation().toLowerCase().contains(loc));
		}
		assertTrue(app.getEventsWithLocation("not a real location").isEmpty());
	}

	
	@Test
	public void testTodaysEvents() throws Exception {
		List<Event> whatToDo = app.getTodaysEvents();
		
		for(Event thingToDo : whatToDo){
			assertNotNull(thingToDo);
			assertNotNull(thingToDo.getDate());
			
			DateTime eventDate = Event.DATE_TIME_FORMAT.parseDateTime(thingToDo.getDate());
			assertTrue(eventDate.isEqualNow());
		}
	}
}
