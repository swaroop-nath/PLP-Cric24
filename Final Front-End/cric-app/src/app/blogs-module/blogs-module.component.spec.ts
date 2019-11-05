import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BlogsModuleComponent } from './blogs-module.component';

describe('BlogsModuleComponent', () => {
  let component: BlogsModuleComponent;
  let fixture: ComponentFixture<BlogsModuleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BlogsModuleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BlogsModuleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
