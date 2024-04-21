import {Injectable} from "@angular/core";
import {Event} from "../models/event";
import {HttpClient} from "@angular/common/http";
import {HandleError} from "./service.helper";
import {Observable, firstValueFrom} from "rxjs";

@Injectable()
export class EventService {
    private eventUrl = "http://localhost:3000/reservations";

    constructor(private http: HttpClient) {}

    get(): Observable<Object>{
        console.log(this.http.get(this.eventUrl)) ;
        return this.http.get(this.eventUrl);
    }

    /*insert(event: Event): Promise<Event> {
        return firstValueFrom(this.http.post(this.eventUrl, event))
            .catch(HandleError);
    }

    update(event: Event): Promise<void> {
        return firstValueFrom(this.http.put(`${this.eventUrl}/${event._id}`, event))
            .catch(HandleError);
    }

    remove(id: number): Promise<void> {
        return firstValueFrom(this.http.delete(`${this.eventUrl}/${id}`))
            .catch(HandleError);
}*/
}