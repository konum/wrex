![alt tag](https://github.com/konum/wrex/blob/master/header.png?raw=true)

Primefaces, Spring and Hibernate archetype for starting projects. Fast. Minimal configuration and simple code as main objectives. May not be beatiful, but gets the job done. Like Wrex.

For those that haven't played the great Mass Effect games Wrex won't mean a thing. But those who had played the know that Wrex is one of the last Krogan Battlemaster, likes to get things done, fast and simple. It's bloody, it's frightening, it's brutal and everyone loves it. 

One of the more pain in the ass parts in any project, is to get the environment to work, getting all dependecies and stuff working together. So I have decided to get all the stuff together that I learnt building wiklimb.com in one open archetype for everyone to use.

The main technologies are Primefaces, Spring, and Hibernate (using JPA), with maven to do all the building.  All using latest stable versions.

# What does includes?
- A backend project for the domain and service layers, with all Database related stuff in it.
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
Wrex doesn't use DTOs or VO for moving data arount. Domain objets are used directly in the managed beans of the view. Why? Development speed, less code. Maybe it's not a great aproach for big enterprise scale projects, but after a a bunch of months developing like this for wiklimb I found it perfect for smaller projects. No cumberstone code and model changes are trivial to get to the view.  

# The Ugly
No pretty default template or pretty layout to start working. Just a basic template with a Mainlayout an ui:composition. Some examples are still missing like the lightbox or the cluster marker for gmaps.

# The future
Future updates depend on future functions of wiklimb, but expect trully junt testing using in-memory database in the backend project and REST services por exposing data.

Images of wrex by: 
http://gelvuun.deviantart.com/art/Urdnot-Wrex-291676543#
http://dp-films.deviantart.com/art/Urndot-Wrex-the-Krogan-Warlord-325506057
