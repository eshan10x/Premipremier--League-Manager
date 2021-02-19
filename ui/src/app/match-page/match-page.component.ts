import { CompileShallowModuleMetadata } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MyServiceService } from '../services/my-service.service';
import { Imatch } from '../types/service.type';
import {animate, state, style, transition, trigger} from '@angular/animations';

@Component({
  selector: 'app-match-page',
  templateUrl: './match-page.component.html',
  styleUrls: ['./match-page.component.css']
})

export class MatchPageComponent implements OnInit {

  //intializing variable called dateTo for search method
  dateTo: string;
  MatchData : any;

  //table headers for display 
  displayedColumns: string[] = ['team1', 'team2', 'team1Goals', 'team2Goals', 'matchStadium', 'date'];
  
  //constructor for get service 
  constructor(public myServiceservice:MyServiceService) { }
  
  ngOnInit() {
    this.getMatchService();
  }

  //getMatch service method for add data to table
  public getMatchService() {
    let response = this.myServiceservice.getMatchService()
    response.subscribe(report=>{
      this.MatchData = report as Imatch[];
      this.MatchData.data=report as Imatch[]})
  }

  //method for genarate a new match 
  public gen() {
    let response = this.myServiceservice.generateMatch()
    response.subscribe(report=>{
      this.MatchData = report as Imatch[];
      this.MatchData.data=report as Imatch[]})

  }

  //search method 
  search(){
    if(this.dateTo == ""){
      //calling display method called getMatch service
        this.getMatchService();
    }else{
      this.MatchData = this.MatchData.filter(res =>{
        let date: string = res.date.day.toString()  + "/" + res.date.month.toString() + "/" + res.date.year.toString();
        return date.match(this.dateTo);
      });
    }
  }
}
