/* tslint:disable */
import { ChuckSearchResultResponse } from './chuck-search-result-response';
import { People } from './people';
export interface SearchResult {
  chuckEndPoint?: string;
  chuckResult?: ChuckSearchResultResponse;
  swapiEndPoint?: string;
  swapiResult?: People;
}
