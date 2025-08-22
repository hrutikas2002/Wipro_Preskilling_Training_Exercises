import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex2ngClass } from './ex2ng-class';

describe('Ex2ngClass', () => {
  let component: Ex2ngClass;
  let fixture: ComponentFixture<Ex2ngClass>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex2ngClass]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex2ngClass);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
