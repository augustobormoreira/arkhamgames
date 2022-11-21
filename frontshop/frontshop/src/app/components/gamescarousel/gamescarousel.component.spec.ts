import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GamescarouselComponent } from './gamescarousel.component';

describe('GamescarouselComponent', () => {
  let component: GamescarouselComponent;
  let fixture: ComponentFixture<GamescarouselComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GamescarouselComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GamescarouselComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
