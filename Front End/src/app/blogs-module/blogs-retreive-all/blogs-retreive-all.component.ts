import { Component, OnInit } from '@angular/core';
import { Blog } from 'src/app/model/blog.model';
import { BlogsService } from '../blogs-service/blogs-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-blogs-retreive-all',
  templateUrl: './blogs-retreive-all.component.html',
  styleUrls: ['./blogs-retreive-all.component.css']
})
export class BlogsRetreiveAllComponent implements OnInit {
  blogs:Blog[];

  constructor(private service:BlogsService, private route:Router) { 
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
