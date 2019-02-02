***************************************************************************************
	README - API Automation Framework Using RestAssured, TestNG, Extent Report
***************************************************************************************
  
  #GIT Repository :- 

	* The following repository is a complete package to do testing assertions or validations on the REST API hosted on "https://api.tmsandbox.co.nz".
	* The Automation framework for this validation is using Java as programming language, RestAssured Libraries for REST API Test Automation, Maven as build tool,
	  Junit as testing automation framework and Serenity Report for Reporting.
	* This Framework is designed to cater every requirements for Service/API Testing.
	* The Framework has the capability to customize the required test cases to be entered in testng.xml and execute
	* RestAssured Libraries has its own Log generation capability so used in the solution.
	
	
  #Setup :- 
  
  [[Running From Eclipse]] :
	
	* Install Java
	* Set JAVA_HOME variable for the path of jdk (eg. JAVA_HOME="C:\Program Files\Java\jdk1.8.0_92")
	* Append Path variable as %PATH%;%JAVA_HOME%/bin
	* Download Maven (e.g Apache Maven 3.3.9)
	* Set M2_HOME system environment variable as (eg. M2_HOME="C:\Program Files\Apache\apache-maven-3.3.9"
	* Configure Java and Maven
	* Download Eclipse (eg. Eclipse Neon 2)
	* Import the project as existing Maven Project
	* Configure the the Java Build Path and Set the Execution Environment as "jdk1.8.0_92"
	* Select Run -> Run Configurations
	* Select Maven Build
	* Right Click on Maven Build and Click New
	* Set Maven Goals as "clean verify serenity:aggregate"
	* Click on Workspace and select the Base Directory
	* Click on Apply and Run
	
	[[Running From Command Prompt]] :
	
	* Clone the current git repository into local path
	* The Source Files are placed in "<Project Path>\src\test\java\com\apitest\assignment"
	* Reusable Methods are placed in "<Project Path>\src\test\java\com\restapi\utils\ReusableMethods.java"
	* Navigate to the project directory (eg. ..\RestAssured\RESTAPIAssignment)
	* Run the test by type and execute the command  "mvn clean verify serenity:aggregate -Dtest=APITestAutomation.java" to download all the related dependencies and jars and execute.
	* Navigate to the directory (..\RestAssured\RESTAPIAssignment\target\serenity\site\)
	* You can see aggregate report index.html as well as individual reports