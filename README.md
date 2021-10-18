# Credorax
Credorax test project

Test application on Spring Boot & REST

Ensure you have "C:\Temp" folder accessible on your laptop or change the corresponding setting in the application.properties file.
To execute the application run the "run.bat", the server will get up on the localhost:8080.
If you want to use Idea open the pom.xml as a project and run the CredoraxApplication class.
Use the "localhost-8080-RetrieveTransaction.url" file to retrieve the transaction with the specified ID (see address line).

To execute the SubmitPayment transaction send the POST request to the address accordingly to the "localhost-8080-SubmitPayment.txt" example.
Having it sent refresh the RetrieveTransaction page above - this transaction will be retrieved.
Now you can add any number of subsequent payment transactions and locate them as necessary.

I was proceeding more or less fast and was not very attentive to the requirement and currently 2 positions are not met:
- Fields are not checked to be mandatory
- Amount is not checked to be integer on common level (and also "positive" check is not implemented)

Also probably some tiny problems possible like missed NPE checks (including warnings left for possible NPEs), etc...
I really don't have so much time for that.

To fully correspond to the requirement it should be much better analyzed at the beginning but e.g.
having missed a point that we need to test on the level of returned errors ability to convert to "Integer" appropriately
it broke existing logic and require some small refactoring. Also addition of existence validation breaks my types already applied.
To reactor to aim these 2 points and return errors as required it should be e.g. changed to be only Strings and validation chains
probably should be refactored to proxy the already acquired result further by the chain. Also the same is needed to check
for the mandatory existence on the required level.

I believe the project source structure brings pretty wide demonstration of architecturing approaches.
Even probably more than necessary (I wanted to show different OOP approaches with this example) that can be treat as excessive
so please don't be so strict in that.

It appears all other requirements are met, other validations, encoding, audit, sanitizing.
The system allows enhancements where necessary e.g. it's possible to easily substitute the storage or the audit services.
Unit test examples are added including Load Test scenario.
