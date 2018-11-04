import { Component, OnInit } from '@angular/core';
import { GeneService } from '../gene.service';

@Component({
  selector: 'gene-search',
  templateUrl: './gene-search.component.html',
  styleUrls: ['./gene-search.component.css']
})
export class GeneSearchComponent implements OnInit {

  names: string[];

  constructor(private geneService: GeneService) { }

  ngOnInit() {
    this.geneService.searchGeneNames('br').subscribe(names => this.names = names);
  }

}
