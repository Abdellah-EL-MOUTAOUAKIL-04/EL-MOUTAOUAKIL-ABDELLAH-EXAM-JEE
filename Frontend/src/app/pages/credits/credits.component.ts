import { Component, OnInit } from '@angular/core';
import { CreditService, Credit } from '../../services/credit.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-credits',
  standalone: false,
  templateUrl: './credits.component.html',
  styleUrl: './credits.component.css'
})
export class CreditsComponent implements OnInit {
  credits: Credit[] = [];
  displayedColumns: string[] = ['id', 'dateDemande', 'statut', 'montant', 'dureeRemboursement', 'tauxInteret', 'clientId', 'actions'];
  creditForm: FormGroup;
  filterClientId: number | null = null;

  constructor(private creditService: CreditService, private fb: FormBuilder) {
    this.creditForm = this.fb.group({
      dateDemande: ['', Validators.required],
      statut: ['', Validators.required],
      montant: ['', Validators.required],
      dureeRemboursement: ['', Validators.required],
      tauxInteret: ['', Validators.required],
      clientId: ['', Validators.required]
    });
  }

  ngOnInit() {
    this.loadCredits();
  }

  loadCredits() {
    this.creditService.getCredits().subscribe(data => this.credits = data);
  }

  addCredit() {
    if (this.creditForm.valid) {
      this.creditService.addCredit(this.creditForm.value).subscribe(() => {
        this.creditForm.reset();
        this.loadCredits();
      });
    }
  }

  deleteCredit(id: number) {
    this.creditService.deleteCredit(id).subscribe(() => this.loadCredits());
  }

  findCreditsByClient() {
    if (this.filterClientId) {
      this.creditService.getCreditsByClient(this.filterClientId).subscribe(data => this.credits = data);
    }
  }
}
