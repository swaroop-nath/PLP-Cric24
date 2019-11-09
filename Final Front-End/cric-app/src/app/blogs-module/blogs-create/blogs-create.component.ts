import { Component, OnInit } from '@angular/core';
import { Blog } from 'src/app/model/blog.model';
import { BlogsService } from '../blogs-service/blogs-service.service';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth-module/auth-service/auth-service.service';

@Component({
  selector: 'app-blogs-create',
  templateUrl: './blogs-create.component.html',
  styleUrls: ['./blogs-create.component.css']
})
export class BlogsCreateComponent implements OnInit {

  blog:Blog;
  blogType:string[]=['Players','Tournaments','Teams','Miscalleneous'];
  
  constructor(private service:BlogsService, private authService: AuthService, private route:Router) { 
    this.blog=new Blog();
    this.blog.blogger = this.authService.getUserBean();
  }

  ngOnInit() {
  }
  addBlog(){
    console.log(this.blog)
  this.service.addBlog(this.blog).subscribe();
  this.blog = new Blog();
  // this.route.navigate(['list']);
}
}
