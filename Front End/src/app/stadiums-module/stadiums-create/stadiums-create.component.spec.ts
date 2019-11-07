import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StadiumsCreateComponent } from './stadiums-create.component';

describe('StadiumsCreateComponent', () => {
  let component: StadiumsCreateComponent;
  let fixture: ComponentFixture<StadiumsCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StadiumsCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StadiumsCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
