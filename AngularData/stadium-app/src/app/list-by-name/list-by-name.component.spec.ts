import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListByNameComponent } from './list-by-name.component';

describe('ListByNameComponent', () => {
  let component: ListByNameComponent;
  let fixture: ComponentFixture<ListByNameComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListByNameComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListByNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
