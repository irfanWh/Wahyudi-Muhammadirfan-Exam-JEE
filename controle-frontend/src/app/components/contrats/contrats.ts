import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { ContratService } from '../../services/contrat.service';

@Component({
  selector: 'app-contrats',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './contrats.html',
  styleUrl: './contrats.css'
})
export class Contrats implements OnInit {

  private contratService = inject(ContratService);

  contrats: any[] = [];

  selectedType = 'automobile';

  contrat: any = {
    dateSouscription: '',
    statut: 'EN_COURS',
    montantCotisation: 0,
    dureeContrat: 12,
    tauxCouverture: 80,
    clientId: 1,

    numeroImmatriculation: '',
    marqueVehicule: '',
    modeleVehicule: ''
  };

  ngOnInit(): void {
    this.loadContrats();
  }

  loadContrats(): void {

    if (this.selectedType === 'automobile') {
      this.contratService.getAutomobiles().subscribe({
        next: data => this.contrats = data,
        error: err => console.error(err)
      });
    }

    else if (this.selectedType === 'habitation') {
      this.contratService.getHabitations().subscribe({
        next: data => this.contrats = data,
        error: err => console.error(err)
      });
    }

    else {
      this.contratService.getSantes().subscribe({
        next: data => this.contrats = data,
        error: err => console.error(err)
      });
    }
  }

  onTypeChange(): void {
    this.contrats = [];
    this.loadContrats();
  }

  saveContrat(): void {

    if (this.selectedType === 'automobile') {

      this.contratService.saveAutomobile(this.contrat).subscribe(() => {
        this.resetForm();
        this.loadContrats();
      });

    }

    else if (this.selectedType === 'habitation') {

      this.contratService.saveHabitation(this.contrat).subscribe(() => {
        this.resetForm();
        this.loadContrats();
      });

    }

    else {

      this.contratService.saveSante(this.contrat).subscribe(() => {
        this.resetForm();
        this.loadContrats();
      });

    }
  }

  deleteContrat(id?: number): void {

    if (!id) return;

    this.contratService.deleteContrat(id).subscribe(() => {
      this.loadContrats();
    });
  }

  resetForm(): void {

    this.contrat = {
      dateSouscription: '',
      statut: 'EN_COURS',
      montantCotisation: 0,
      dureeContrat: 12,
      tauxCouverture: 80,
      clientId: 1,

      numeroImmatriculation: '',
      marqueVehicule: '',
      modeleVehicule: ''
    };
  }
}
