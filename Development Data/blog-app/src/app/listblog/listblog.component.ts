import { Component, OnInit } from '@angular/core';
import { BlogService } from '../blog/blog.service';
import { Router } from '@angular/router';
import { Blog } from '../model/blog';

@Component({
  selector: 'app-listblog',
  templateUrl: './listblog.component.html',
  styleUrls: ['./listblog.component.css']
})
export class ListblogComponent implements OnInit {
  blogs:Blog[];
  blg:Blog;

  constructor(private service:BlogService, private route:Router) { 
    this.blg=new Blog();
  }

  ngOnInit() {
    this.service.listBlog().subscribe(p => this.blogs=p);
  }
  approveBlogs(blog: Blog){
    // console.log(blogId)
    let blogId = blog.blogId;
    this.service.approveBlogs(blogId).subscribe(val => {
      blog.status = 'Approved';
    });
  }
  rejectBlogs(blog:Blog){

    let blogId = blog.blogId;
    this.service.rejectBlogs(blogId).subscribe(val => {
      blog.status = 'Rejected';
    });
  }

  

}
