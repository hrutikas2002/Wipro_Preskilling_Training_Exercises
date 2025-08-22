import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { IVehicle } from '../ivehicle';
import { Vehicleservice } from '../vehicleservice';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-vehiclecomp',
  imports: [FormsModule],
  templateUrl: './vehiclecomp.html',
  styleUrl: './vehiclecomp.css',
})
export class Vehiclecomp {
  constructor(private vehicleService: Vehicleservice, private cdr: ChangeDetectorRef) {}

  vehicles: IVehicle[] = [];

  vehicleEdit: IVehicle = {
    id: 0,
    make: '',
    fuelType: '',
    model: '',
    price: 0
  };

  vehicleAdd: IVehicle = {
    id: 0,
    make: '',
    fuelType: '',
    model: '',
    price: 0
  };

  ngOnInit() {
    this.vehicleService.getVehicles().subscribe(
      (data: IVehicle[]) => {
        console.log('Vehicles fetched successfully:', data);
        this.vehicles = data;
        this.cdr.detectChanges();
      },
      (error) => {
        console.error('Error fetching vehicles:', error);
      }
    );
  }

  edit(vehicleId: number) {
    console.log('Edit vehicle with ID:', vehicleId);
    this.vehicleService.getVehicleById(vehicleId).subscribe(
      (vehicle: IVehicle) => {
        console.log('Vehicle details:', vehicle);
        this.vehicleEdit = vehicle;
        this.cdr.detectChanges();
      },
      (error) => {
        console.error('Error fetching vehicle by ID:', error);
      }
    );
  }

  update() {
    console.log('Updating vehicle:', this.vehicleEdit);
    this.vehicleService.updateVehicle(this.vehicleEdit).subscribe(
      (updatedVehicle: IVehicle) => {
        console.log('Vehicle updated successfully:', updatedVehicle);
        const index = this.vehicles.findIndex(v => v.id === updatedVehicle.id);
        if (index !== -1) {
          this.vehicles[index] = updatedVehicle;
        }
        this.vehicleEdit = { id: 0, make: '', fuelType: '', model: '', price: 0 };
        this.cdr.detectChanges();
        this.ngOnInit();
      },
      (error) => {
        console.error('Error updating vehicle:', error);
      }
    );
  }

  delete(vehicleId: number) {
    this.vehicleService.deleteVehicle(vehicleId).subscribe(
      () => {
        console.log('Vehicle deleted successfully:', vehicleId);
        this.vehicles = this.vehicles.filter(v => v.id !== vehicleId);
        this.cdr.detectChanges();
        this.ngOnInit();
      },
      (error) => {
        console.error('Error deleting vehicle:', error);
      }
    );
  }

  save() {
    console.log('Saving vehicle:', this.vehicleAdd);
    this.vehicleService.addVehicle(this.vehicleAdd).subscribe(
      (newVehicle: IVehicle) => {
        console.log('Vehicle saved successfully:', newVehicle);
        this.vehicles.push(newVehicle);
        this.vehicleAdd = { id: 0, make: '', fuelType: '', model: '', price: 0 };
        this.cdr.detectChanges();
      },
      (error) => {
        console.error('Error saving vehicle:', error);
      }
    );
  }
}
