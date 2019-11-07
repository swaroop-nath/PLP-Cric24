import { Component, OnInit } from '@angular/core';
import { Blog } from '../model/blog';
import { BlogService } from '../blog/blog.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addblog',
  templateUrl: './addblog.component.html',
  styleUrls: ['./addblog.component.css']
})
export class AddblogComponent implements OnInit {

  blog:Blog;
  
  
  constructor(private service:BlogService, private route:Router) { 
    this.blog=new Blog();
  }

  ngOnInit() {
  }
  addBlog(){
  this.service.addBlog(this.blog).subscribe(data=> this.blog=data);
  this.blog = new Blog();
  this.route.navigate(['list']);
}
}
