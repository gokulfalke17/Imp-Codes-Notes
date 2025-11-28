package com.nt.coding.challanges;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*class A11 {
	
	public A11() {
		System.out.println("A11.A11()");
	}
	
	public static void m1() {
		System.out.println("m1() method is called");
	}
	
	
}*/

public class Pro03 {

	public static void main(String[] args) {

		/*
		Supplier<A11> a11 = A11::new;
		System.out.println(a11);
		
		Runnable r =  A11::m1;
		System.out.println(r);
		*/

		secondSmallestElement();
		System.out.println();
		strongNumbers();
		System.out.println();
		perfectNumber();
		System.out.println();
		printPerfectNumber();
		System.out.println();
		printPrimeNumbers();
		System.out.println();
		printEvenNums();
		System.out.println();
		squareOfEachElement();
		System.out.println();
		occurenceOfEachElement();
		System.out.println();
		firstNonRepeating();
		System.out.println();
		findFirstGretherThan();
		System.out.println();
		opOfListElements();
		System.out.println();
		sumOfEvenNums();
		System.out.println();
		minMaxElement();
		System.out.println();
		evenSquareSum();
		System.out.println();
		reverseEachWord();
		System.out.println();
		printDuplicates();
		System.out.println();

	}

	private static void printDuplicates() {
		int arr[] = { 1, 2, 2, 2, 3, 4, 4, 5 };

		// using get() method of collection

		/*HashMap<Integer, Integer> duplicates = new LinkedHashMap<>();
		for(int num : arr) {
			if(duplicates.containsKey(num)) {
				duplicates.put(num, duplicates.get(num) + 1);
			}else {
				duplicates.put(num, 1);
			}
		}
		
		for(Map.Entry<Integer, Integer> entry : duplicates.entrySet()) {
			if(entry.getValue() > 1) {
				System.out.println(entry.getKey());
			}
		}*/

		// using getOrDefault() method

		/*HashMap<Integer, Integer> duplicates = new LinkedHashMap<>();
		for(int num : arr) {
			if(duplicates.containsKey(num)) {
				duplicates.put(num, duplicates.getOrDefault(num, 0) + 1);
			}else {
				duplicates.put(num, 1);
			}
		}
		
		for(Map.Entry<Integer, Integer> entry : duplicates.entrySet()) {
			if(entry.getValue() > 1) {
				System.out.println(entry.getKey());
			}
		}*/

		// using hash set java 8
		
		Set<Integer> seen = new LinkedHashSet<Integer>();
		Set<Integer> duplicate = new LinkedHashSet<Integer>();
		Arrays.stream(arr).forEach(ele -> {
			if(!seen.add(ele)) {
				duplicate.add(ele);
			}
		});
		
		//get duplicate elements
		duplicate.forEach(ele -> System.out.print(ele +" "));
		//after removing duplicate elements
		seen.forEach(ele -> System.out.print(ele +" "));
	}

	private static void reverseEachWord() {
		String str = "java is good";
		String reverse = Arrays.stream(str.split(" ")).map(word -> new StringBuilder(word).reverse().toString())
				.collect(Collectors.joining(" "));
		System.out.println("Reverse Each Word :: \n" + reverse);
	}

	private static void evenSquareSum() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Integer evenSquareSum = list.stream().filter(num -> num % 2 == 0).map(num -> num * num).reduce(Integer::sum)
				.orElse(null);
		System.out.println("Even Square Sum :: " + evenSquareSum);
	}

	private static void minMaxElement() {
		List<Integer> list = Arrays.asList(5, 2, 8, 6, 9, 4, 1);
		Integer max = list.stream().reduce(Integer::max).orElse(null);
		System.out.println("Max Element is :: " + max);

		Integer min = list.stream().reduce(Integer::min).orElse(null);
		System.out.println("Min Element is :: " + min);
	}

	private static void sumOfEvenNums() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		Integer sum = list.stream().filter(num -> num % 2 == 0).reduce(Integer::sum).orElse(null);
		System.out.println("Sum of Even Numbers is :: " + sum);
	}

	private static void opOfListElements() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		Integer sum = list.stream().reduce(0, (a, b) -> a + b);
		System.out.println("All Element Sum :: " + sum);

		Integer mul = list.stream().reduce(1, (a, b) -> a * b);
		System.out.println("All Element Multiplication :: " + mul);
	}

	private static void findFirstGretherThan() {
		List<Integer> list = Arrays.asList(3, 7, 12, 5, 11, 20);
		Integer result = list.stream().filter(num -> num > 10).sorted().findFirst().orElse(null);

		System.out.println("First Gretest Element :: " + result);
	}

	private static void firstNonRepeating() {

		// 1

		String str = "swiss";
		/*Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (Character ch : str.toCharArray()) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println("First Non-Repeated Character is :: " + entry.getKey());
				break;
			}
		}*/

		// 2

		Character nonRepeatedChar = str.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(ele -> ele, LinkedHashMap::new, Collectors.counting())).entrySet()
				.stream().filter(ele -> ele.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null);

		System.out.println("First Non-Repeating Character :: " + nonRepeatedChar);
	}

	private static void occurenceOfEachElement() {
		System.out.println();

		// 1

		String str = "engineering";
		Map<Character, Integer> map = new LinkedHashMap<>();
		for (Character ch : str.toCharArray()) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		System.out.println(map);

		// 2

		/*Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (Character ch : str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		
		System.out.println(map);*/

		// 3

		/*LinkedHashMap<Character, Long> map = str.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(ele -> ele, LinkedHashMap::new, Collectors.counting()));
		System.out.println(map);*/
	}

	private static void squareOfEachElement() {
		System.out.println();
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		list.stream().map(num -> num * num).forEach(e -> System.out.print(e + " "));
	}

	private static void printEvenNums() {
		System.out.println();
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		list.stream().filter(num -> num % 2 == 0).forEach(e -> System.out.print(e + " "));
	}

	private static void printPrimeNumbers() {
		System.out.println();
		int limit = 50;
		for (int i = 2; i <= limit; i++) {
			boolean flag = false;
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.print(i + " ");
			}
		}
	}

	private static void printPerfectNumber() {
		System.out.println();
		int limit = 50;

		for (int i = 1; i <= limit; i++) {
			int sum = 0;
			for (int j = 1; j <= i / 2; j++) {
				if (i % j == 0) {
					sum = sum + j;

				}
			}

			if (i == sum) {
				System.out.print(i + " ");
			}

		}
	}

	private static void perfectNumber() {
		int num = 28;
		// 1 + 2 + 4 + 7 + 14 = 28
		int sum = 0;
		for (int i = 1; i <= num / 2; i++) {
			int n = num % i;
			if (n == 0) {
				sum = sum + i;
			}

		}

		if (num == sum) {
			System.out.println(num + " Is Perfect Number...");
		} else {
			System.out.println(num + " Is Not Perfect Number.!");
		}

	}

	private static void strongNumbers() {
		int num = 145;
		int temp = num;
		int sum = 0;

		while (num != 0) {
			int rem = num % 10;
			int fact = 1;
			for (int i = 1; i <= rem; i++) {
				fact = fact * i;
			}

			sum = sum + fact;
			num = num / 10;
		}

		if (temp == sum) {
			System.out.println(temp + " Is Strong Number...");
		} else {
			System.out.println(temp + " Is Not Strong Number.!");
		}
	}

	private static void secondSmallestElement() {
		int arr[] = { 5, 3, 1, 6, 8, 6 };
		int secondSmallest = Arrays.stream(arr).distinct().sorted().skip(1).findFirst().orElse(0);

		if (secondSmallest != 0) {
			System.out.println("Second Smallest Element is :: " + secondSmallest);
		} else {
			System.out.println("Second Smallest Element Not Found in List.!");
		}
	}
}

/*

SQL
---

1. What is DBMS and RDBMS?
	DBMS (Database Management System):
	Software to store and manage data.
	Example: File system, MS Access.
	Data may not have relations.
	RDBMS (Relational Database Management System):
	Stores data in tables (rows and columns).
	Tables are related using keys.
	Examples: MySQL, Oracle, PostgreSQL, SQL Server.


2. What is Primary Key and Foreign Key?
	Primary Key → A column (or set of columns) that uniquely identifies each row in a table.
	Example: EmployeeID in Employee table.	
	Foreign Key → A column that creates a relationship between two tables. It points to a primary key in another table.
	Example: DepartmentID in Employee table refers to Department table.
	
	
3. What are Constraints? Types of Constraints?
	Constraints are rules applied on table columns to maintain data accuracy and integrity.
	Types:
	NOT NULL → Column cannot have NULL value.
	UNIQUE → Column must have unique values.
	PRIMARY KEY → Combines NOT NULL + UNIQUE.
	FOREIGN KEY → Connects one table to another
	CHECK → Limits values in a column (e.g. age > 18).
	DEFAULT → Assigns default value if no value is given.

	
4. What are DDL and DML commands?
	DDL (Data Definition Language): Defines structure of database.
	Examples: CREATE, ALTER, DROP, RENAME, TRUNCATE
	DML (Data Manipulation Language): Deals with data inside tables.
	Examples: INSERT, UPDATE, DELETE


5. Difference: Delete vs Drop vs Truncate
	DELETE → Removes rows (can use WHERE). Data can be rolled back.
	TRUNCATE → Removes all rows quickly (no WHERE). Cannot rollback easily.	
	DROP → Deletes the entire table (structure + data).
	
	
6. Difference between Group By and Order By
	GROUP BY → Groups rows with same values to perform aggregate functions.
	Example: Get total salary by department.
	ORDER BY → Sorts rows in ascending/descending order.


7. Difference between WHERE and HAVING
	WHERE → Filters rows before grouping. Works with normal conditions.
	HAVING → Filters groups after grouping. Works with aggregates.


8. What are Aggregate Functions? Examples
	Aggregate functions operate on multiple rows and return a single value.
	COUNT() → Count rows.
	SUM() → Add values.
	AVG() → Find average.
	MIN() → Get minimum.
	MAX() → Get maximum.


9. What is Indexing? What is a Clustered Index?
	Indexing → Like a book’s index, it is used to helps find data quickly.
	Clustered Index → Data is physically stored in the order of index. Only 1 clustered index per table.
	Non-Clustered Index → Pointer to the data. Many allowed.
	
	
10. What is Normalization? Types of Normal Forms
	Normalization → Organizing tables to reduce redundancy (duplicate data).
	Forms:
	1NF → Each column should have atomic values (no multiple values in a cell).
	2NF → No partial dependency on part of a composite key.
	3NF → No transitive dependency (non-key column should not depend on another non-key column).
	BCNF → Stronger version of 3NF.


11. What is Union and Union All?
	UNION → Combines results of 2 queries and removes duplicates.
	UNION ALL → Combines results but keeps duplicates.


12. Find Second Highest Salary
	SELECT MAX(salary)
	FROM employees
	WHERE salary < (SELECT MAX(salary) FROM employees);


13. What is a View in SQL?
	A virtual table based on a query.
	Stores SQL query, not data.
	Example:
	CREATE VIEW high_salary AS
	SELECT name, salary FROM employees WHERE salary > 50000;


14. How to Convert Text into Date Format?
	SELECT CONVERT(DATE, '2025-01-01', 23);
	-- or in MySQL
	SELECT STR_TO_DATE('01-10-2025', '%d-%m-%Y');


15. What is a Trigger in SQL?
	A stored procedure that runs automatically on events like INSERT, UPDATE, DELETE.
	Example: After inserting a record, automatically update log table.


16. What is a Procedure in SQL?
	A stored program with SQL statements.
	Can accept input/output parameters.
	CREATE PROCEDURE getEmployees()
	BEGIN
	  SELECT * FROM employees;
	END;


17. Difference between CHAR and VARCHAR?
	CHAR(n) → Fixed length (pads with spaces).
	VARCHAR(n) → Variable length (stores only required length).
	
	
18. Difference between SQL and NoSQL?
	SQL → Structured, relational tables.
	NoSQL → Non-relational, flexible (JSON, documents, key-value).


19. Difference between INNER JOIN and OUTER JOIN?
	INNER JOIN → Returns matching rows from both tables.
	LEFT OUTER JOIN → All rows from left + matching rows from right.
	RIGHT OUTER JOIN → All rows from right + matching rows from left.
	FULL OUTER JOIN → All rows from both tables.


20. What is a Self Join?
	Joining a table with itself.
	Example: Find employees and their managers from same Employee table.


21. What is a Subquery?
	A query inside another query.
	Example:
	SELECT name FROM employees WHERE salary = (SELECT MAX(salary) FROM employees);


22. What is a CTE (Common Table Expression)?
	Temporary result set that can be reused in the same query.
	WITH high_salary AS (
	  SELECT * FROM employees WHERE salary > 50000
	)
	SELECT * FROM high_salary;


23. Difference between NVL, ISNULL, and COALESCE?
	NVL → Oracle function to replace NULL.
	ISNULL → SQL Server.
	COALESCE → Works in most RDBMS, can take multiple values.


24. What is a Cursor?
	A pointer to fetch rows one by one.
	Used in stored procedures for row-by-row processing.


25. What are Transactions? What are ACID properties?
	Transaction = Group of SQL statements executed together.
	ACID:
	Atomicity → All or nothing.
	Consistency → Data must remain valid.
	Isolation → Transactions are independent.
	Durability → Data remains after commit.


26. Difference between Delete with WHERE and Truncate?
	DELETE with WHERE → Removes only selected rows.
	TRUNCATE → Removes all rows, faster.


27. What is Difference between Primary Key and Unique Key?
	Primary Key → Only 1 per table, cannot be NULL.
	Unique Key → Many per table, allows 1 NULL.


28. Difference between OLTP and OLAP?
	OLTP → Online Transaction Processing (day-to-day operations).
	OLAP → Online Analytical Processing (data analysis, reports).


29. Difference between Clustered Index and Non-Clustered Index?
	Clustered Index → Data stored physically in order of index.
	Non-Clustered → Separate structure with pointers.


30. What is a Candidate Key?
	A column (or set) that can be a Primary Key.
	Example: EmployeeID, Email (both unique).


31. What is a Composite Key?
	Primary key made of 2+ columns.
	Example: OrderID + ProductID in OrderDetails table.


32. What is Referential Integrity?
	Ensures relationships between tables remain valid.
	Example: Foreign key prevents inserting invalid DepartmentID.


33. What is Denormalization?
	Opposite of normalization.
	Adds redundancy to improve read performance.


34. What is Difference between EXISTS and IN?
	IN → Checks values in a list.
	EXISTS → Checks if subquery returns rows. Faster in some cases.


35. What is Difference between Stored Procedure and Function?
	Procedure → Can return multiple results, cannot be used in SELECT.
	Function → Returns single value, can be used in SELECT.
	
	
36. What is a Materialized View?
	Like a normal view but stores data physically.
	Faster for reporting.


37. What is Difference between OLTP and Data Warehouse?
	OLTP → Real-time transactions.
	Data Warehouse → Historical, analytical data.


38. What is Difference between Schema and Database?
	Database → Collection of schemas and data.
	Schema → Logical grouping of tables, views, etc.


39. What is the Difference between Cross Join and Inner Join?
	Cross Join → Cartesian product (all combinations).
	Inner Join → Matches based on condition.


40. What is Difference between Temporary Table and Table Variable?
	Temporary Table → Stored in tempdb, supports indexes.
	Table Variable → Stored in memory, lighter.


41. What is Difference between Rank(), Dense_Rank(), and Row_Number()?
	ROW_NUMBER() → Unique sequence numbers.
	RANK() → Skips ranks on ties.
	DENSE_RANK() → No gaps in ranking.



*/

//=========================================================================================================================================================================//
//=========================================================================================================================================================================//

/*


1. How to create database automatically in MySQL
=================================================

In application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/jwtdemo?createDatabaseIfNotExist=true&useSSL=true
spring.datasource.username=root
spring.datasource.password=yourpass
spring.jpa.hibernate.ddl-auto=update
	
createDatabaseIfNotExist=true → If DB does not exist, it will be created.


2. spring.jpa.hibernate.ddl-auto options
=========================================
none → no action
validate → validate schema only
update → update schema (safe for dev)
create → creates schema at startup (drops old data)
create-drop → create schema at startup, drop on shutdown


3. JWT in Spring Boot
=====================
JWT = JSON Web Token, used for authentication.
Flow:
User logs in → server generates JWT (access token).
Client stores token → sends it with requests (Authorization: Bearer token).
Server validates token → grants access.


4. Access Token vs Refresh Token
================================
Access token → short-lived, used for API requests.
Refresh token → long-lived, used to get new access token after expiry.

Access Token:
Purpose: Used to access protected resources (e.g., APIs) on behalf of the user.
Lifespan: Short-lived, typically expiring within minutes or a few hours. This minimizes the security risk if the token is compromised.
Usage: Included in API requests, usually in the Authorization header as a bearer token.
Security: If stolen, it can be directly used by an attacker to access resources until it expires. 

Refresh Token:
Purpose: Used to obtain a new access token and potentially a new refresh token after the current access token has expired, without requiring the user to re-authenticate.
Lifespan: Long-lived, often lasting for weeks or months, to provide a more seamless user experience. 
Usage: Sent to the authentication server to request a new access token. It is not used for direct access to resources. 
Security: Less useful to attackers if stolen compared to an access token, as it only allows the generation of new access tokens and is typically stored more securely (e.g., in HTTP-only cookies).



5. @Data vs @Value (Lombok)
===========================
@Data → generates getters, setters, toString, equals, hashCode.
@Value → immutable class (final fields, only getters).


6. @Builder (Lombok)
====================
Provides builder pattern. Example:

@Builder
public class User {
   private String name;
   private int age;
}

User user = User.builder().name("Gokul").age(25).build();

7. Swagger in Spring Boot
=========================
Add dependency:

<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.7.0</version>
</dependency>


Access UI → http://localhost:8080/swagger-ui.html


8. CORS (@CrossOrigin)
======================
Used to allow frontend (React) to call backend (Spring Boot).

Example:

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController { ... }


9. REST vs SOAP
===============
REST: lightweight, JSON, modern projects.
SOAP: XML-based, enterprise legacy systems.

In your React + Spring Boot project → use REST.


10. Fetch API Example
=====================
async function getApi() {
  let response = await fetch("http://localhost:8080/api/users");
  let data = await response.json();
  console.log(data);
}

11. Axios Example
=================
import axios from "axios";

async function getApi() {
  let response = await axios.get("http://localhost:8080/api/users");
  console.log(response.data);
}


12. POST vs PUT vs PATCH
========================
POST → create new resource.
PUT → full update (replace).
PATCH → partial update.


13. 5 Git Commands to Push Code
================================
git init
git add .
git commit -m "message"
git branch -M main
git push -u origin main


14. git branch command
=======================
git branch → list branches.
git branch new-feature → create branch.
git checkout new-feature → switch branch.
git merge new-feature → merge branch.
master renamed to main as default branch.


15. id int -> 01234 vs id string -> 01234
=========================================
INT → leading 0 is ignored (01234 → 1234).
VARCHAR → leading 0 is preserved ("01234" stays).

Use VARCHAR if you want IDs with leading zeros.


16. Move button to left without touching HTML code
==================================================
Use CSS only with position or margin.

Example:
.btn {
   position: relative;
   left: -50px;   
}


17. Position Property
=====================
static → default.
relative → moves relative to normal position.
absolute → positioned relative to nearest parent.
fixed → stays fixed on screen.
sticky → toggles between relative and fixed.


*/
