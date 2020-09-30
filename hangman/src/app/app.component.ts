import { Component } from '@angular/core';
import { WordGeneratorService } from './word-generator.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent { 

  private receivedWord: string;
  public letters:  Array<{found: boolean, value: string}>;

  public points: number = 0;
  public mistakes: number = 0;  
  private maxMistakes: number = 5;

  constructor(private wordGeneratorService: WordGeneratorService){}

  public ngOnInit() {
    this.callAPI();
  }

  /**
   * Call the Java api and init the game
   */
  private callAPI(){
    // call java API to get one random word from the XML dictionary
    this.wordGeneratorService.getWord().subscribe(
      (data) => {
        this.receivedWord = data.word;

        //create the result
        this.letters = new Array<{found: boolean, value: string}>();

        //populate letters from word
        for(let i = 0 ; i < this.receivedWord.length; i++){
          this.letters.push( {found:false, value:this.receivedWord.substr(i, 1) });
        }
      },
      (error) => console.log("error:" + error)
    );
  }

  /**
   * verity if a letter exists on the word
   * @param selectedLetter 
   */
  public hasLetterOnWord(selectedLetter : string){ 
    if(!this.hasGameEnded()){

      if(this.receivedWord.includes(selectedLetter)){
        
        // search letter on list
        for(let i = 0 ; i < this.receivedWord.length; i++){          
          if(selectedLetter === this.letters[i].value){            
            this.letters[i].found = true;

            this.points++; 
          }
        }
      } else { 
        // add 1 to mistake counter
        this.mistakes++;
      }
    }
  }

  public hasGameEnded(): boolean{
    return (this.rulePlayerLose() || this.rulePlayerWon());
  }

  public rulePlayerLose(): boolean{
    return this.mistakes > this.maxMistakes;
  }

  public rulePlayerWon(): boolean{
    // check if there are any word that is not found
    for(let i = 0 ; i < this.receivedWord.length; i++){          
      if(!this.letters[i].found){            
        return false;
      }
    }
    return true;
  }

  public refreshScreen(){
    window.location.reload()
  }
   
}