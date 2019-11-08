import { Component, OnInit } from '@angular/core';
import { Blog } from 'src/app/model/blog.model';
import { BlogsService } from '../blogs-service/blogs-service.service';
import { Router } from '@angular/router';
import { BackStack } from 'src/app/cricket-service/back-stack.interface';
import * as $ from 'jquery';

@Component({
  selector: 'app-blogs-retreive-all',
  templateUrl: './blogs-retreive-all.component.html',
  styleUrls: ['./blogs-retreive-all.component.css']
})
export class BlogsRetreiveAllComponent implements OnInit, BackStack {

  blogs_master: Blog[];
  blogs_view: Blog[]

  constructor(private service:BlogsService, private router:Router) { 
  }

  ngOnInit() {
    // Using sessionStorage to list unapproved blogs if admin is logged in
    this.blogs_view = []
    this.service.listBlog().subscribe(fetchedBlogs => {
      this.blogs_master=fetchedBlogs;
      this.blogs_master.forEach(blog => {
        if (blog.status=='Approved')
          this.blogs_view.push(blog)
      })
    });
  }

  initializeComponent() {
    $('#schedules-outlet').animate({height: '150px', width: '100%'}).show()
    $('#archives-outlet').animate({height: '100%', width: '25%'}, 500).show()
    $('#blogs-outlet').animate({height: '100%', width: '70%'})
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

  findBlogs() {
    this.router.navigate([{outlets: {'blogs': ['find-blogs']}}], {relativeTo: this.service.getParentRoute()});
  }

  viewBlog(blog: Blog) {
    this.service.transitBlog = blog;
    this.service.addToBackStack(this)
    this.router.navigate([{outlets: {'blogs': ['blog-view']}}], {relativeTo: this.service.getParentRoute()});
  }

}
