import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-keyboard',
  templateUrl: './keyboard.component.html',
  styleUrls: ['./keyboard.component.scss']
})
export class KeyboardComponent implements OnInit {
  @Output() emitOptionSelected: EventEmitter<string> = new EventEmitter<string>();
  
  public options = [
    'A','B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
    'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'   
  ];
 
  constructor() { }

  ngOnInit(): void {
  }

  public sendKey(param: string){
    this.emitOptionSelected.emit(param);
  }

  enableAll(){
    
  }

}
