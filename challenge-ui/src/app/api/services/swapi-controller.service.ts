/* tslint:disable */
import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse, HttpHeaders } from '@angular/common/http';
import { BaseService as __BaseService } from '../base-service';
import { ApiConfiguration as __Configuration } from '../api-configuration';
import { StrictHttpResponse as __StrictHttpResponse } from '../strict-http-response';
import { Observable as __Observable } from 'rxjs';
import { map as __map, filter as __filter } from 'rxjs/operators';

import { People } from '../models/people';

/**
 * the swapi API
 */
@Injectable({
  providedIn: 'root',
})
class SwapiControllerService extends __BaseService {
  static readonly swapiPeopleGetPath = '/swapi/people';

  constructor(
    config: __Configuration,
    http: HttpClient
  ) {
    super(config, http);
  }

  /**
   * Returns a list of Star Wars people
   * @return OK
   */
  swapiPeopleGetResponse(): __Observable<__StrictHttpResponse<People>> {
    let __params = this.newParams();
    let __headers = new HttpHeaders();
    let __body: any = null;
    let req = new HttpRequest<any>(
      'GET',
      this.rootUrl + `/swapi/people`,
      __body,
      {
        headers: __headers,
        params: __params,
        responseType: 'json'
      });

    return this.http.request<any>(req).pipe(
      __filter(_r => _r instanceof HttpResponse),
      __map((_r) => {
        return _r as __StrictHttpResponse<People>;
      })
    );
  }
  /**
   * Returns a list of Star Wars people
   * @return OK
   */
  swapiPeopleGet(): __Observable<People> {
    return this.swapiPeopleGetResponse().pipe(
      __map(_r => _r.body as People)
    );
  }
}

module SwapiControllerService {
}

export { SwapiControllerService }
