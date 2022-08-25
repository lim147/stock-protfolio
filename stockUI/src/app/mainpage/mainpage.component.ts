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
  transactions!: Array<Transaction>;
  searchId : number = 1;

  constructor(private transactionService: TransactionService) { }

  ngOnInit() {
    this.getAllTransactions();
  }

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
