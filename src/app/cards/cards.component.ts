
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router'; // Import Router

interface Salle {
  _id: string;
  name: string;
  capacity: number; // Assuming a capacity property
  location: string; // Assuming a location property
  amenities: string[]; // Assuming an amenities property as an array of strings
  imageUrl: string; // Assuming an imageUrl property
  description: string; // Assuming a description property
}
@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrl: './cards.component.css'
})
export class CardsComponent {
  constructor(private http: HttpClient, private router: Router) {}
  Salles: Salle[] = [];

  ngOnInit() {
    this.fetchData();
  }

  fetchData() {
    this.http.get<any[]>('http://localhost:3000/Salle')
      .subscribe(data => {
        this.Salles = data;
        console.log('Sales data:', this.Salles);
      });
  }
  showCalendar(id: string) {
    if (id) {
      this.router.navigate(['/calandar', id]);
    } else {
      // Handle missing id case (e.g., show an error message)
    }
  }
}
