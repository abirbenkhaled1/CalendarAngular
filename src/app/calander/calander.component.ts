import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {EventSettingsModel, View} from "@syncfusion/ej2-angular-schedule";
import {ReservationView} from "../Reservation";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-calander',
  templateUrl: './calander.component.html',
  styleUrl: './calander.component.css'
})
export class CalanderComponent {

  constructor(private http: HttpClient,private route: ActivatedRoute) { }
  reservations: object[] = [];
  isDataAvailable:boolean = false;

  id: string ="" ;


  ngOnInit(): void {
    // @ts-ignore
    this.id = this.route.snapshot.paramMap.get('id'); // Access route parameter


    this.fetchData().then(() =>
      setTimeout(() => {
        this.isDataAvailable = true // Optional value to resolve the promise
      }, 500));

  }

  public data: object[] = [];



  public currentView: View = 'Month';
  public selectedDate: Date = new Date(2024, 3, 23);

  // public data: DataManager = new DataManager({
  //   url: 'http://localhost:3000/reservations',
  //   adaptor: new UrlAdaptor(),
  //   crossDomain: true
  // })

  // async fetchData() {
  //   this.http.get<any[]>('http://localhost:3000/reservations').subscribe( _data => {
  //     this.reservations = _data.map(this.transformReservation);
  //     // this.data = this.data.concat(this.reservations); // Efficient concatenation
  //     this.data.push(...this.reservations); // Efficient concatenation
  //
  //     // this.data=[...this.data,...this.reservations]
  //
  //     console.log(this.reservations);
  //     console.log(this.data);
  //
  //     // Now 'reservations' array contains transformed data for the scheduler
  //   });
  // }
  async fetchData() {
    this.http.get<any[]>('http://localhost:3000/reservations').subscribe(data => {
      const specificId = this.id; // Replace with the actual reservation ID
      console.log(specificId);
      console.log(data);
      const filteredReservation = data.filter(reservation => reservation.meetingRoomId === specificId);
      // Find by ID
      console.log("id");
      console.log(filteredReservation);
      if (filteredReservation) {
        // this.reservations = this.reservations.concat(this.transformReservation(filteredReservation)); // Transform and add to reservations
        console.log(filteredReservation);
        this.reservations = filteredReservation.map(this.transformReservation);
        console.log(this.reservations );

        // @ts-ignore
        this.data.push(...this.reservations);
        console.log(this.data);
      } else {
        console.warn('Reservation with ID:', specificId, 'not found');
        // Handle case where reservation with ID is not found (optional)
      }
    });
  }


  transformReservation(reservation: any): ReservationView {
    return {
      Id: reservation._id,
      Subject: reservation.name,
      StartTime: new Date(reservation.startDate),
      EndTime: new Date(reservation.endDate)
    };
  }


  public eventSettings: EventSettingsModel = {
    dataSource: this.data
  }

}
