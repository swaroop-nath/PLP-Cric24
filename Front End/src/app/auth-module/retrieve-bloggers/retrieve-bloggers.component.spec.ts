import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RetrieveBloggersComponent } from './retrieve-bloggers.component';

describe('RetrieveBloggersComponent', () => {
  let component: RetrieveBloggersComponent;
  let fixture: ComponentFixture<RetrieveBloggersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RetrieveBloggersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RetrieveBloggersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
