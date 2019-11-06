import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Blog } from '../model/blog';
import { Observable } from 'rxjs';

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

  searchByCategory(blogType:string):Observable<Blog[]>{
    return this.http.get<Blog[]>("http://localhost:8183/blog/search/"+blogType);
  }

  approveBlogs(blogId:number){
    return this.http.put<number>("http://localhost:8183/blog/approve/"+blogId,null);
  }

  rejectBlogs(blogId:number){
    return this.http.put<number>("http://localhost:8183/blog/reject/"+blogId,null);
  }
}
