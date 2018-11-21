# it-blueHarvestAccountServices

1.	Download below 3 services
https://github.com/Sasikar/it-eurekaServer
https://github.com/Sasikar/it-blueHarvestTransactionalService
https://github.com/Sasikar/it-blueHarvestAccountServices
2.	Please run below services in following Order ONLY
1st it-eurekaServer
2nd it-blueHarvestTransactionalService
3rd it-blueHarvestAccountServices
3.	Open http://localhost:7777/h2-console
Provide JDBC URL jdbc:h2:mem:testdb
UserName sa
Passwordsa
and then click next 
Screenshot for reference.

 

Once you click next in memory db opens like this

 


For accountService some existing customers are already inserted via src\main\resources\data.sql 

Same data you can observe here in all these 3 tables.
By executing select command. screenshot for same









 

4. Open http://localhost:8888/h2-console

Provide same credentials, screenshot for same

 







Click on connect and fire select query as below

 



4.	API end point testing
Install postman plugin to chrome browser to test endpoint
Import post man collection
Hit below URL in browser. It will automatically opens postman
https://www.getpostman.com/collections/16e2d2bf604df164794a

1st endpoint details:
url: http://localhost:7777/create/currentaccount
method : POST
body:
{
	"customerId":4444,
	"initialCredit":0
}

Screenshot:
 

Once we got success response, hit 
http://localhost:8888/h2-console/ in browser we can see new transaction will be inserted in DB.

2nd endpoint details:

url: localhost:7777/userinfo/3333
 




Additional info:

For services to check running staus.

Hit in browser
http://localhost:8761/


