export interface Reservation {
  meetingRoomId: string;
  userId: string;
  Subject: string; // Renamed from "name"
  StartTime: Date; // Converted from "startDate" string
  EndTime: Date; // Converted from "endDate" string
  nbParticipants: number;
  Id: string;
  __v?: number;
  IsAllDay?: boolean; // Optional property for all-day events
// Optional property for compatibility
}
export interface ReservationView {
  Id: string;
  Subject: string; // Renamed from "name"
  StartTime: Date; // Converted from "startDate" string
  EndTime: Date; // Converted from "endDate" string

// Optional property for compatibility
}
