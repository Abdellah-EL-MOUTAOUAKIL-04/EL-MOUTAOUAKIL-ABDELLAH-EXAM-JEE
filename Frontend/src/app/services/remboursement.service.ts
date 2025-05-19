import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

export interface Remboursement {
  id?: number;
  date: string;
  montant: number;
  type: string;
  creditId: number;
}

@Injectable({
  providedIn: 'root'
})
export class RemboursementService {
  private apiUrl = environment.backendHost + '/remboursements';

  constructor(private http: HttpClient) {}

  getRemboursements(): Observable<Remboursement[]> {
    return this.http.get<Remboursement[]>(this.apiUrl);
  }

  addRemboursement(remb: Remboursement): Observable<Remboursement> {
    return this.http.post<Remboursement>(this.apiUrl, remb);
  }

  deleteRemboursement(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  getRemboursementsByCredit(creditId: number): Observable<Remboursement[]> {
    return this.http.get<Remboursement[]>(this.apiUrl + '/by-credit/' + creditId);
  }
}
