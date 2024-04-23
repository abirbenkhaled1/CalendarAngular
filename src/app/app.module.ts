import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ScheduleModule, RecurrenceEditorModule , DayService, WeekService, WorkWeekService, MonthService, AgendaService, DragAndDropService, ResizeService } from '@syncfusion/ej2-angular-schedule';
import { HttpClientModule } from '@angular/common/http';
import { CardsComponent } from './cards/cards.component';
import { CalanderComponent } from './calander/calander.component';

@NgModule({
  declarations: [
    AppComponent,
    CardsComponent,
    CalanderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ScheduleModule,
    RecurrenceEditorModule,
    HttpClientModule
  ],
  providers: [ DayService, WeekService, WorkWeekService, MonthService, AgendaService, DragAndDropService, ResizeService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
