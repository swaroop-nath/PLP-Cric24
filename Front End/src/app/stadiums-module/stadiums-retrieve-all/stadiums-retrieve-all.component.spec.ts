import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StadiumsRetrieveAllComponent } from './stadiums-retrieve-all.component';

describe('StadiumsRetrieveAllComponent', () => {
  let component: StadiumsRetrieveAllComponent;
  let fixture: ComponentFixture<StadiumsRetrieveAllComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StadiumsRetrieveAllComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StadiumsRetrieveAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
