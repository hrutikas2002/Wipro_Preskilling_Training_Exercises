import { Injectable } from '@angular/core';
import { IVehicle } from './ivehicle';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Vehicleservice {
  constructor(private http: HttpClient) {}

  // GET
  getVehicles(): Observable<IVehicle[]> {
    return this.http.get<IVehicle[]>('http://localhost:3000/vehicles');
  }

  // CREATE
  addVehicle(vehicle: IVehicle): Observable<IVehicle> {
    return this.http.post<IVehicle>('http://localhost:3000/vehicles', vehicle);
  }

  // UPDATE
  updateVehicle(vehicle: IVehicle): Observable<IVehicle> {
    const url = `http://localhost:3000/vehicles/${vehicle.id}`;
    return this.http.put<IVehicle>(url, vehicle);
  }

  //GEt by ID
  getVehicleById(id: number): Observable<IVehicle> {
  return this.http.get<IVehicle>(`http://localhost:3000/vehicles/${id}`);
}

  // DELETE
  deleteVehicle(id: number): Observable<void> {
    const url = `http://localhost:3000/vehicles/${id}`;
    return this.http.delete<void>(url);
  }
}
