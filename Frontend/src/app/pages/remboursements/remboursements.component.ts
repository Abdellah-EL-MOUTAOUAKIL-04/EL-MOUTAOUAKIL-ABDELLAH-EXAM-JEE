import { Component, OnInit } from '@angular/core';
import { RemboursementService, Remboursement } from '../../services/remboursement.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-remboursements',
  standalone: false,
  templateUrl: './remboursements.component.html',
  styleUrl: './remboursements.component.css'
})
export class RemboursementsComponent implements OnInit {
  remboursements: Remboursement[] = [];
  displayedColumns: string[] = ['id', 'date', 'montant', 'type', 'creditId', 'actions'];
  remboursementForm: FormGroup;

  constructor(private remboursementService: RemboursementService, private fb: FormBuilder) {
    this.remboursementForm = this.fb.group({
      date: ['', Validators.required],
      montant: ['', Validators.required],
      type: ['', Validators.required],
      creditId: ['', Validators.required]
    });
  }

  ngOnInit() {
    this.loadRemboursements();
  }

  loadRemboursements() {
    this.remboursementService.getRemboursements().subscribe(data => {
      console.log("data __--- "+data);
      this.remboursements = data
    });
  }

  addRemboursement() {
    if (this.remboursementForm.valid) {
      this.remboursementService.addRemboursement(this.remboursementForm.value).subscribe(() => {
        this.remboursementForm.reset();
        this.loadRemboursements();
      });
    }
  }

  deleteRemboursement(id: number) {
    this.remboursementService.deleteRemboursement(id).subscribe(() => this.loadRemboursements());
  }
}
