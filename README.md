Ticket Master Discovery API Application
=======================================

## Classes

The application consists of a single package with three classes:
  - Main
  - RepEvent
  - RepStat

The application will parse the command line arguments:
  - "GET" as a REST command
  - "uk,de,fr,it,es,pt" as a string contatining a list of country codes
  - "/stats?field=city" as a JSON string containing the specific action and parameters

After checking the validity of the arguments, the application will
  - send a request to the TicketMaster server via the Discovery API
  - receive the response for the reuqest as a JSON formatted string
  - apply the specific action (/data, /stats)
  - return the results formatted as a JSON object.
  
### Examples:

```
java -jar TicketMaster.jar GET uk,de,fr,it,es,pt /data > Test01.txt 2>&1 
```

```
java -jar TicketMaster.jar GET uk,de,fr,it,es,pt /data?filter={"city":"Hamburg"} > Test02.txt 2>&1 
```

```
java -jar TicketMaster.jar GET uk,de,fr,it,es,pt /data?filter={"weekday":"Friday"} > Test03.txt 2>&1 
```

```
java -jar TicketMaster.jar GET uk,de,fr,it,es,pt /stats?field="city" > Test04.txt 2>&1 
```

```
java -jar TicketMaster.jar GET uk,de,fr,it,es,pt /stats?field="weekday" > Test05.txt 2>&1 
```

