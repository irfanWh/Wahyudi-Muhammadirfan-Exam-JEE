import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Paiement } from '../models/paiement.model';

@Injectable({ providedIn: 'root' })
export class PaiementService {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/paiements';

  getPaiements() {
    return this.http.get<Paiement[]>(this.apiUrl);
  }

  savePaiement(paiement: Paiement) {
    return this.http.post<Paiement>(this.apiUrl, paiement);
  }

  deletePaiement(id: number) {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
