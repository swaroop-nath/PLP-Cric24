import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BlogsRetreiveAllComponent } from './blogs-retreive-all.component';

describe('BlogsRetreiveAllComponent', () => {
  let component: BlogsRetreiveAllComponent;
  let fixture: ComponentFixture<BlogsRetreiveAllComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BlogsRetreiveAllComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BlogsRetreiveAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
