# sonar-trading-challenge
Sonar Trading Programming Challenge

This challenge was written in two projects: icoinJS (Angular for UI) and icoin (Java 8 for backend services).


[icoin - backend project]

How to build it?

Once the source code is downloaded, open a terminal, go to sonar-trading-challenge/icoin directory and type the following command from command line:

 ./mvnw clean package


How to run it?

under the same directory, type the following command from command line:
java -jar target/icoin-0.0.1-SNAPSHOT.jar

Tomcat will be ready and listening for service calls.




[icoinJS - UI project]

How to build it?
Open another terminal, go to sonar-trading-challenge/icoinJS and type the following command from command line:

npm install


How to run it?

Under the same directory, type the following command from command line:
ng serve

The UI application will be ready in localhost:4200

Open a browser and type the following address:
 http://localhost:4200/

The application will display 3 sections:
1. Latest trades
2. Best Asks and Bids
3. Latest local trades (applied algorithm based in zero, up and down tricks)


INFO: 

The application is defaulted to refresh every 5 seconds for the 3 sections.

The configuration parameters are defined in the icoinJS project (UI), in a JSON file: 
sonar-trading-challenge/icoinJS/src/assets/appsettings.json

"xBestAsksAndBids": "10",
"xRecentTrades": "20",
"mConsecutiveUpTricks" : "2",
"nConsecutiveDownTricks" : "2"

where 

xBestAsksAndBids is defaulted to 10,
xRecentTrades is defaulted to 20,
mConsecutiveUpTricks is defaulted to 2
nConsecutiveDownTricks is defaulted to 2




