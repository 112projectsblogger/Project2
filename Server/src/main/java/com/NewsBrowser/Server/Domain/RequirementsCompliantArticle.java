package com.NewsBrowser.Server.Domain;

import java.util.Date;

import com.NewsBrowser.Server.Domain.NewsAPI.NewsAPIArticle;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data model representing article's data model related to client requirements.
 * @author MJazy
 *
 */
public class RequirementsCompliantArticle {
	
	

	@JsonProperty
	private String author;
	
	@JsonProperty
	private String title;

	@JsonProperty
	private String description;

	@JsonProperty
	private String date;

	@JsonProperty
	private String sourceName;

	@JsonProperty
	private String articleUrl;

	@JsonProperty
	private String imageUrl;
	
	private static final DateFormatter dateFormatter = new DateFormatter();;
	private static final String requirementsCompliantDateFormat = "yyyy-MM-dd";
	
	
	/**
	 * Constructor to be used to process NewsAPIFetchNewsResponseData to client requirements compliant format.
	 * @param author represents author parameter of NewsAPIArticle data model.
	 * @param title represents title parameter of NewsAPIArticle data model.
	 * @param description represents description parameter of NewsAPIArticle data model.
	 * @param date represents publishedAt parameter of NewsAPIArticle data model.
	 * @param sourceName represents name parameter of NewsAPISource data model.
	 * @param articleUrl represents URL parameter of NewsAPIArticle data model.
	 * @param imageUrl represents urlToImage parameter of NewsAPIArticle data model.
	 */
	RequirementsCompliantArticle(NewsAPIArticle newsAPIArticle){
		this.author = newsAPIArticle.getAuthor();
		this.title = newsAPIArticle.getTitle();
		this.description = newsAPIArticle.getDescription();	
		
		if(newsAPIArticle.getPublishedAt() != null) {
			this.date = dateFormatter.formatDate(requirementsCompliantDateFormat, newsAPIArticle.getPublishedAt());
		}
		this.setDate(newsAPIArticle.getPublishedAt());
		this.sourceName = newsAPIArticle.getSource().getName();
		this.articleUrl = newsAPIArticle.getUrl();
		this.imageUrl = newsAPIArticle.getUrlToImage();
	}
	
	
	public String getAuthor() {
		return author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getDate() {
		return date;
	}
	
	private void setDate(Date date) {
		if (date != null) {
			this.date = dateFormatter.formatDate(requirementsCompliantDateFormat, date);			
		}

		
	}
	
	public String getSourceName() {
		return sourceName;
	}
	
	public String getArticleUrl() {
		return articleUrl;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	@Override
	public String toString() {
		String string = String.format("author: '%s', title: '%s', description: '%s',"
				+ " date:'%s', sourceName: '%s', articleUrl: '%s', imageUrl: '%s'",
				this.getAuthor(), this.getTitle(), this.getDescription(), this.getDate(),
				this.getSourceName(), this.getArticleUrl(), this.getImageUrl());
		return string;
	}
	
}
