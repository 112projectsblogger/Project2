package com.NewsBrowser.Server.Service.NewsAPI;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.NewsBrowser.Server.Service.NewsAPI.NewsAPIUserInputValidator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsAPIUserInputValidatorTest {

	@Inject
	NewsAPIUserInputValidator newsAPIUserInputValidator;
	
	@Test
	public void validUserInputTest() {
		assertEquals(true, newsAPIUserInputValidator.isInputValid("us", "business"));
		assertEquals(true, newsAPIUserInputValidator.isInputValid("us", "entertainment"));
		assertEquals(true, newsAPIUserInputValidator.isInputValid("us", "general"));
		assertEquals(true, newsAPIUserInputValidator.isInputValid("us", "health"));
		assertEquals(true, newsAPIUserInputValidator.isInputValid("us", "science"));
		assertEquals(true, newsAPIUserInputValidator.isInputValid("us", "sports"));
		assertEquals(true, newsAPIUserInputValidator.isInputValid("us", "technology"));
	}
	
	@Test
	public void invalidUserInputTest() {
		assertEquals(false, newsAPIUserInputValidator.isInputValid(null, null));
		assertEquals(false, newsAPIUserInputValidator.isInputValid("", ""));
		assertEquals(false, newsAPIUserInputValidator.isInputValid("de", "sports"));
		assertEquals(false, newsAPIUserInputValidator.isInputValid("us", "everything"));
	}
	

}
