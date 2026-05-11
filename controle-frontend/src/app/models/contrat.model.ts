export interface ContratAutomobile {
  id?: number;
  dateSouscription: string;
  statut: 'EN_COURS' | 'VALIDE' | 'RESILIE';
  dateValidation?: string;
  montantCotisation: number;
  dureeContrat: number;
  tauxCouverture: number;
  clientId: number;
  numeroImmatriculation: string;
  marqueVehicule: string;
  modeleVehicule: string;
}

export interface ContratHabitation {
  id?: number;
  dateSouscription: string;
  statut: 'EN_COURS' | 'VALIDE' | 'RESILIE';
  dateValidation?: string;
  montantCotisation: number;
  dureeContrat: number;
  tauxCouverture: number;
  clientId: number;
  typeLogement: 'APPARTEMENT' | 'MAISON' | 'LOCAL_COMMERCIAL';
  adresseLogement: string;
  superficie: number;
}

export interface ContratSante {
  id?: number;
  dateSouscription: string;
  statut: 'EN_COURS' | 'VALIDE' | 'RESILIE';
  dateValidation?: string;
  montantCotisation: number;
  dureeContrat: number;
  tauxCouverture: number;
  clientId: number;
  niveauCouverture: 'BASIQUE' | 'INTERMEDIAIRE' | 'PREMIUM';
  nombrePersonnesCouvertes: number;
}
