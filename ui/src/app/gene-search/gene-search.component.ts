import { Component, OnInit } from '@angular/core';
import { GeneService } from '../gene.service';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';

@Component({
  selector: 'gene-search',
  templateUrl: './gene-search.component.html',
  styleUrls: ['./gene-search.component.css']
})
export class GeneSearchComponent implements OnInit {

  formControl = new FormControl();
  names: string[] = ['BRCA1', 'BRCA2', 'BRRO', 'DOG1'];
  filteredNames: Observable<string[]>;

  constructor(private geneService: GeneService) { }

  // ngOnInit() {
  //   this.geneService.searchGeneNames('br').subscribe(names => this.names = names);
  // }

  ngOnInit() {
    this.filteredNames = this.formControl.valueChanges
      .pipe(
        startWith(''),
        map(value => this._filter(value))
      );
  }

  private _filter(value: string): string[] {
    const filterValue = value.toUpperCase();

    return this.names.filter(option => option.toUpperCase().includes(filterValue));
  }

}
