import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex3getNgClass } from './ex3get-ng-class';

describe('Ex3getNgClass', () => {
  let component: Ex3getNgClass;
  let fixture: ComponentFixture<Ex3getNgClass>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex3getNgClass]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex3getNgClass);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
