import { Routes } from '@angular/router';
import { Login } from './components/login/login';
import { Clients } from './components/clients/clients';
import { Contrats } from './components/contrats/contrats';
import { Paiements } from './components/paiements/paiements';
import { authGuard } from './guards/auth.guard';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: Login },
  { path: 'clients', component: Clients, canActivate: [authGuard] },
  { path: 'contrats', component: Contrats, canActivate: [authGuard] },
  { path: 'paiements', component: Paiements, canActivate: [authGuard] }
];
