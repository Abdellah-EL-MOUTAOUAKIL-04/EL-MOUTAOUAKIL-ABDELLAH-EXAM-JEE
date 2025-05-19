import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

export interface Credit {
  id?: number;
  dateDemande: string;
  statut: string;
  montant: number;
  dureeRemboursement: number;
  tauxInteret: number;
  clientId: number;
}

@Injectable({
  providedIn: 'root'
})
export class CreditService {
  private apiUrl = environment.backendHost + '/credits';

  constructor(private http: HttpClient) {}

  getCredits(): Observable<Credit[]> {
    return this.http.get<Credit[]>(this.apiUrl);
  }

  getCredit(id: number): Observable<Credit> {
    return this.http.get<Credit>(`${this.apiUrl}/${id}`);
  }

  addCredit(credit: Credit): Observable<Credit> {
    return this.http.post<Credit>(this.apiUrl, credit);
  }

  deleteCredit(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  getCreditsByClient(clientId: number): Observable<Credit[]> {
    return this.http.get<Credit[]>(this.apiUrl + '/by-client/' + clientId);
  }
}
