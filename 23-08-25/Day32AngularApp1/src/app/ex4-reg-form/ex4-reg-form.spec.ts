import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex4RegForm } from './ex4-reg-form';

describe('Ex4RegForm', () => {
  let component: Ex4RegForm;
  let fixture: ComponentFixture<Ex4RegForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex4RegForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex4RegForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
