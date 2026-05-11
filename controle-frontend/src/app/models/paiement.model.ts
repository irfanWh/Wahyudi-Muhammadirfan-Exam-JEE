export interface Paiement {
  id?: number;
  datePaiement: string;
  montant: number;
  typePaiement: 'MENSUALITE' | 'PAIEMENT_ANNUEL' | 'PAIEMENT_EXCEPTIONNEL';
  contratId: number;
}
