![alt tag](https://github.com/konum/wrex/blob/master/header.png?raw=true)

Primefaces, Spring and Hibernate archetype for starting projects. Fast. Minimal configuration and simple code as main objectives. May not be beatiful, but gets the job done. Like Wrex.

For those that haven't played the great Mass Effect games Wrex won't mean a thing. But those who had played the know that Wrex is one of the last Krogan Battlemaster, likes to get things done, fast and simple. It's bloody, it's frightening, it's brutal and everyone loves it. 

One of the more pain in the ass parts in any project, is to get the environment to work, getting all dependecies and stuff working together. So I have decided to get all the stuff together that I learnt building wiklimb.com in one open archetype for everyone to use.

The main technologies are Primefaces, Spring and Spring Data , with maven to do all the building.  

![alt tag](https://github.com/konum/wrex/blob/master/screenshot.png?raw=true)


# What does includes?
- A backend project for the data access and service layers, with all Database related stuff in it.
- An api layer with interfaces and DTOS.
- A frontend project for the view and its managedbeans, security, i18n and jetty for runing.
- A basic model for user login, register and update user info.

# The good
- Facebook login example and register
- Jetty ready for fast development
- Forgot password email
- Cluster markes for Primefaces map (see http://ggefaell.blogspot.cl/2015/07/marker-clusterer-in-primefaces-gmap.html)
- Image resize using Scalr library (great open source library that uses Java 2D functions for scaling https://github.com/thebuzzmedia/imgscalr)
- Fileupload ready for PF uploadfile
- QueryDSL for writing queries in the DAO layer
- Liquibase for database changes. 
- Use of Maven SQL plugin for cleaning and loading the local database.
- Junit with inmemory H2 database ready to run.
- Integration Junits to the local database.
- Password encryption
- Async mail sending
- Cron jobs using Spring @Scheduled
- Prettyfaces for permanent URL links and URl rewriting
- Font awsome icons
- Ehcache for Hibernate second level cache
- File service for writing to disk files uploaded by the users.
- Nice js lightbox library included


# The bad
Not really a production ready archetype. More like a fast prototype and to play around with java fw. Poor documentation right now on the goodies and how to make them work. 

# The Ugly
No pretty default template or pretty layout to start working. Just a basic template with a Mainlayout an ui:composition. Some examples are still missing like the lightbox or the cluster marker for gmaps.

# The future
TBD

# Updates
20/05/2018
Begin to work again on wrex. Major FW update, new api layer and DTOs are now used to isolate layers. Added Dozer to map dtos and entities.

03/03/2016
Junit with inmemory H2 database ready to run.


Images of wrex by: 
http://gelvuun.deviantart.com/art/Urdnot-Wrex-291676543#
http://dp-films.deviantart.com/art/Urndot-Wrex-the-Krogan-Warlord-325506057
