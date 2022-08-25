import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Stock } from './stock';

@Injectable({
  providedIn: 'root'
})
export class StockService {

  //private baseUrl: string = 'http://sang-missi-3-portfolio-sang-missi-3-portfolio.openshift83.conygre.com/api/stocks';
  private baseUrl: string = 'http://localhost:8080//api/stocks';
  
  constructor(private http: HttpClient) {} 

  getAllStocks(): Observable<Array<Stock>>  {
      return this.http.get(this.baseUrl) as Observable<Array<Stock>>;
  }

  getStockBySymbol(symbol : string): Observable<Stock> {
      return this.http.get(`${this.baseUrl}/stock-symbol/${symbol}`) as Observable<Stock>;
  }
}
