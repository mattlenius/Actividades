import { Component, OnInit, Inject} from '@angular/core';
import { Client } from '../model/client';
import { ClientService } from '../services/client.service';


@Component({
  selector: 'app-list-client',
  templateUrl: './list-client.component.html',
  styleUrls: ['./list-client.component.css']
})
export class ListClientComponent implements OnInit {

  clients: Client[];
  displayedColumns: string[] = ['clieId', 'tdocId', 'nombre', 'direccion','telefono','email','activo','action'];
  constructor(private clientService: ClientService) { }

  ngOnInit() {
    this.clientService.getClients()
      .subscribe( clients => this.clients = clients);
  }

  deleteClient(client: Client): void {
    this.clientService.deleteClient(client.clieId)
      .subscribe( data => {
        this.clients = this.clients.filter(u => u !== client);
      })
  };



}
