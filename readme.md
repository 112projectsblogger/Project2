# Project2
Project enabling fetching news with use of NewsAPI.

# Installation
You can open console in project's root folder and type in:
```
mvn clean install
```

# Running
For running the application go to the Server folder and enter in console:
```
mvn spring-boot:run
```
Once that is done you can go back to root folder and open Client.

Enter in console
```
ng serve
```
Server side's port is 8080 and Client side's 4200.
You can try to reach server's endpoint by entering in browser
```
http://localhost:8080/news/{country}/{category}/
```
Please refer to Server module's readme file.
You can try to reach Client module by entering in browser
```
http://localhost:4200/