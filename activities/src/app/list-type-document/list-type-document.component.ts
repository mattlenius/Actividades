import { Component, OnInit } from '@angular/core';
import { TypeDocumet } from '../model/type-documet';
import { TypeDocumentService } from '../services/type-document.service';

@Component({
  selector: 'app-list-type-document',
  templateUrl: './list-type-document.component.html',
  styleUrls: ['./list-type-document.component.css']
})
export class ListTypeDocumentComponent implements OnInit {
  public listaTypeDocuments:TypeDocumet[];
  constructor(private TypeDocumentsService:TypeDocumentService) { }

  ngOnInit() {
  }

  getTypeDocuments(){
    this.TypeDocumentsService.getTypeDocument().subscribe(listaTypeDocuments => this.listaTypeDocuments = listaTypeDocuments);
  }

}
