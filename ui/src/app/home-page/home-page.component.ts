import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MyServiceService } from '../services/my-service.service';
import { IService } from '../types/service.type';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})

export class HomePageComponent implements AfterViewInit {
  data: any;
  displayedColumns: string[] = ['clubName', 'clubLocation', 'points', 'clubId', 'numOfWins', 'numOfDefeats', 'numOfDraws', 'numOfGoalsReceived', 'numOfGoalsScored', 'numOfMatches', 'goalDiffer'];
  @ViewChild(MatSort,{ static: false }) sort: MatSort;

  constructor(private myServiceservice:MyServiceService) {
  }

  ngAfterViewInit(): void {
    this.data = new MatTableDataSource(this.data);
    this.data.sort = this.sort;
    this.getAllService();

  }

  public getAllService() {
    let response = this.myServiceservice.getAllService()
    response.subscribe(report=>{
      this.data.data=report as IService[]})
  }

}



