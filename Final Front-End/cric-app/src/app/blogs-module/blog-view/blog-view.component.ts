import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { BlogsService } from '../blogs-service/blogs-service.service';

@Component({
  selector: 'app-blog-view',
  templateUrl: './blog-view.component.html',
  styleUrls: ['./blog-view.component.css']
})
export class BlogViewComponent implements OnInit {

  constructor(private blogService: BlogsService) { }

  ngOnInit() {
    $(window).on('popstate', (event) => {
      this.blogService.getFromBackStack().initializeComponent()
    });
    this.onStart()
  }

  onStart() {
    // position please!!!
    $('#schedules-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#archives-outlet').animate({height: '0px', width: '0px'}).hide()
    $('#blogs-outlet').animate({height: '100%', width: '100%'}, 500).show()
  }

}
