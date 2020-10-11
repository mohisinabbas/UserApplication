# UserApplication
User Application with Spring Boot and H2  

<B>Swagger UI</B>  
<a>http://localhost:8080/swagger-ui/</a><br/>  
<br/>

<B>Git Repo: </B>
<a>https://github.com/mohisinabbas/UserApplication.git</a>    
<br/>
<br/>
<B>FROM ECLIPSE:</B>  

Open Eclipse IDE --> Git Repositories -->  Clone the Git Repo: https://github.com/mohisinabbas/UserApplication.git  to local path   
import Projects --> Existing maven projects --> specify the local clone repository path    

<b>FROM COMMAND LINE:  </B>
 
git clone https://github.com/mohisinabbas/UserApplication.git  
(go to project directory)  
mvnw install  
mvnw spring-boot:run 

<B>RUNNING</B>

Open H2 console  (jdbc:h2:mem:testdb) - http://localhost:8080/h2-console 

You can find insert  src/main/resources/templates/insertStatements here..run them and you have some data to  

<B>Swagger Docs</B>  
<a>http://localhost:8080/v2/api-docs</a><br/>
  
<br/>
<B>REST EndPoints</B>  
<br/>
<br/>
Welcome Page - http://localhost:8080/  

Get all users - GET http://localhost:8080/user/all  
Get user by id - GET http://localhost:8080/user/{id}  
Get use by phone - GET http://localhost:8080/userByPhone?phone=  

Post user - POST http://localhost:8080/user/  

Update user - PUT http://localhost:8080/user/{userId}  

Delete User - DELETE http://localhost:8080/user/{userId}  



