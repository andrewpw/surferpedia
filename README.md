![screenshot](https://raw.github.com/andrewpw/surferpedia/master/public/images/homepage_example.png)

Overview
--------

A [Play Application](http://playframework.com) that provides an encyclopedia of surfers.

Functions
- Add, Edit and Delete Functions for each Surfer.


Installation
------------

Download the zip file, unzip and cd into the file. Invoke the `play` command and execute the `run` command to see the 
application at http://localhost9000

To run Unit Tests, invoke the `test` command from the Play console.

Usage
-----

Search through surfers with the search widget. 
Display all surfers by choosing all types and all countries, then press the magnifying glass icon. 
Surfers are displayed on multiple pages.
Click login to login to an existing account or create a new account. 
For the sake of testing purposes, admin login is username: admin@example.com password: password  
Users can access their profile page by clicking on their login email that is displayed on the navigation bar. 
Surfers can be rated only by signed in users and only once per user. 
You can delete your previous surfer rating through your profile page and then re-rate the surfer. 
Surfers can be "Favorited" by Users. A Favorite Surfer will appear in the User's profile page. 
Use the New Surfer tab to create a new entry for a surfer. 
Only signed in users may create a new surfer or edit existing surfers. 
Once you choose a slug for a surfer you cannot change it.
Delete functions are reserved for admin user only.

Modification
------------

To make changes to the system, please create an issue in the master branch for this system.

Credits
-------

Thank you ICS 314, Fall 2013 for support