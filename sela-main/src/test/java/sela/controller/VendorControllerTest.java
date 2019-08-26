package sela.controller;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class VendorControllerTest extends TestCase {

	@Mock
    private RestTemplate restTemplate;

   // @InjectMocks
   // private SomeService underTest;  
	
	protected void setUp() throws Exception {
		super.setUp();
	}

}
