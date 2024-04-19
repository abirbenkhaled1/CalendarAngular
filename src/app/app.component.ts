import { Component } from '@angular/core';
import { View, EventSettingsModel } from '@syncfusion/ej2-angular-schedule';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-root',
  template: `
    <ejs-schedule height="850" width="1250" [eventSettings]="eventObject" [selectedDate]="setDate" [currentView]="setView"></ejs-schedule>
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  name = 'my-app-reservation';
  public setView: View = 'Month';
  public setDate: Date = new Date(2024, 1, 15);
  public eventObject: any = {  // Cast to 'any' type to bypass TypeScript checking
    dataSource: [{
      EventTitle: "",
      startTime: new Date(2024, 5, 17, 4, 0),
      endTime: new Date(2024, 5, 17, 6, 5),
      nbParticipants: ""  // Include nbParticipants directly in the dataSource
    }],
    fields: {
      subject: { name: 'EventTitle', default: "hello environment", title: "enter title" },
      startTime: { name: 'startTime' },
      endTime: { name: 'endTime' }
    }
  };
}
