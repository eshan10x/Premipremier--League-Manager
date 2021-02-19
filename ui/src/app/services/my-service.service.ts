import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class MyServiceService {
  private link = '/api/prmierLeagueData';
  private match = '/api/macthData';
  private genMatch = '/api/genareteMatch';

  constructor(private httpClient:HttpClient) { }

  public getAllService(){
    return this.httpClient.get(this.link);
  }

  public getMatchService() {
    return this.httpClient.get(this.match);
  }

  public generateMatch() {
    try {
      return this.httpClient.get(this.genMatch);
    } catch (error) {
      console.log(`[ERROR ==> getData ==> ${error.message}`,error);
      return null
    }
  }
}
