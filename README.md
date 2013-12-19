![screenshot](https://raw.github.com/andrewpw/surferpedia/3e6646498f56902510a6e65d75f84cbbb9eaefcb/public/images/Surferpedia_snap2.png)

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

Use the new tab to create a new entry for a surfer
You must sign in  to create new surfers or edit their information.
Delete functions are reserved for admin user only.
For the sake of testing purposes, admin login is username: admin@example.com password: password
Each surfer must have a unique slug and that slug can be used to retrieve their page by adding it to the end of the URL
Surfers pages can be accessed by searching for them - if you do not specify any surfer attributes in the search bar,
all surfers are displayed.
Users can access their profile page by clicking on their login email that is displayed on the navigation bar. 
Surfers can be rated by anyone.
Surfers can be "Favorited" by Users. A Favorite Surfer will appear in the User's profile page.
Once you choose a slug you cannot change it.

Modification
------------

To make changes to the system, please create an issue in the master branch for this system.

Credits
-------

Thank you ICS 314, Fall 2013 for support