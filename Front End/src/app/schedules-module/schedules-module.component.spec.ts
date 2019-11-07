import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SchedulesModuleComponent } from './schedules-module.component';

describe('SchedulesModuleComponent', () => {
  let component: SchedulesModuleComponent;
  let fixture: ComponentFixture<SchedulesModuleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SchedulesModuleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SchedulesModuleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
