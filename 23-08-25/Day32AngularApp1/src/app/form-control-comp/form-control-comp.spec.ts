import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormControlComp } from './form-control-comp';

describe('FormControlComp', () => {
  let component: FormControlComp;
  let fixture: ComponentFixture<FormControlComp>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormControlComp]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormControlComp);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
