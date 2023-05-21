import {Component, Inject} from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'info-dialog',
  templateUrl: '../html/info-dialog.html'
})
export class InfoDialog {
  constructor(
    public dialogRef: MatDialogRef<InfoDialog>
  ) {}

  onClose(): void {
    this.dialogRef.close();
  }
}
