CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 500; 

CREATE TABLE event (
  idEvent int(11) NOT NULL PRIMARY KEY auto_increment,
  idUser int(11) DEFAULT NULL,
  idLocation int(11) DEFAULT NULL,
  type int(11) DEFAULT NULL,
  text varchar(3000) DEFAULT NULL,
  eventDate timestamp NULL DEFAULT NULL,
  idEventLocationInfo int(11) DEFAULT NULL,
  idParty int(11) DEFAULT NULL
);



CREATE TABLE post (
  idPost int(11) NOT NULL PRIMARY KEY auto_increment,
  title varchar(100) DEFAULT NULL,
  post varchar(2000) DEFAULT NULL,
  postDate datetime NOT NULL
);


CREATE TABLE user (
  idUser int(11) NOT NULL PRIMARY KEY auto_increment,
  name varchar(45) NOT NULL,
  email varchar(65) DEFAULT NULL,
  password varchar(45) NOT NULL,
  lat float DEFAULT NULL,
  lng float DEFAULT NULL,
  role int(11) NOT NULL DEFAULT '0',
  idPicture varchar(20) DEFAULT NULL,
  status int(11) DEFAULT NULL,
  activationKey varchar(45) DEFAULT NULL,
  idUserFB varchar(20) DEFAULT NULL,
  hardestOnsight int(11) DEFAULT NULL,
  hardestFlash int(11) DEFAULT NULL,
  hardestRedpoint int(11) DEFAULT NULL,
  hardestTop int(11) DEFAULT NULL,
  totalClimbed int(11) DEFAULT '0',
  country varchar(5) DEFAULT NULL,
  prefClimb int(11) DEFAULT NULL,
  showRuotes bit(1) DEFAULT 1,
  showWeight bit(1) DEFAULT 1,
  showFavs bit(1) DEFAULT 1,
  recivePrivateMessages bit(1) DEFAULT 0,
  mailModFavZones bit(1) DEFAULT 0,
  mailCommentFavZones bit(1) DEFAULT 0,
  mailPrivateMessage bit(1) DEFAULT 0,
  mailNewsAndUpdates bit(1) DEFAULT 0
);
