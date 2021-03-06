import { Injectable } from '@angular/core';
import { Blog } from 'src/app/model/blog.model';
import { CricketService } from 'src/app/cricket-service/cricket-service.service';
import { Observable } from 'rxjs';
import { BackStack } from 'src/app/cricket-service/back-stack.interface';
import { AuthService } from 'src/app/auth-module/auth-service/auth-service.service';
import { AfterBadRoute } from 'src/app/cricket-service/after-bad-route.interface';

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

  transitBlog: Blog;
  blogs_master: Blog[];

  constructor(private cricService: CricketService, private authService: AuthService) { }

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

  getParentRoute() {
    return this.cricService.parentRoute;
  }

  getFromBackStack() {
    return this.cricService.componentBackStack.pop();
  }

  addToBackStack(component: BackStack) {
    return this.cricService.componentBackStack.push(component)
  }

  addToHomeStack(component: AfterBadRoute) {
    return this.cricService.homeComponents.push(component)
  }

  getUser(): string {
    return this.authService.isUserLoggedIn();
  }
}
