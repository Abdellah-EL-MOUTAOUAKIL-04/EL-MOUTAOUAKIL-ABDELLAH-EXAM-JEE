import { Component, OnInit } from '@angular/core';
import { ClientService, Client } from '../../services/client.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-clients',
  standalone: false,
  templateUrl: './clients.component.html',
  styleUrl: './clients.component.css'
})
export class ClientsComponent implements OnInit {
  clients: Client[] = [];
  displayedColumns: string[] = ['id', 'nom', 'email', 'actions'];
  clientForm: FormGroup;

  constructor(private clientService: ClientService, private fb: FormBuilder) {
    this.clientForm = this.fb.group({
      nom: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]]
    });
  }

  ngOnInit() {
    this.loadClients();
  }

  loadClients() {
    this.clientService.getClients().subscribe(data => this.clients = data);
  }

  addClient() {
    if (this.clientForm.valid) {
      this.clientService.addClient(this.clientForm.value).subscribe(() => {
        this.clientForm.reset();
        this.loadClients();
      });
    }
  }

  deleteClient(id: number) {
    this.clientService.deleteClient(id).subscribe(() => this.loadClients());
  }
}
