import { Injectable } from '@angular/core';
import { ChartDataSets, ChartOptions, ChartType } from 'chart.js';
import { Color, Label } from 'ng2-charts';

@Injectable({
  providedIn: 'root'
})
export class AvgImcByAgeService {

  constructor() { }

  lineChartData: ChartDataSets[] = [
    { data: [], label: '' }
  ];

  lineChartLabels: Label[] = [''];

  lineChartOptions = {
    responsive: true,
  };

  lineChartColors: Color[] = [
    {
      borderColor: 'black',
      backgroundColor: 'rgba(255,0,0,0.75)',
    },
  ];

  lineChartLegend = false;
  lineChartPlugins = [];
  lineChartType : ChartType = 'line';
}
