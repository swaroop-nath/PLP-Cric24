import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { BlogsService } from '../blogs-service/blogs-service.service';
import { Blog } from 'src/app/model/blog.model';

@Component({
  selector: 'app-blog-view',
  templateUrl: './blog-view.component.html',
  styleUrls: ['./blog-view.component.css']
})
export class BlogViewComponent implements OnInit {

  private receivedBlog: Blog;
  isNotAdmin: boolean = true;

  constructor(private blogService: BlogsService) { }

  ngOnInit() {
    this.receivedBlog = this.blogService.transitBlog;

    this.isNotAdmin = this.blogService.getUser() != 'admin';

    $(window).on('popstate', (event) => {
      this.blogService.getFromBackStack().initializeComponent()
    });
    this.onStart();
  }

  onStart() {
    // position please!!!
    $('#schedules-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#archives-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#blogs-outlet').animate({height: '100%', width: '100%'}, 500).show()
  }

  approveBlog(){
    // console.log(blogId)
    let blogId = this.receivedBlog.blogId;

    this.blogService.approveBlogs(blogId).subscribe(val => {
      this.blogService.blogs_master.find(blog => blog.blogId == blogId).status='Approved'
      // Show some alerts
    });
  }
  
  rejectBlog(){
    let blogId = this.receivedBlog.blogId;

    this.blogService.rejectBlogs(blogId).subscribe(val => {
      this.blogService.blogs_master.find(blog => blog.blogId == blogId).status='Rejected'
    });
  }

}
