import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { FetcherService } from './fetcher.service';
import { delay } from 'q';


describe('FetcherService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [
      HttpClientModule
    ]
  }));

  it('should be created', () => {
    const service: FetcherService = TestBed.get(FetcherService);
    expect(service).toBeTruthy();
  });

  // Server should be set before running this test.
  it('Should have values set', async() => {
    const service: FetcherService = TestBed.get(FetcherService);
    const technologyString = 'technology';
    const countryString = 'us';
    service.fetchNews(technologyString);
    await delay(2000);
    expect(service.fetchNewsResponse.category === technologyString);
    expect(service.fetchNewsResponse.country === countryString);
    expect(service.fetchNewsResponse.articles !== null);
  });

});
