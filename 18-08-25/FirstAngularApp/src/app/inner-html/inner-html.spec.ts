import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InnerHtml } from './inner-html';

describe('InnerHtml', () => {
  let component: InnerHtml;
  let fixture: ComponentFixture<InnerHtml>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InnerHtml]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InnerHtml);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
