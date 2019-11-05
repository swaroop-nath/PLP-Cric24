import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListByCountryComponent } from './list-by-country.component';

describe('ListByCountryComponent', () => {
  let component: ListByCountryComponent;
  let fixture: ComponentFixture<ListByCountryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListByCountryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListByCountryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
