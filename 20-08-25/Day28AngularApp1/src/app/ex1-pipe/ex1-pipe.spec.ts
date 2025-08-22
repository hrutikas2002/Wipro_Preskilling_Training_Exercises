import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex1Pipe } from './ex1-pipe';

describe('Ex1Pipe', () => {
  let component: Ex1Pipe;
  let fixture: ComponentFixture<Ex1Pipe>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex1Pipe]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex1Pipe);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
