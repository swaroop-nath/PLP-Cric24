import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BlogsCreateComponent } from './blogs-create.component';

describe('BlogsCreateComponent', () => {
  let component: BlogsCreateComponent;
  let fixture: ComponentFixture<BlogsCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BlogsCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BlogsCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
