import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex3Custompipe } from './ex3-custompipe';

describe('Ex3Custompipe', () => {
  let component: Ex3Custompipe;
  let fixture: ComponentFixture<Ex3Custompipe>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex3Custompipe]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex3Custompipe);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
