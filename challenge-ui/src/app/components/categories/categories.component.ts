import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ChuckResult } from 'src/app/api/models';
import { ChuckControllerService } from 'src/app/api/services';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.sass']
})
export class CategoriesComponent implements OnInit {

  categories$!: Observable<Array<string>>;
  joke!: ChuckResult;
  
  constructor(
    private _chuckControllerService: ChuckControllerService
  ) { }

  ngOnInit(): void {
    this.categories$ = this._chuckControllerService.chuckCategoriesGet();
  }

  getJoke(category: string) {
    this._chuckControllerService.chuckCategoryGet(category).subscribe(
      (response) => {
        this.joke = response;
      },
      error => console.log('Error')
    )
  }

}
