package com.prokabaddi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author purvi.manohar.lahoti
 * This is a test class for App
 */
@RunWith(PowerMockRunner.class)
public class AppTest {
	
	@Test
	public void test() {
		String[] args = null;
		App.main(args);
	}
  
}
