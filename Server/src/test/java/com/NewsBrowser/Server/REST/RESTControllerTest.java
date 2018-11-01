package com.NewsBrowser.Server.REST;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RESTControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	private String invalidCountry;
	private String validCountry;
	private String validCategory;
	private String invalidFetchNewsPath;	
	private String validFetchNewsPath;	
	
	@Before
	public void initializeVariables() {
		invalidCountry = "test";
		validCountry = "us";
		validCategory = "technology";
		invalidFetchNewsPath = String.format("http://localhost:%s/news/%s/%s/", port, invalidCountry, validCategory);
		validFetchNewsPath = String.format("http://localhost:%s/news/%s/%s/", port, validCountry, validCategory);
	}
	
    @Test
    public void validInputRun() throws Exception {
        assertThat(this.restTemplate.getForObject(validFetchNewsPath, 
        		String.class)).contains("\"country\":\"us\",\"category\":\"technology\"");
        
    }
    
    @Test
    public void invalidInputRun() throws Exception {
        assertThat(this.restTemplate.getForObject(invalidFetchNewsPath, String.class)).isEqualTo(null);
    }
}
