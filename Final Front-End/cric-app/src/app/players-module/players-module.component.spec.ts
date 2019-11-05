import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayersModuleComponent } from './players-module.component';

describe('PlayersModuleComponent', () => {
  let component: PlayersModuleComponent;
  let fixture: ComponentFixture<PlayersModuleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlayersModuleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayersModuleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
