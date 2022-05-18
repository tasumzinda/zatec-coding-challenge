import { Component, OnInit } from '@angular/core';
import { ChuckResult, ChuckSearchResultResponse, People, Result, SearchResult } from 'src/app/api/models';
import { SearchControllerService } from 'src/app/api/services';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.sass']
})
export class SearchComponent implements OnInit {

  searchResult!: SearchResult;
  chuckResult?: ChuckSearchResultResponse;
  swapiResult?: People;
  searchExp?: string;
  peopleSource!: Array<Result>;
  displayedPeopleColumns = ['name', 'height', 'hair_color', 'skin_color'];
  chuckSource!: Array<ChuckResult>;
  displayedChuckColumns = ['url', 'value'];
  constructor(
    private _searchService: SearchControllerService
  ) { }

  ngOnInit(): void {
  }

  search() {
    this._searchService.searchGet(this.searchExp!).subscribe(
      (result) => {
        this.searchResult = result;
        this.chuckResult = result.chuckResult;
        this.chuckSource = this.chuckResult!.result!;
        this.swapiResult = result.swapiResult;
        this.peopleSource = this.swapiResult!.results!;
      },
      error => console.log('Error')
    )
  }

}
