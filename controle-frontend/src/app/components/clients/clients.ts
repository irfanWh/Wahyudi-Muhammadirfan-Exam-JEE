import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ClientService } from '../../services/client.service';
import { Client } from '../../models/client.model';

@Component({
  selector: 'app-clients',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './clients.html',
  styleUrl: './clients.css'
})
export class Clients implements OnInit {
  private clientService = inject(ClientService);

  clients: Client[] = [];

  client: Client = {
    nom: '',
    email: ''
  };

  editMode = false;
  selectedId?: number;

  ngOnInit(): void {
    this.loadClients();
  }

  loadClients(): void {
    this.clientService.getClients().subscribe({
      next: data => this.clients = data,
      error: err => console.error(err)
    });
  }

  saveClient(): void {
    if (this.editMode && this.selectedId) {
      this.clientService.updateClient(this.selectedId, this.client).subscribe(() => {
        this.resetForm();
        this.loadClients();
      });
    } else {
      this.clientService.saveClient(this.client).subscribe(() => {
        this.resetForm();
        this.loadClients();
      });
    }
  }

  editClient(c: Client): void {
    this.client = { ...c };
    this.selectedId = c.id;
    this.editMode = true;
  }

  deleteClient(id?: number): void {
    if (!id) return;

    this.clientService.deleteClient(id).subscribe(() => {
      this.loadClients();
    });
  }

  resetForm(): void {
    this.client = {
      nom: '',
      email: ''
    };
    this.editMode = false;
    this.selectedId = undefined;
  }
}
