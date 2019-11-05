import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArchivesModuleComponent } from './archives-module.component';

describe('ArchivesModuleComponent', () => {
  let component: ArchivesModuleComponent;
  let fixture: ComponentFixture<ArchivesModuleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArchivesModuleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArchivesModuleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
