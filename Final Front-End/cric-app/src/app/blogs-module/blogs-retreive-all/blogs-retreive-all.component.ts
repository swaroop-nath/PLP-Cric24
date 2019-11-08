import { Component, OnInit } from '@angular/core';
import { Blog } from 'src/app/model/blog.model';
import { BlogsService } from '../blogs-service/blogs-service.service';
import { Router } from '@angular/router';
import { BackStack } from 'src/app/cricket-service/back-stack.interface';
import * as $ from 'jquery';
import { AfterBadRoute } from 'src/app/cricket-service/after-bad-route.interface';

@Component({
  selector: 'app-blogs-retreive-all',
  templateUrl: './blogs-retreive-all.component.html',
  styleUrls: ['./blogs-retreive-all.component.css']
})
export class BlogsRetreiveAllComponent implements OnInit, BackStack, AfterBadRoute {

  blogs_view: Blog[]

  constructor(private service:BlogsService, private router:Router) { 
  }

  ngOnInit() {
    this.initialize()
  }

  onBadRouteProvided() {
    this.initialize();
  }

  initialize() {
    this.blogs_view = []

    let viewFilter = this.determineViewFilter();

    this.service.listBlog().subscribe(fetchedBlogs => {
      this.service.blogs_master=fetchedBlogs;
      
      this.service.blogs_master.forEach(blog => {
        if (blog.status == viewFilter)
          this.blogs_view.push(blog)
      })
    });
  }

  determineViewFilter() {
    let loggedInUser = this.service.getUser()

    if(loggedInUser == 'admin')
      return 'Unapproved';
    else if (loggedInUser == 'blogger' || loggedInUser == null)
      return 'Approved';
  }

  initializeComponent() {
    $('#schedules-outlet').animate({height: '150px', width: '100%'}).show()
    $('#archives-outlet').animate({height: '100%', width: '25%'}, 500).show()
    $('#blogs-outlet').animate({height: '100%', width: '70%'})
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
