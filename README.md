# How to run this project

1. Download this project to local machine.
2. Create a new database name "pwi" in MYSQL.
3. Import project in Spring STS/Eclipse or IntelliJ IDE by using option "Existing maven project".
4. Change Database "username" and "password" in application.properties file.
4. Open AppInitializer.Java file to dry-run this project because unit tests not added yet.

Note: After first change the property "hibernate.hbm2ddl.auto = create-drop" to "hibernate.hbm2ddl.auto = update" 
      or delete this property from application.properties files and from HibernateConfigurations.Java file.
      If we create database table from any other MySQL tool, then there's no need to add this property and entities can be generated
      from database using eclipse tools. Currently it's better to run this application with "hibernate.hbm2ddl.auto = create-drop" option
      to avoid exception as data will be duplicated on each run. There is no exception handling and other techniques implemented to avoid
      duplicate insertion.
