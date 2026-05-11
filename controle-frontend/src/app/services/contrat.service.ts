import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {
  ContratAutomobile,
  ContratHabitation,
  ContratSante
} from '../models/contrat.model';

@Injectable({ providedIn: 'root' })
export class ContratService {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/contrats';

  getAutomobiles() {
    return this.http.get<ContratAutomobile[]>(`${this.apiUrl}/automobile`);
  }

  saveAutomobile(contrat: ContratAutomobile) {
    return this.http.post<ContratAutomobile>(`${this.apiUrl}/automobile`, contrat);
  }

  getHabitations() {
    return this.http.get<ContratHabitation[]>(`${this.apiUrl}/habitation`);
  }

  saveHabitation(contrat: ContratHabitation) {
    return this.http.post<ContratHabitation>(`${this.apiUrl}/habitation`, contrat);
  }

  getSantes() {
    return this.http.get<ContratSante[]>(`${this.apiUrl}/sante`);
  }

  saveSante(contrat: ContratSante) {
    return this.http.post<ContratSante>(`${this.apiUrl}/sante`, contrat);
  }

  deleteContrat(id: number) {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
