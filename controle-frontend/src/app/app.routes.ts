import { Routes } from '@angular/router';
import { Clients } from './components/clients/clients';
import { Contrats } from './components/contrats/contrats';
import { Paiements } from './components/paiements/paiements';

export const routes: Routes = [
  { path: '', redirectTo: 'clients', pathMatch: 'full' },
  { path: 'clients', component: Clients },
  { path: 'contrats', component: Contrats },
  { path: 'paiements', component: Paiements }
];
