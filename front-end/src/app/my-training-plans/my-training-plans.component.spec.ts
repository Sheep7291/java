import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyTrainingPlansComponent } from './my-training-plans.component';

describe('MyTrainingPlansComponent', () => {
  let component: MyTrainingPlansComponent;
  let fixture: ComponentFixture<MyTrainingPlansComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MyTrainingPlansComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MyTrainingPlansComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
