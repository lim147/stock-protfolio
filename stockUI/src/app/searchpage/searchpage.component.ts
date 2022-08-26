import { Component } from '@angular/core';
import { Transaction } from '../transaction';
import { TransactionService } from '../transaction.service';
import { FormControl, FormGroup, NgForm } from '@angular/forms';
import { filter } from 'minimatch';

@Component({
  selector: 'app-searchpage',
  templateUrl: './searchpage.component.html',
  styleUrls: ['./searchpage.component.css']
})
export class SearchpageComponent{
  searchFilters: string[] = ['ID', 'Symbol', 'Date Range', 'Price Range', 'Transaction Type'];
  searchFilterForm: FormGroup;
  selectedValue: any;
  transactions!: Array<Transaction>;
  searchId : number = 1;
  searchSymbol: string = "";
  startPrice: number = 0;
  endPrice: number = 0;
  startDate: Date = new Date();
  endDate: Date = new Date();
  searchType: string = "";

  constructor(private transactionService: TransactionService) {
    this.searchFilterForm = new FormGroup({
      searchFilter: new FormControl(null)
    });
  }

  ngOnInit() {
    this.getAllTransactions();
  }

  setSearchFilterType() {
    this.selectedValue = this.searchFilterForm.value.searchFilter;
  }

  getAllTransactions(){
    this.transactionService.getAllTransactions().subscribe({
      next: (data:any) => this.transactions = data,
      error: (_:any)  => console.log("Error")
    });
  }

  // Add transaction to the transactions list
  searchTransactionById(form: NgForm){
    this.transactions = [];
    this.transactionService.getTransactionById(this.searchId).subscribe({
      next: (data:any) => this.transactions.push(data),
      error: (_:any)  => console.log("Error")
    });
  }

  getTransactionsByStockSymbol(form: NgForm){
    this.transactions = [];
    this.transactionService.getTransactionsByStockSymbol(this.searchSymbol).subscribe({
      next: (data:any) => this.transactions = data,
      error: (_:any)  => console.log("Error")
    });
  }
  
  getTransactionsBetweenDate(form: NgForm){
    this.transactions = [];
    this.transactionService.getTransactionsBetweenDate(this.startDate, this.endDate).subscribe({
      next: (data:any) => this.transactions = data,
      error: (_:any)  => console.log("Error")
    });
  }

  getTransactionsBetweenPrice(form: NgForm){
    this.transactions = [];
    this.transactionService.getTransactionsBetweenPrice(this.startPrice, this.endPrice).subscribe({
      next: (data:any) => this.transactions = data,
      error: (_:any)  => console.log("Error")
    });
  }
  
  getTransactionsByType(form: NgForm){
    console.log(this.searchType);
    this.transactions = [];
    this.transactionService.getTransactionsByType(this.searchType).subscribe({
      next: (data:any) => this.transactions = data,
      error: (_:any)  => console.log("Error")
    });
  }
}
