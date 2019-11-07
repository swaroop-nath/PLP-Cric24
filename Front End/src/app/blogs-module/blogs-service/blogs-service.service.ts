import { Injectable } from '@angular/core';
import { Blog } from 'src/app/model/blog.model';
import { CricketService } from 'src/app/cricket-service/cricket-service.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BlogsService {

  private BASE_URL = 'http://localhost:8183/blog';
  private ADD_EXT = '/add';
  private FETCH_ALL_EXT = ''; // Please change this
  private FETCH_BY_CAT_EXT = '/search/';
  private APPROVE_EXT = '/approve/';
  private REJECT_EXT = '/reject/';

  constructor(private cricService: CricketService) { }

  addBlog(blog:Blog): Observable<Blog>{
    return this.cricService.persistEntityForEntity<Blog, Blog>(this.BASE_URL + this.ADD_EXT, blog);
  }

  listBlog(): Observable<Blog[]>{
    return this.cricService.fetchAll<Blog>(this.BASE_URL + this.FETCH_ALL_EXT);
  }

  searchByCategory(blogType:string): Observable<Blog[]>{
    return this.cricService.fetchEntityForCondition<Blog[]>(this.BASE_URL + this.FETCH_BY_CAT_EXT + blogType);
  }

  approveBlogs(blogId:number): Observable<number>{
    return this.cricService.updateEntityForEntity<number, void>(this.BASE_URL + this.APPROVE_EXT + blogId, null);
  }

  rejectBlogs(blogId:number): Observable<number>{
    return this.cricService.updateEntityForEntity<number, void>(this.BASE_URL + this.REJECT_EXT + blogId, null);
  }
}
