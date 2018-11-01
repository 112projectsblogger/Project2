package com.NewsBrowser.Server.REST;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.NewsBrowser.Server.Domain.News;
import com.NewsBrowser.Server.Domain.NewsAPI.NewsAPIFetchNewsResponse;
import com.NewsBrowser.Server.Service.NewsAPI.NewsAPINewsFetcher;
import com.NewsBrowser.Server.Service.NewsAPI.NewsAPIResponseParser;
import com.NewsBrowser.Server.Service.NewsAPI.NewsAPIURLPreparator;
import com.NewsBrowser.Server.Service.NewsAPI.NewsAPIUserInputValidator;

/**
 * Application controller handling process of news fetching service.
 * @author MJazy
 *
 */
@RestController
public class RESTController {
	
	@Inject
	NewsAPIUserInputValidator newsAPIValidator;
	
	@Inject
	NewsAPIURLPreparator newsAPIURLPreparator;
	
	@Inject
	NewsAPINewsFetcher newsAPINewsFetcher;
	
	@Inject
	NewsAPIResponseParser newsAPIResponseParser;
	
	/**
	 * Controller for NewsAPI news fetching process.
	 * Values of origins are of Client module (where port 4200 is of application run, and 9876 of Karma's tests).
	 * @param country should be lower case ISO 3166-1 code. At this moment only "us" is supported by this application.
	 * @param category should be one of "business, entertainment, general, health, science, sports, technology". 
	 * @return News in form compliant with requirements or null in case input is not valid.
	 */
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:9876"})
	@GetMapping("/news/{country}/{category}/")
	News newsAPIFetchNews(@PathVariable String country, @PathVariable String category) {
		
		News response = null;
		
		if (newsAPIValidator.isInputValid(country, category) == false) {
			return response;
		}

		String url = newsAPIURLPreparator.prepareFetchNewsUrl(country, category);
		String fetchNewsResponseBody = newsAPINewsFetcher.fetchNews(url);
		NewsAPIFetchNewsResponse newsAPIFetchNewsResponse = newsAPIResponseParser.parseFetchNewsResponse(fetchNewsResponseBody);
		
		response = new News(country, category, newsAPIFetchNewsResponse.getArticles());

		return response;
	}
	
}
