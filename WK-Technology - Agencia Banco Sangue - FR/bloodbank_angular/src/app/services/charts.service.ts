import { QuantityReceptor } from './../models/QuantityReceptor';
import { QuantityReceptorService } from './charts/quantity-receptor.service';
import { AvgAgeByBloodService } from './charts/avg-age-by-blood.service';
import { AvgImcByAge } from './../models/AvgImcByAge';
import { AvgImcByAgeService } from './charts/avg-imc-by-age.service';
import { DonatorsByState } from './../models/DonatorsByState';
import { DonatorsByStateService } from './charts/donators-by-state.service';


import { Injectable } from '@angular/core';
import { OverweightGender } from '../models/OverWeight';


import { OverweightGenderPieService } from './charts/overweight-gender-pie.service';
import { DonatorsService } from './donators.service';
import { AvgAgeByBlood } from '../models/AvgAgeByBlood';

@Injectable({
  providedIn: 'root'
})
export class ChartsService {
  refreshData() {
    this.refreshOveGenderPie();
    this.refreshDonatorStateBar();
    this.refreshAvgImcByAge();
    this.refreshAvgAgeByBlood();
    this.refreshQuantityReceptor();
  }
  

  constructor(private donatorService : DonatorsService, 
    public overweightGenderPieService : OverweightGenderPieService,
    public donatorsByState: DonatorsByStateService,
    public avgImcByAge: AvgImcByAgeService,
    public avgAgeByBlood: AvgAgeByBloodService,
    public quantityReceptor : QuantityReceptorService
    ) { }

  refreshOveGenderPie(){
    this.donatorService.getDonatorsData('/donator/imc/overweight').subscribe(data=>{
      let dataJson : Array<OverweightGender> = data as unknown as Array<OverweightGender>;

      this.overweightGenderPieService.pieChartLabels =  dataJson.map(data => data.gender!);
      this.overweightGenderPieService.pieChartData = dataJson.map(data => data.percentual!);
      
    })
  }

  refreshDonatorStateBar(){
    this.donatorService.getDonatorsData('/donator/states').subscribe(data=>{
      let dataJson : Array<DonatorsByState> = data as unknown as Array<DonatorsByState>;

      dataJson.sort((a, b) => (a.amount! > b.amount!) ? 1 : -1);
      
      this.donatorsByState.barChartLabels = dataJson.map(data => data.state!);
      var charData =  dataJson.map(data => data.amount!)
      this.donatorsByState.barChartData = [
        { data: charData, label: "Amount" }
      ];
    })
  }

  refreshAvgImcByAge(){
    this.donatorService.getDonatorsData('/donator/imc').subscribe(data=>{
      let dataJson : Array<AvgImcByAge> = data as unknown as Array<AvgImcByAge>;
      
      dataJson = dataJson.filter(data => data.imc!= 0.)
      this.avgImcByAge.lineChartLabels = dataJson.map(data => data.ageRange!);
      var charData =  dataJson.map(data => data.imc!)
      this.avgImcByAge.lineChartData = [
        { data: charData, label: "IMC" }
      ];
    })
  }

  refreshAvgAgeByBlood() {
    this.donatorService.getDonatorsData('/donator/age').subscribe(data=>{
      let dataJson : Array<AvgAgeByBlood> = data as unknown as Array<AvgAgeByBlood>;
      
      
      this.avgAgeByBlood.barChartLabels = dataJson.map(data => data.bloodType!);
      var charData =  dataJson.map(data => data.age!)
      this.avgAgeByBlood.barChartData = [
        { data: charData, label: "AGE" }
      ];
    })
  }

  refreshQuantityReceptor() {
    this.donatorService.getDonatorsData('/donator/receptorblood').subscribe(data=>{
      let dataJson : Array<QuantityReceptor> = data as unknown as Array<QuantityReceptor>;
      
      
      this.quantityReceptor.barChartLabels = dataJson.map(data => data.receptorBloodType!);
      var charData =  dataJson.map(data => data.quantity!)
      this.quantityReceptor.barChartData = [
        { data: charData, label: "Donators" }
      ];
    })
  }

}
