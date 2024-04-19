import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ScheduleModule, RecurrenceEditorModule , DayService, WeekService, WorkWeekService, MonthService, AgendaService, DragAndDropService, ResizeService } from '@syncfusion/ej2-angular-schedule';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ScheduleModule,
    RecurrenceEditorModule
  ],
  providers: [ DayService, WeekService, WorkWeekService, MonthService, AgendaService, DragAndDropService, ResizeService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
