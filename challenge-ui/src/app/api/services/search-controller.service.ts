/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { SearchResult } from '../models/search-result';

/**
 * the search API
 */
@Injectable({
  providedIn: 'root',
})
class SearchControllerService extends __BaseService {
  static readonly searchGetPath = '/search';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Returns search results
   * @param query query
   * @return OK
   */
  searchGetResponse(query: string): __Observable<__StrictHttpResponse<SearchResult>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    if (query != null) __params = __params.set('query', query.toString());
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/search`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<SearchResult>;
      })
    );
  }
  /**
   * Returns search results
   * @param query query
   * @return OK
   */
  searchGet(query: string): __Observable<SearchResult> {
    return this.searchGetResponse(query).pipe(
      __map(_r => _r.body as SearchResult)
    );
  }
}

module SearchControllerService {
}

export { SearchControllerService }
