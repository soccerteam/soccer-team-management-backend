# soccer-team-management-backend
Backend designed for managing soccer intra team activities


## Databse Configuration
### For postgresql
`spring.datasource.url=jdbc:postgresql://localhost:port/dbname?currentSchema=schemaname`

`spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect`

### For mysql
`spring.datasource.url=jdbc:mysql://localhost:port/dbname?useSSL=false`

`spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect`



## Cookies
Cookies are generated for path `/api`, after authentication is done.
To further develop the apis, the path must begin from `/api`
else write new method in JwtUtils.java to generate cookie for other paths as well

## Running the project
File -> Import -> `Maven` -> Existing maven project
select the project folder and make sure the pom.xml is present at root level in the folder.
Click on `Finish` and the import will start.

Once import is completed, `right click` on `/SoccerTeamManagement/src/main/java/com/pace/soccerteam/SoccerTeamManagementApplication.java`
Go to run and select either as java application/spring boot app.

## API testing

Try accessing TestController apis without authentication and you will receive 401 unauthorized error.

Signup:
http://localhost:port/api/auth/signup

Example
`{
    "username": "abc-user",
    "email": "abc@fmail.com",
    "password": "12345678",
    "role":["user", "admin"]
}`

Signin:
http://localhost:8083/api/auth/signin

Example
`{
    "username": "abc-user",
    "password": "12345678"
}`

Use Postman for testing as it manages the cookies automatically for a given path.
Refer TestController for api testing, try without signin and later with signin.


