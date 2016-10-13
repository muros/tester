package com.urkei;

import static org.junit.Assert.*;

import org.junit.Test;

import com.urkei.annotation.TestCase;

public class AnnoTest {

	Device device = new DeviceMock();
	
	@Test
    @TestCase(caseId="case_one")
	public void testOne() {
		
		boolean started = device.start();
		
		assertEquals(true, started);
	}
	
	@Test
    @TestCase(caseId="case_two")
	public void testTwo() {
		
		boolean started = device.start();
		
		assertEquals(false, started);
	}

}
