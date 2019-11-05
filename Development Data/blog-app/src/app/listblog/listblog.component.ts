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

  constructor(private service:BlogService, private route:Router) { }

  ngOnInit() {
  }

  listBlog(){
    this.service.listBlog().subscribe(p => this.blogs=p);
  }
}
