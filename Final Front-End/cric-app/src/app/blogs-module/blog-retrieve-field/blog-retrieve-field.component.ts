import { Component, OnInit } from '@angular/core';
import { Blog } from 'src/app/model/blog.model';
import { BlogsService } from '../blogs-service/blogs-service.service';

@Component({
  selector: 'app-blog-retrieve-field',
  templateUrl: './blog-retrieve-field.component.html',
  styleUrls: ['./blog-retrieve-field.component.css']
})
export class BlogRetrieveFieldComponent implements OnInit {

  blog:Blog[];
  blogType:string;
  submitted:boolean=false;

  constructor(private service:BlogsService) { 
   
  }

  ngOnInit() {
    this.blog=[];
  }
  searchByCategory(){
     this.service.searchByCategory(this.blogType).subscribe(data => 
      {this.blog = data; 
      this.submitted=true});
  }

}
