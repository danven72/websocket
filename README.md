# websocket
Websocket Example And Kafka integration: this is a small project tha show how to implement a Web Socket comunication using springboot and a Front end
in Angular 7. SockJS and Stomp are used. There is an html page (index.html) too in backend project too, where it is used JQuery to connect
to the backend.
URL Used:
  - https://spring.io/guides/gs/messaging-stomp-websocket/
  - https://medium.com/oril/spring-boot-websockets-angular-5-f2f4b1c14cee
 
 backend: Java 8 - Springboot 2
 Front End: Angular 7
 The project was tested with kafka_2.11-2.2.0 installed. Kafka must be installed and running.
 
 Instructions:
 - git clone https://github.com/danven72/websocket.git
  - backend:  
             - import project on sts/eclipse as Maven project
             - start zookeper and kafka (port 9092, but for change look at application.yml
             - start springboot application. Open browser at localhost:8080 to see client/jquery page
             When start springbootapplication the topic websocket is created on kafka
  - frontend:
             - run npm install for dependency
             - run ng serve.Open browser at localost:4200
  
  By clicking on "connect" button the page is connected to websocket open from the server. If you write a text on field and click 
  on "send" button it is executed the greeting() method on GreetingController. You will see the message in the page after a delay.
  If you send a message on the topic(you can use the command:
  kafka-console-producer.bat --broker-list localhost:9092 --topic websocket
  and the in console send a message lie this: {"name" : "OBI-WAN KENOBI"}
  
              
