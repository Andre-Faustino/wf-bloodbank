import { ChartsService } from './../../services/charts.service';
import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';


@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent implements OnInit {

  constructor(private breakpointObserver: BreakpointObserver, public charts : ChartsService) {}

  ngOnInit(): void {
    this.charts.refreshData();
  }

  
}
