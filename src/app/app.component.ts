import {Component, input} from '@angular/core';
import { EventSettingsModel, View } from '@syncfusion/ej2-angular-schedule';
import { DataManager, UrlAdaptor } from '@syncfusion/ej2-data';
import { HttpClient } from '@angular/common/http';
import {Reservation, ReservationView} from "./Reservation";

// @ts-ignore

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  constructor(private http: HttpClient) { }
  reservations: object[] = [];
  isDataAvailable:boolean = false;



  ngOnInit(): void {

      this.fetchData().then(() =>
        setTimeout(() => {
          this.isDataAvailable = true // Optional value to resolve the promise
        }, 1000));

  }

  public data: object[] = [];



  public currentView: View = 'Month';
  public selectedDate: Date = new Date(2024, 3, 21);

  // public data: DataManager = new DataManager({
  //   url: 'http://localhost:3000/reservations',
  //   adaptor: new UrlAdaptor(),
  //   crossDomain: true
  // })

  async fetchData() {
    this.http.get<any[]>('http://localhost:3000/reservations').subscribe( _data => {
      this.reservations = _data.map(this.transformReservation);
      // this.data = this.data.concat(this.reservations); // Efficient concatenation
       this.data.push(...this.reservations); // Efficient concatenation

      // this.data=[...this.data,...this.reservations]

      // console.log(this.reservations);
      // console.log(this.data);

      // Now 'reservations' array contains transformed data for the scheduler
    });
  }


  transformReservation(reservation: any): ReservationView {
    return {
      Id: reservation._id[1],
      Subject: reservation.name[1],
      StartTime: new Date(reservation.startDate),
      EndTime: new Date(reservation.endDate)
    };
  }


  public eventSettings: EventSettingsModel = {
    dataSource: this.data
  }

}
