import {Component, OnDestroy, OnInit} from '@angular/core';
import {GeneService} from '../gene.service';
import {FormControl} from '@angular/forms';
import {of, Subscription} from 'rxjs';
import {debounceTime, distinctUntilChanged, switchMap} from 'rxjs/operators';
import {Router} from '@angular/router';

@Component({
  selector: 'gene-search',
  templateUrl: './gene-search.component.html',
  styleUrls: ['./gene-search.component.css']
})
export class GeneSearchComponent implements OnInit, OnDestroy {

  formControl = new FormControl();
  names: string[] = [];
  _sub: Subscription = new Subscription();

  constructor(private geneService: GeneService,
              private router: Router) { }

  ngOnInit() {
    this._sub.add(
        this.formControl.valueChanges
          .pipe(
            debounceTime(750), // wait for enough time to pass without any other value appearing before emitting
            distinctUntilChanged(),
            switchMap(typedValue => {
              return typedValue.length > 1? this.geneService.searchGeneNames(typedValue) : of([])
            })
          )
          .subscribe(values => {
            this.names = values;
          })
    );
  }

  getGeneVariants(geneName: string){
    this.router.navigate(['/gene'], {queryParams: {'name': geneName}});
  }

  ngOnDestroy(): void {
    this._sub.unsubscribe();
  }
}
