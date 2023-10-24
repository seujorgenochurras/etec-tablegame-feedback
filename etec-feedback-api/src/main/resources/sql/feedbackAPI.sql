drop database if exists feedback_api;
create database if not exists feedback_api;
use feedback_api;


create table mapImage(
id int not null primary key auto_increment,
imageData blob not null,
imageName varchar(200) not null,
imageType varchar(20) not null
);

create table logoImage(
id int not null primary key auto_increment,
imageData blob not null,
imageName varchar(200) not null,
imageType varchar(20) not null

);


create table boardgame(
id int not null primary key auto_increment,
logoImageFK int not null,
mapImageFK int not null,
name varchar(100) not null,

foreign key (logoImageFK) references logoImage(id),
foreign key (mapImageFK) references mapImage(id)

);

create table vote(
id int not null primary key auto_increment,
voterName varchar(50) default "Annonymous",
boardGameFk int not null,

foreign key (boardGameFk) references boardgame(id)

);


select  LOAD_FILE('/home/thiago/IdeaProjects/api-feedbakc/src/test/resources/image/fuckYeah.png');
-- Insert into mapImage table
INSERT INTO mapImage (imageData, imageName, imageType)
VALUES
    (LOAD_FILE('/home/thiago/IdeaProjects/api-feedbakc/src/test/resources/image/fuckYeah.png'), 'Image 1', 'PNG'),
    (LOAD_FILE('/home/thiago/IdeaProjects/api-feedbakc/src/test/resources/image/fuckYeah.png'), 'Image 2', 'PNG'),
    (LOAD_FILE('/home/thiago/IdeaProjects/api-feedbakc/src/test/resources/image/fuckYeah.png'), 'Image 3', 'PNG');

-- Insert into logoImage table
INSERT INTO logoImage (imageData, imageName, imageType)
VALUES
      (LOAD_FILE('/home/thiago/IdeaProjects/api-feedbakc/src/test/resources/image/fuckYeah.png'), 'Image 1', 'PNG'),
    (LOAD_FILE('/home/thiago/IdeaProjects/api-feedbakc/src/test/resources/image/fuckYeah.png'), 'Image 2', 'PNG'),
    (LOAD_FILE('/home/thiago/IdeaProjects/api-feedbakc/src/test/resources/image/fuckYeah.png'), 'Image 3', 'PNG');

-- Insert into boardgame table
INSERT INTO boardgame (logoImageFK, mapImageFK, name)
VALUES
    (1, 1, 'Board Game 1'),
    (2, 2, 'Board Game 2'),
    (3, 3, 'Board Game 3');

-- Insert into vote table
INSERT INTO vote (voterName, boardGameFk)
VALUES
    ('User1', 1),
    ('User2', 2),
    ('User3', 3),
    ('User4', 1),
    ('User5', 2);


