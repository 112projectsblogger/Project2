package com.NewsBrowser.Server.Service.NewsAPI;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.NewsBrowser.Server.Service.NewsAPI.NewsAPIURLPreparator;
@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsAPIURLPreparatorTest {

	@Inject
	NewsAPIURLPreparator newsAPIURLPreparator;
	
	@Test
	public void prepareFetchNewsURLTest() {
		String relevantURL = "https://newsapi.org/v2/top-headlines?country=us&category=technology&apiKey=dc98f2c2ddfe44d0b8102025c394cd08";
		assertEquals(relevantURL, newsAPIURLPreparator.prepareFetchNewsUrl("us", "technology"));

	}
	
}
