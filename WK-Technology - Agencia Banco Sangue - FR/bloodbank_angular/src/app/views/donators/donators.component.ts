import { DonatorsService } from './../../services/donators.service';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ResponseMessage } from 'src/app/models/ResponseMessage';

@Component({
  selector: 'app-donators',
  templateUrl: './donators.component.html',
  styleUrls: ['./donators.component.css']
})
export class DonatorsComponent implements OnInit {

  loading$ = this.donatorService.loading$;
  _bCanUpload = true;

  constructor(private snackBar: MatSnackBar, private donatorService: DonatorsService) { }

  ngOnInit(): void {
   
  }

  file: File | null = null

  async onFileInput(files: FileList | null): Promise<void> {
    if (files) {
      this.file = files.item(0)
    }
    if (this.file?.type != "application/json") {
      this.snackBar.open('Not A json file', 'Undo', { duration: 2000 });
      return
    }
    if (this.file != null) {
      const json : JSON = JSON.parse(await this.file.text());
      this.progressStart();

      this.donatorService.postDonatorsBatch(json).subscribe(data => {
        this.progressFinished();
        let response : ResponseMessage = data as ResponseMessage;
        this.snackBar.open('Data Received! ' + response.message, 'Undo', { duration: 5000 });
      }, error => {
        this.progressFinished();
        this.snackBar.open('Something wrong happened', 'Undo', { duration: 2000 });
      }
      )
    }

    this.file = null;
  }

  progressStart(){
    this.donatorService.loader.show();
    this._bCanUpload = false;
  }
  progressFinished(){
    this.donatorService.loader.hide();
    this._bCanUpload = true;
  }

}





