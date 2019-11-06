import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BlogRetrieveFieldComponent } from './blog-retrieve-field.component';

describe('BlogRetrieveFieldComponent', () => {
  let component: BlogRetrieveFieldComponent;
  let fixture: ComponentFixture<BlogRetrieveFieldComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BlogRetrieveFieldComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BlogRetrieveFieldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
