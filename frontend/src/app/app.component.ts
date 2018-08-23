import {Component, OnInit} from "@angular/core"

@Component({
  selector: 'sel-app',
  templateUrl: 'app.component.html'
})
export class AppComponent implements OnInit {

  content = 'Bem vindo ao sistema de Cáculo de Custos com Transporte!'

  constructor() { }

  ngOnInit() {
  }

}
