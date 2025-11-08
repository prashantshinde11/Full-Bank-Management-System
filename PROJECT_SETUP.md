PROJECT_SETUP.md

1) Database
- Start MySQL server
- Run: mysql -u root -proot < backend/sql/bank_database.sql

2) Backend (Eclipse + Tomcat)
- Open Eclipse -> File -> New -> Dynamic Web Project
- Project name: BankManagementSystem-backend
- Target runtime: Apache Tomcat 9
- Copy the contents of backend/src into the project's src folder (maintaining package structure)
- Copy backend/lib/mysql-connector-java.jar and gson-2.10.1.jar into WEB-INF/lib (you must download them and place here)
- Right-click project -> Run As -> Run on Server (Tomcat 9)

3) Frontend (React)
- cd frontend
- npm install
- npm start
- By default React runs on http://localhost:3000
- Edit src/services/api.js to point to backend: e.g. const BASE = 'http://localhost:8080/BankManagementSystem/api';

4) Common issues
- If you get ClassNotFoundException for MySQL driver, ensure connector jar is in WEB-INF/lib
- CORS: if frontend can't talk to backend, ensure servlet sets Access-Control-Allow-Origin or configure a CORS filter
