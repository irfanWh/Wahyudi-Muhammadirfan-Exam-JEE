import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { PaiementService } from '../../services/paiement.service';

@Component({
  selector: 'app-paiements',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './paiements.html',
  styleUrl: './paiements.css'
})
export class Paiements implements OnInit {

  private paiementService = inject(PaiementService);

  paiements: any[] = [];

  paiement: any = {
    datePaiement: '',
    montant: 0,
    typePaiement: 'MENSUALITE',
    contratId: 1
  };

  ngOnInit(): void {
    this.loadPaiements();
  }

  loadPaiements(): void {

    this.paiementService.getPaiements().subscribe({
      next: data => this.paiements = data,
      error: err => console.error(err)
    });
  }

  savePaiement(): void {

    this.paiementService.savePaiement(this.paiement).subscribe(() => {

      this.resetForm();
      this.loadPaiements();

    });
  }

  deletePaiement(id?: number): void {

    if (!id) return;

    this.paiementService.deletePaiement(id).subscribe(() => {
      this.loadPaiements();
    });
  }

  resetForm(): void {

    this.paiement = {
      datePaiement: '',
      montant: 0,
      typePaiement: 'MENSUALITE',
      contratId: 1
    };
  }
}
