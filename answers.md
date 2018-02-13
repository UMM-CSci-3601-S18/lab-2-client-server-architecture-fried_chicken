1) A .gitignore file specifies intentionally untracked files that Git should ignore, .gitignore tells git which files (or patterns) it should ignore. 
It's usually used to avoid committing transient files from your working directory that aren't useful to other collaborators, 
such as compilation products, temporary files IDEs create, etc.

2) We use the Gradle build tool to build and run our web application. 
Gradle is a powerful system for defining, managing, and running tasks that allows us to easily build and test our full web application.
When your project contains a build.gradle file in the repository root, Travis CI builds your project with Gradle. 
So, build.gradle is to let Travis CI build your project with Gradle.

3) Travis Cl is a Continuous Integration tool that performs builds of your project every time you push to GitHub. 
This is very helpful, as it makes keeping track of your testing over the lifetime of a project very easy. 
Having a build/test history makes it easy to find where, or when, your project broke, 
which makes it a lot easier to figure out why it broke and get it fixed and building successfully again. 

4) The main building block of a Spark application is a set of routes. 
A route is made up of three simple pieces:
A verb (get, post, put, delete, head, trace, connect, options),
A path (/hello, /users/:name),
A callback (request, response) -> { }.
Routes are matched in the order they are defined. 
The first route that matches the request is invoked.

5) The umm3601.Server is used for setting up the server that will listen into a port to see what the see what the clients sends. 
It will process what the client sends and answer back through the port.
The controller is used to manage requests about info about users.
The page users: Going to the user page brings the user to a html page that has search box and a button called "Get All Users".
The page api/users: This brings us to a page which contains all of the users.
The page api/users?age=25: This brings us to a page that contains all of he users whose age is 25.
The page api/users/588935f5de613130e931ffd5: This brings us to a specific user with the id 588935f5de613130e931ffd5.

6) The contents in the public folder contains the front end part of the project. So this is what the clients "see". It contains the css, html, and javascript files.
Each html file is for each different page. The index.html file is like the "main" page, this is the first thing you see when you go to the localhost, so it has
the contents of the main page. The users.html is the html file that display the page of users, so it has the contents on the page of users. 
(And ofcourse we will need to add one for todo)

7) So when the age is inserted in the box in the html file, and then click it, you will call a function in the html file, which tells it that the button has been
clicked. This function gets the "element" that has been inserted, and calls the function getAllUsersByAge in the javascript file. Then the function getAlUSersByAge
sends a request to the server that asks to filter all the users by the given age. Then the server calls the controller, which in turns calls the database that filters
the users by the given age. This returns a bunch of json, which is then dumped on the webpage. 
So, the age is read from the webpage, send to the javascript files, which sends a request to the server, the server gets the json, and the json is returned to the
javascript, which dumps it on the webpage.

8) You can find the client side javascript file in  /public/javascript and is names users.js. 
The files in which the javascript file is used is in the users.html. (Eventually in todo.html)
 
