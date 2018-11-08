import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {GeneService} from '../gene.service';
import {Subscription} from 'rxjs';
import {MatSort, MatTableDataSource} from '@angular/material';
import {ActivatedRoute} from '@angular/router';
import {map, switchMap} from 'rxjs/operators';
import {GeneVariant} from '../gene';

@Component({
  selector: 'app-gene-details',
  templateUrl: './gene-details.component.html',
  styleUrls: ['./gene-details.component.css']
})
export class GeneDetailsComponent implements OnInit, OnDestroy {

  @ViewChild(MatSort) sort: MatSort;
  dataSource: MatTableDataSource<GeneVariant>;
  _sub: Subscription = new Subscription();
  displayedColumns: string[] = ['geneName', 'ntChange', 'proteinChange', 'alias', 'region',
    'reportedClassification', 'lastEvaluated', 'lastUpdated', 'moreInfo'];
  isLoading: boolean = false;

  constructor(private geneService: GeneService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this._sub.add(
      this.route.queryParamMap
        .pipe(
          map(params => params.get('name')),
          switchMap(geneName => {
            this.isLoading = true;
            this.dataSource = null;
            return this.geneService.searchGeneVariants(geneName);
          })
        )
        .subscribe(data => {
          this.isLoading = false;
          this.dataSource = new MatTableDataSource(data);
          this.dataSource.sort = this.sort;
        }
    ));
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  ngOnDestroy(): void {
    this._sub.unsubscribe();
  }
}
