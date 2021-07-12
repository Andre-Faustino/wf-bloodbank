import { Component, OnInit } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { NavComponent } from '../nav/nav.component';

@Component({
  selector: 'app-headers',
  templateUrl: './headers.component.html',
  styleUrls: ['./headers.component.css']
})
export class HeadersComponent implements OnInit {

  sidenav!: MatSidenav;

  constructor(public navComp: NavComponent) { }

  ngOnInit(): void {
    
  }
  ngAfterViewInit() {
    this.sidenav = this.navComp.sidenav;
  }

}
