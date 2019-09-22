import { Component, OnInit } from '@angular/core';
import { Client } from '../model/client';
import { ClientService } from '../services/client.service';
import { TypeDocumentService } from '../services/type-document.service';        
import { TypeDocumet } from '../model/type-documet';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
        



@Component({
  selector: 'app-add-client',
  templateUrl: './add-client.component.html',
  styleUrls: ['./add-client.component.css']
})
export class AddClientComponent implements OnInit {
  clients: Client;
  public showMsg:boolean=false;
  public msg:string="";
  typeDocumentsList:TypeDocumet[];
  TypeDocumentService: any;
  addForm: FormGroup;
  constructor(private clientService: ClientService,
              private typeDocumentService:TypeDocumentService,
              private formBuilder: FormBuilder,
              private router: Router ) { }

  ngOnInit() {
    this.getTypeDocuments();
    this.addForm = this.formBuilder.group({
      clieId: ['', Validators.required],
      tdocId: ['', Validators.required],
      nombre: ['', Validators.required],
      direccion: ['', Validators.required],
      telefono: ['', Validators.required],
      email: ['', Validators.required],
      activo: ['', Validators.required]
    });

  }

  getTypeDocuments(){
    this.typeDocumentService.getTypeDocument().subscribe(listaTypeDocuments => this.typeDocumentsList = listaTypeDocuments);
  }

  
  save(){
    this.clientService.createClient(this.addForm.value).subscribe(data=>{
        this.showMsg=true;
        this.msg=data.result;
    },error=>{
        this.showMsg=true;
        this.msg=error.error.message;
    });
  }
}
