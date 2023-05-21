import {Component, ViewChild} from '@angular/core';
import {PersonColorService} from '../services/person-color-service';
import {PersonAndColorModel} from '../models/person-color-model';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'personal-details',
  styleUrls: ['../css/personal-details.css'],
  templateUrl: '../html/personal-details.html',
  providers: [PersonColorService]
})
export class PersonalDetails {

  constructor(private service : PersonColorService)
  {
    this.service = service;
  }
  displayedColumns: string[] = ['id', 'name', 'lastname', 'zipcode', 'city', 'color'];

  //  Code for tab 1
  public dataSourceAllPeople = new MatTableDataSource<PersonAndColorModel>();

  ngOnInit() {
    this.service.getPeople().subscribe(people => this.dataSourceAllPeople.data = people);
  }

  @ViewChild(MatSort) sort: MatSort;

  ngAfterViewInit() {
    this.dataSourceAllPeople.sort = this.sort;
  }
  applyFilter(event: Event) {
      const filterValue = (event.target as HTMLInputElement).value;
      this.dataSourceAllPeople.filter = filterValue.trim().toLowerCase();
  }

  // Code for tab 2
  showResultsTable : boolean = false;
  public dataSourceSameColorLove = new MatTableDataSource<PersonAndColorModel>();
  search(color:string) {
     this.service.getPeopleWhoLoveTheSameColor(color).subscribe(people => this.dataSourceSameColorLove.data = people);
  }
}
