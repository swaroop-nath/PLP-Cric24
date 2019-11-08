import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SchedulesRetrieveComponent } from './schedules-retrieve.component';

describe('SchedulesRetrieveComponent', () => {
  let component: SchedulesRetrieveComponent;
  let fixture: ComponentFixture<SchedulesRetrieveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SchedulesRetrieveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SchedulesRetrieveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
