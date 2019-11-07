import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StadiumsModuleComponent } from './stadiums-module.component';

describe('StadiumsModuleComponent', () => {
  let component: StadiumsModuleComponent;
  let fixture: ComponentFixture<StadiumsModuleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StadiumsModuleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StadiumsModuleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
