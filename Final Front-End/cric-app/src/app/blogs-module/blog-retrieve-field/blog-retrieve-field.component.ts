import { Component, OnInit } from '@angular/core';
import { Blog } from 'src/app/model/blog.model';
import { BlogsService } from '../blogs-service/blogs-service.service';
import * as $ from 'jquery';
import { Router } from '@angular/router';

@Component({
  selector: 'app-blog-retrieve-field',
  templateUrl: './blog-retrieve-field.component.html',
  styleUrls: ['./blog-retrieve-field.component.css']
})
export class BlogRetrieveFieldComponent implements OnInit {

  blogs:Blog[];
  blogType:string;
  submitted:boolean=false;

  constructor(private service:BlogsService, private router: Router) {}

  ngOnInit() {
    this.blogs = [];

    this.onStart();

    $(window).on('popstate', (event) => {
      $('#schedules-outlet').animate({height: '150px', width: '100%'}).show()
      $('#archives-outlet').animate({height: '100%', width: '25%'}).show()
      $('#blogs-outlet').animate({height: '100%', width: '70%'}).show()
    });
  }

  initializeComponent() {
  }

  onStart() {
    // position please!!!
    $('#schedules-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#archives-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#blogs-outlet').animate({height: '100%', width: '100%'}, 500).show()
  }

  searchByCategory(){
     this.service.searchByCategory(this.blogType).subscribe(data => {
      this.blogs = data; 
      this.submitted=true;
    });
  }

  viewBlog(blog: Blog) {
    this.service.transitBlog = blog;
    this.service.addToBackStack(this)
    this.router.navigate([{outlets: {'blogs': ['blog-view']}}], {relativeTo: this.service.getParentRoute()});
  }

}
