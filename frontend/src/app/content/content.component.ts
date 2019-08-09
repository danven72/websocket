import { Component, ViewChild, ElementRef } from '@angular/core';
import * as SockJS from 'sockjs-client';
import $ from 'jquery';
import { HelloMessage } from '../model/HelloMessage';
import { Greeting } from '../model/Greeting';

declare var require: any;
var Stomp = require("stompjs/lib/stomp.js").Stomp

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent {
  private title = 'websocket';
  private serverUrl = 'http://localhost:8080/gs-guide-websocket';
  private stompClient;
  private connected = false;
  private messagesList: Greeting[];
  @ViewChild('theName')
  myInput: ElementRef;
  constructor() {
    this.messagesList = [];
  }
  connect() {
    let ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, (frame: any) => {
      that.setConnected(true);
      console.log('Connected: ' + frame);
      that.stompClient.subscribe('/topic/greetings', (greeting) => {
        if (greeting.body) {
          //let g: Greeting = new Greeting(JSON.parse(greeting.body).content);
          let g: Greeting = JSON.parse(greeting.body);
          console.log('************** ' + g.content);
          that.messagesList.push(g);
          this.myInput.nativeElement.value = '';
        }
      });
    });
  }

  setConnected(connected: boolean) {
    console.log('SET connected: ' + connected);
    this.connected = connected;
  }

  isConnected() {
    return this.connected;
  }

  sendName() {
    let theName = this.myInput.nativeElement.value;
    console.log('THE NAME INPUT: ' + theName);
    this.stompClient.send("/app/hello", {}, JSON.stringify(new HelloMessage(theName)));
  }
  
  disconnect() {
    if (this.stompClient !== null) {
      this.stompClient.disconnect();
    }
    this.setConnected(false);
    this.messagesList = [];
    this.myInput.nativeElement.value = '';
    console.log("Disconnected");
  }
}
