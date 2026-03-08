🛠 Prerequisites
Java JDK 21+

Maven (for dependency management)

IntelliJ IDEA (or any Java-compatible IDE)

📂 Project Structure
Plaintext
├── src/test/java/tests/RecruitmentTest.java  # Main test class & setup logic
├── config.properties                         # Configuration file (Root directory)
└── pom.xml                                   # Project dependencies
⚙️ Setup & Configuration
Create the Config File: Create a file named config.properties in your project root directory (outside the src folder) and add the following:

Properties
baseUrl=https://opensource-demo.orangehrmlive.com
username=Admin
password=admin123
Dependencies: Ensure your pom.xml includes rest-assured, testng, and jackson-databind for proper API and JSON handling.

🚀 How to Run
Via IntelliJ: Open RecruitmentTest.java and click the green "Run" icon next to the @Test method.

Via Maven: Open your terminal in the project root and execute:

Bash
mvn test
