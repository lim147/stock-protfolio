import { Component} from '@angular/core';
import { Observable } from 'rxjs';
import { Transaction } from '../transaction';
import { TransactionService } from '../transaction.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})

export class MainpageComponent{
  transactions!: Observable<Array<Transaction>>;
  transaction!: Transaction;
  searchId : number = 1;

  constructor(private transactionService: TransactionService) { 
    this.transactions = this.transactionService.getAllTransactions();
  }

  ngOnInit() {
    //this.transactions = this.transactionService.getAllTransactions();
  }
 

  // Add transaction to the transactions list
  searchTransactionById(form: NgForm){
    console.log(this.searchId);
    this.transactionService.getTransactionById(this.searchId).subscribe({
      next: (data:any) => this.transaction = data,
      error: (_:any)  => console.log("Error")
    });
  }

}
