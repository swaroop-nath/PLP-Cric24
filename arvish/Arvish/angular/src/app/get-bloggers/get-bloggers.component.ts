import { Component, OnInit } from '@angular/core';
import { User } from '../login-model/user.model';
import { AuthService } from '../auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-bloggers',
  templateUrl: './get-bloggers.component.html',
  styleUrls: ['./get-bloggers.component.css']
})
export class GetBloggersComponent implements OnInit {

  users:User[];
  result: boolean;
  userId: string;

  constructor(private service : AuthService, private route: Router) { }

  ngOnInit() {
    this.service.getBloggers().subscribe(data=>this.users=data);
  }

  delete(index: number){
    this.userId = this.users[index].userId;
    var ans = confirm("Are you sure you want to delete?")
    if(ans){
      this.users.splice(index,1);
      this.service.deleteBlogger(this.userId);
    }

  }

}
