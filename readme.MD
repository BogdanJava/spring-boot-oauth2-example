## API requests
* Retrieve `access_token`:

       POST /oauth/token?client_id=my-trusted-client&username=user&password=user&grant_type=password
       Hearers: 
       Authorization: Basic Base64(client_id:client_secret)

* Get private resource

       GET /private
       Headers:
       Authorization: Bearer access_token