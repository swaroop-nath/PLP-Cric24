import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Blog } from '../model/blog';

@Injectable({
  providedIn: 'root'
})
export class BlogService {

  constructor(public http:HttpClient) { }

  addBlog(blog:Blog){
    return this.http.post<Blog>("http://localhost:8183/blog/add",blog);
  }

  listBlog(){
    return this.http.get<Blog[]>("http://localhost:8183/blog");
  }
}
