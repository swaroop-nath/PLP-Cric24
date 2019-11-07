import { Component, OnInit } from '@angular/core';
import { BlogService } from '../blog/blog.service';
import { Blog } from '../model/blog';

@Component({
  selector: 'app-searchblog',
  templateUrl: './searchblog.component.html',
  styleUrls: ['./searchblog.component.css']
})
export class SearchblogComponent implements OnInit {

  blog:Blog[];
  bType:string;
  submitted:boolean=false;

  constructor(private service:BlogService) { 
   
  }

  ngOnInit() {
    this.blog=[];
  }
  searchByCategory(){
     this.service.searchByCategory(this.bType).subscribe(data => 
      {this.blog = data; 
      this.submitted=true});
  }

}
