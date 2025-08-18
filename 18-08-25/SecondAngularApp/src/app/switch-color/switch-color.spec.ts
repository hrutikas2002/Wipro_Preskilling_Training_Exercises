import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SwitchColor } from './switch-color';

describe('SwitchColor', () => {
  let component: SwitchColor;
  let fixture: ComponentFixture<SwitchColor>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SwitchColor]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SwitchColor);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
