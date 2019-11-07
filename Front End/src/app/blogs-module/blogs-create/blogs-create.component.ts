import { Component, OnInit } from '@angular/core';
import { Blog } from 'src/app/model/blog.model';
import { BlogsService } from '../blogs-service/blogs-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-blogs-create',
  templateUrl: './blogs-create.component.html',
  styleUrls: ['./blogs-create.component.css']
})
export class BlogsCreateComponent implements OnInit {

  blog:Blog;

  constructor(private service:BlogsService, private route:Router) { 
    this.blog=new Blog();
  }

  ngOnInit() {
  }

  addBlog(){
  this.service.addBlog(this.blog).subscribe(savedBlog => {
    this.blog = new Blog();
    this.route.navigate(['blogs-list']);
  });
}
}
