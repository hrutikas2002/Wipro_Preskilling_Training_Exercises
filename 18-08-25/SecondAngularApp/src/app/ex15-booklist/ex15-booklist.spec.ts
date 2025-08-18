import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Ex15Booklist } from './ex15-booklist';

describe('Ex15Booklist', () => {
  let component: Ex15Booklist;
  let fixture: ComponentFixture<Ex15Booklist>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Ex15Booklist]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Ex15Booklist);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
