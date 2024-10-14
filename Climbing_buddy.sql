DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `session`;
DROP TABLE IF EXISTS `place`;
DROP TABLE IF EXISTS `card`;
DROP TABLE IF EXISTS `media`;
DROP TABLE IF EXISTS `exercise`;
DROP TABLE IF EXISTS `technique`;
DROP TABLE IF EXISTS `exercise`;
DROP TABLE IF EXISTS `route`;
DROP TABLE IF EXISTS `user_session`;
DROP TABLE IF EXISTS `session_route`;
DROP TABLE IF EXISTS `user_place`;
DROP TABLE IF EXISTS `route_exercise`;
DROP TABLE IF EXISTS `route_technic`;
DROP TABLE IF EXISTS `exercise_technic`;


CREATE TABLE `user`(
`user-id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`name`VARCHAR(100) NOT NULL,
`username` VARCHAR(100) NOT NULL,
`password`VARCHAR(100) NOT NULL,
`email` VARCHAR(100) NOT NULL
);
CREATE TABLE `place`(
`place-id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`label-place` VARCHAR(255) NOT NULL
);  


CREATE TABLE `session`(
`session-id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`date` DATE NOT NULL,
`duration` INT NOT NULL,
`warm-up` BOOLEAN,
`place-id` INT NOT NULL,
FOREIGN KEY (`place-id`) REFERENCES `place`(`place-id`)
);


CREATE TABLE `type`(
`type-id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`label-type` VARCHAR(255) NOT NULL
);

CREATE TABLE `techsheets`(
`card-id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`label-card` VARCHAR(255) NOT NULL,
`pathFile` VARCHAR(511) NOT NULL,
`alt` VARCHAR(100)
);

CREATE TABLE `media`(
`media-id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`label-media` VARCHAR(255) NOT NULL,
`pathFile` VARCHAR(511) NOT NULL,
`alt` VARCHAR(100),
`session-id` INT NOT NULL,
FOREIGN KEY (`session-id`) REFERENCES `session`(`session-id`)
);

CREATE TABLE `exercise`(
`exercise-id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`label-exercise` VARCHAR(255) NOT NULL,
`card-id` INT NOT NULL,
FOREIGN KEY (`card-id`) REFERENCES `techsheets`(`card-id`)
);

CREATE TABLE `technique`(
`technique-id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`label-technique` VARCHAR(255) NOT NULL,
`card-id` INT NOT NULL,
FOREIGN KEY (`card-id`) REFERENCES `techsheets`(`card-id`)
);

CREATE TABLE `route`(
`route-id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`type-id` INT NOT NULL,
FOREIGN KEY (`type-id`) REFERENCES `type`(`type-id`),
`is-slab` BOOLEAN DEFAULT FALSE NOT NULL,
`is-overhang` BOOLEAN DEFAULT FALSE NOT NULL,
`is-lead` BOOLEAN DEFAULT FALSE NOT NULL,
`is-top-rope` BOOLEAN DEFAULT FALSE NOT NULL,
`lenght` INT NOT NULL
);

CREATE TABLE `user_session`(
userId INT NOT NULL,
sessionId INT NOT NULL,
FOREIGN KEY (userId) REFERENCES `user`(userId),
FOREIGN KEY (sessionId) REFERENCES `session`(sessionId),
PRIMARY KEY (userId,sessionId)
);

CREATE TABLE session_route(
sessionId INT NOT NULL,
routeId INT NOT NULL,
FOREIGN KEY (sessionId) REFERENCES `session`(sessionId),
FOREIGN KEY (routeId) REFERENCES route(routeId),
PRIMARY KEY (routeId,sessionId)
);

CREATE TABLE user_place(
userId INT NOT NULL,
placeId INT NOT NULL,
FOREIGN KEY (userId) REFERENCES `user`(userId),
FOREIGN KEY (placeId) REFERENCES place(placeId),
PRIMARY KEY (userId,placeId)
);

CREATE TABLE route_exercise(
routeId INT NOT NULL,
exerciseId INT NOT NULL,
FOREIGN KEY (routeId) REFERENCES route(routeId),
FOREIGN KEY (exerciseId) REFERENCES exercise(exerciseId),
PRIMARY KEY (routeId,exerciseId)
);

CREATE TABLE route_technic(
routeId INT NOT NULL,
technicId INT NOT NULL,
FOREIGN KEY (routeId) REFERENCES route(routeId),
FOREIGN KEY (technicId) REFERENCES technique(technicId),
PRIMARY KEY (routeId,technicId)
);

CREATE TABLE exercise_technic(
exerciseId INT NOT NULL,
technicId INT NOT NULL,
FOREIGN KEY (exerciseId) REFERENCES exercise(exerciseId),
FOREIGN KEY (technicId) REFERENCES technique(technicId),
PRIMARY KEY (exerciseId,technicId)
);
