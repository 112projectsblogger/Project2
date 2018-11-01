package com.NewsBrowser.Server.Service.NewsAPI;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.NewsBrowser.Server.Domain.NewsAPI.NewsAPIFetchNewsResponse;


@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsAPIResponseParserTest {

	@Inject
	NewsAPIURLPreparator newsAPIUrlPreparator;
	
	@Inject
	NewsAPINewsFetcher newsAPINewsFetcher;
	
	@Inject
	NewsAPIResponseParser newsAPIResponseParser;
	
	NewsAPIFetchNewsResponse newsAPIFetchNewsResponse;
	
	@Before
	public void initializeVariable() {
		String url = newsAPIUrlPreparator.prepareFetchNewsUrl("us", "technology");
		String fetchNewsResponseBody = newsAPINewsFetcher.fetchNews(url);
		newsAPIFetchNewsResponse = newsAPIResponseParser.parseFetchNewsResponse(fetchNewsResponseBody);
	}
	
	@Test
	public void parseFetchNewsResponseTest() {
		assertTrue(newsAPIFetchNewsResponse.getStatus() != null);
		assertTrue(newsAPIFetchNewsResponse.getTotalResults() != null);
		assertTrue(newsAPIFetchNewsResponse.getArticles() != null);

	}

}
