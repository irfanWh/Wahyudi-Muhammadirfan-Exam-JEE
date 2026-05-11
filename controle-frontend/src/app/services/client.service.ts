import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from '../models/client.model';

@Injectable({ providedIn: 'root' })
export class ClientService {
  private http = inject(HttpClient);
  private apiUrl = 'http://localhost:8080/api/clients';

  getClients() {
    return this.http.get<Client[]>(this.apiUrl);
  }

  saveClient(client: Client) {
    return this.http.post<Client>(this.apiUrl, client);
  }

  updateClient(id: number, client: Client) {
    return this.http.put<Client>(`${this.apiUrl}/${id}`, client);
  }

  deleteClient(id: number) {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
