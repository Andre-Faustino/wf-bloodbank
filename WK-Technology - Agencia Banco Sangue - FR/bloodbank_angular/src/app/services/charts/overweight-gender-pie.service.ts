import { Injectable } from '@angular/core';
import { ChartType, ChartOptions } from 'chart.js';
import { SingleDataSet, Label, monkeyPatchChartJsLegend, monkeyPatchChartJsTooltip } from 'ng2-charts';


@Injectable({
  providedIn: 'root'
})
export class OverweightGenderPieService {

  
  public pieChartOptions: ChartOptions = {
    responsive: true,
  };
  public pieChartLabels: Label[] = [[''], ['']];
  public pieChartData: SingleDataSet = [0,0];
  public pieChartType: ChartType = 'pie';
  public pieChartLegend = true;
  public pieChartPlugins = [];
  pieChartColors = [
    {
      backgroundColor: [ 'rgba(0,0,255,1)','rgba(255,0,0,1)'],
    },
  ];

  constructor() {
    monkeyPatchChartJsTooltip();
    monkeyPatchChartJsLegend();
  }
}
