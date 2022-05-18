import { Component, OnInit } from '@angular/core';
import { Result } from 'src/app/api/models';
import { People } from 'src/app/api/models/people';
import { SwapiControllerService } from 'src/app/api/services';

@Component({
  selector: 'app-people',
  templateUrl: './people.component.html',
  styleUrls: ['./people.component.sass']
})
export class PeopleComponent implements OnInit {

  people?: People;
  dataSource!: Array<Result>;
  displayedColumns = ['name', 'height', 'hair_color', 'skin_color'];
  constructor(
    private _swapiControllerService: SwapiControllerService
  ) { }

  ngOnInit(): void {
    this._swapiControllerService.swapiPeopleGet().subscribe(
      (response) => {
        this.people = response;
        this.dataSource = this.people.results!;
      },
      error => console.log('Error')
    )
  }

}
