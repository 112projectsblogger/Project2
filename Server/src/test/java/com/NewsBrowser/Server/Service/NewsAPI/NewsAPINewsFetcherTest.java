package com.NewsBrowser.Server.Service.NewsAPI;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.NewsBrowser.Server.Service.NewsAPI.NewsAPINewsFetcher;
import com.NewsBrowser.Server.Service.NewsAPI.NewsAPIURLPreparator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsAPINewsFetcherTest {

	
	@Inject
	NewsAPINewsFetcher newsAPINewsFetcher;
	
	@Inject
	NewsAPIURLPreparator newsAPIURLPreparator;
	
	
	private String url;
	
	@Before
	public void initializeVariable() {
		this.url = newsAPIURLPreparator.prepareFetchNewsUrl("us", "technology");
	}
	
	
	
	@Test
	public void succesfulFetchNewsTest() {
		String responseBody = newsAPINewsFetcher.fetchNews(url);
		assertThat(responseBody, containsString("\"status\":\"ok\",\"totalResults\":20"));
	}
	
	
}
