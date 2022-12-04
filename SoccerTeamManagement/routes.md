
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


