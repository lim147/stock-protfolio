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

  constructor(private transactionService: TransactionService) {
    this.searchFilterForm = new FormGroup({
      searchFilter: new FormControl(null)
    });
  }

  ngOnInit() {
    this.getAllTransactions();
  }

  // setSearchFilterType() {
  //   console.log("Filter: "+this.searchFilterForm));
  //   this.selectedValue = this.searchFilterForm.value;
  // }

  getAllTransactions(){
    this.transactionService.getAllTransactions().subscribe({
      next: (data:any) => this.transactions = data,
      error: (_:any)  => console.log("Error")
    });
  }

  // Add transaction to the transactions list
  searchTransactionById(form: NgForm){
    console.log(this.searchId);
    this.transactions = [];
    this.transactionService.getTransactionById(this.searchId).subscribe({
      next: (data:any) => this.transactions.push(data),
      error: (_:any)  => console.log("Error")
    });
  }
}
