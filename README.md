# Getting Started

## API endpoint
http://localhost:8080/api/

### create department
POST http://localhost:8080/api/departments
Content-Type: application/json

{
"id": 1,
"name": "high-tech"
}

### create department 2
POST http://localhost:8080/api/departments
Content-Type: application/json

{
"id": 2,
"name": "finance"
}

### update department
PUT http://localhost:8080/api/departments/1
Content-Type: application/json

{
"name": "IT"
}

### create employee
POST http://localhost:8080/api/employees
Content-Type: application/json

{
"name": "essaid",
"salary": 110000,
"department" :{ "id":  2}
}

### create employee 2 with a manager
POST http://localhost:8080/api/employees
Content-Type: application/json

{
"name": "jone",
"salary": 200000,
"department" :{ "id":  1},
"manager" :{ "id":  2}
}

### update employee
PUT http://localhost:8080/api/employees/2
Content-Type: application/json

{
"name": "essaid",
"salary": 220000,
"department" :{ "id":  3}
}

### map employee to a department
PUT http://localhost:8080/api/employees/2
Content-Type: application/json

{
"department" :{ "id":  2}
}

### getting employee by id 1
GET http://localhost:8080/api/employees

### getting departement by id 1
GET http://localhost:8080/api/departements?id=1

### getting All employees by departement id 1
GET http://localhost:8080/api/employees/search/findByDepartmentId?departmentId=0
