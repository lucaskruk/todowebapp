#Todo list web application
This is my first version of a web application made with  both spring boot
and react, using hibernate, and mysql for persistence.


##Requisites

You would need to have mysql server installed in your machine, as well npm and nodejs.
I am using node version 14.

##Steps for deployment

First execute the sql scripts from sql-scripts folder.

After that, create a user and grant privileges to the database recently created.

Add that user and password to the application.properties file at /src/main/resources

Then you can run gradle bootRun task to start server.

Once server is running, open a terminal and into frontend folder,
execute npm start to start frontend app.

## Next versions would have

I want to add a login page, add testing for both front and back,
integrate npm deployment into gradle scripts.