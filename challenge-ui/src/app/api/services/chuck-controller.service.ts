/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { ChuckResult } from '../models/chuck-result';

/**
 * the chuck API
 */
@Injectable({
  providedIn: 'root',
})
class ChuckControllerService extends __BaseService {
  static readonly chuckCategoriesGetPath = '/chuck/categories';
  static readonly chuckCategoryGetPath = '/chuck/{category}';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Returns a list of chuck categories
   * @return OK
   */
  chuckCategoriesGetResponse(): __Observable<__StrictHttpResponse<Array<string>>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/chuck/categories`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<Array<string>>;
      })
    );
  }
  /**
   * Returns a list of chuck categories
   * @return OK
   */
  chuckCategoriesGet(): __Observable<Array<string>> {
    return this.chuckCategoriesGetResponse().pipe(
      __map(_r => _r.body as Array<string>)
    );
  }

  /**
   * Returns random joke
   * @param category category
   * @return OK
   */
  chuckCategoryGetResponse(category: string): __Observable<__StrictHttpResponse<ChuckResult>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;

    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/chuck/${encodeURIComponent(String(category))}`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<ChuckResult>;
      })
    );
  }
  /**
   * Returns random joke
   * @param category category
   * @return OK
   */
  chuckCategoryGet(category: string): __Observable<ChuckResult> {
    return this.chuckCategoryGetResponse(category).pipe(
      __map(_r => _r.body as ChuckResult)
    );
  }
}

module ChuckControllerService {
}

export { ChuckControllerService }
