# Sela
Restfull with MutiTask calls
Flow: User enter url like :  http://localhost:9020/api/name_of_hotel
   The request goes to some end point ( Spring Controller )  and this end point starts a process that request from all
   urls store in db ( actually json file ) to get the hotel price
   
   The system contains main service which the client/user  should type the usrl address ( i.e http://localhost:9020/api/sheraton)
   and 2 services ( vendor's site that running ) .
   Once a request by user is made, the main service ask each vendor site send back the price hotel , this request run simultaneously .
   If one of the services is down , it throws exception, but without stopping any other service.
   
   I used Json file to simulate DB , so as a 'dev' profile , the json files get read  by the vendor service when it starts to run
   In 'prod' profile there is a mechanism made of spring data which should access real db and gets the requested hotel
  
   There are few tests for testing the buisness logic using mock rest call .
   
  # You can build the main service by running the run runMvn.bat ( build the app first) , than run app using the runMainApp.bat
  #  To build the 2 servrices ( Vendors ) use runMvn.bat and than runVendorApp1.bat . runVendorApp2.bat
  
   
