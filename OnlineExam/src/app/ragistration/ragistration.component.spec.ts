import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RagistrationComponent } from './ragistration.component';

describe('RagistrationComponent', () => {
  let component: RagistrationComponent;
  let fixture: ComponentFixture<RagistrationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RagistrationComponent]
    });
    fixture = TestBed.createComponent(RagistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
