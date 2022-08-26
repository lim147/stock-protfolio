import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Transaction } from './transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  private baseUrl: string = 'http://sang-missi-3-portfolio-sang-missi-3-portfolio.openshift83.conygre.com/api/transactions';
  //private baseUrl: string = 'http://localhost:8080/api/transactions';

  constructor(private http: HttpClient) {} 

  getAllTransactions(): Observable<Array<Transaction>>  {
      return this.http.get(this.baseUrl) as Observable<Array<Transaction>>;
  }

  getTransactionById(id: number): Observable<Transaction> {
      return this.http.get(`${this.baseUrl}/${id}`) as Observable<Transaction>;
  }

  getTransactionsByStockSymbol(stockSymbol: string): Observable<Array<Transaction>> {
      return this.http.get(`${this.baseUrl}/stock-symbol/${stockSymbol}`) as Observable<Array<Transaction>>;
  }

  getTransactionsBetweenDate(startDate: Date, endDate: Date): Observable<Array<Transaction>> {
    return this.http.get(`${this.baseUrl}/submitted-date-between/${startDate}/${endDate}`) as Observable<Array<Transaction>>;
  }

  getTransactionsBetweenPrice(startPrice: number, endPrice: number): Observable<Array<Transaction>> {
    return this.http.get(`${this.baseUrl}/submitted-price-between/${startPrice}/${endPrice}`) as Observable<Array<Transaction>>;
  }

  getTransactionsByType(type: string): Observable<Array<Transaction>> {
    return this.http.get(`${this.baseUrl}/type/${type}`) as Observable<Array<Transaction>>;
  }
}
