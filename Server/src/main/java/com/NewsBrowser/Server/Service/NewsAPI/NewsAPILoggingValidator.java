package com.NewsBrowser.Server.Service.NewsAPI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.NewsBrowser.Server.Service.Interfaces.LoggingValidatorInterface;

/**
 * Logging validation service related to NewsAPI vendor.
 * @author MJazy
 *
 */
public class NewsAPILoggingValidator implements LoggingValidatorInterface {

	
	/**
	 * HTTP status possible to expect in case of NewsAPI is 'TOO_MANY_REQUESTS'.
	 */
	@Override
	public boolean shouldUnsuccessfulRequestDebugLogBeAdded(ResponseEntity<String> responseEntity) {
		if (responseEntity.getStatusCode() == HttpStatus.TOO_MANY_REQUESTS) {
			return true;			
		}
		else {
			return false;
		}
	}

	/**
	 * Every status that is not 'OK' or 'TOO_MANY_REQUESTS' should be logged in case of NewsAPI.
	 */
	@Override
	public boolean shouldUnsuccessfulRequestErrorLogBeAdded(ResponseEntity<String> responseEntity) {
		if (responseEntity.getStatusCode() !=  HttpStatus.OK && responseEntity.getStatusCode() != HttpStatus.TOO_MANY_REQUESTS) {
			return true;			
		}
		else {
			return false;
		}
	}

}
