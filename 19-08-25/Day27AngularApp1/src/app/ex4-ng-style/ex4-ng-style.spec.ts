import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex4NgStyle } from './ex4-ng-style';

describe('Ex4NgStyle', () => {
  let component: Ex4NgStyle;
  let fixture: ComponentFixture<Ex4NgStyle>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex4NgStyle]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex4NgStyle);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
