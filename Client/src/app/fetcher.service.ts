import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { News} from './app.component';

@Injectable({
  providedIn: 'root'
})

/**
 * News fetching service.
 * @author MJazy
 */
@Injectable()
export class FetcherService {

  fetchNewsResponse: News;
  readonly country: string = 'us';
  category: string;

  /**
   * Service enabling news fetching.
   * @param category should be one of: "business, general, science, entertainment, sports, technology, health".
   */
  public fetchNews(category: string) {
    this.httpClient.get<News>('http://localhost:8080/news/' + this.country + '/' + category + '/')
    .subscribe(data => (this.fetchNewsResponse = data));
      }


  constructor(private httpClient: HttpClient) { }
}
