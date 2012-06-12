/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  05/06/2012 15:23:28                      */
/*==============================================================*/

DROP DATABASE IF EXISTS `yakaerien`;
CREATE DATABASE `yakaerien` DEFAULT CHARACTER SET latin1 COLLATE latin1_bin;
USE `yakaerien`;

drop table if exists CATEGORY;

drop table if exists COMPANY;

drop table if exists CONTROLLER;

drop table if exists LANDING;

drop table if exists LANDINGPLATFORM;

drop table if exists PARKING;

drop table if exists PARKPLANNING;

drop table if exists PLANE;

drop table if exists TAKEOFF;

drop table if exists TAKEOFFPLATFORM;

/*==============================================================*/
/* Table : CATEGORY                                             */
/*==============================================================*/
create table CATEGORY
(
   ID			        int not null auto_increment,
   CAT_NAME             varchar(255) not null,
   primary key (ID)
);

insert into `category` (`id`, `cat_name`) values
	(1, 'Petit porteur'),
	(2, 'Moyen porteur'),
	(3, 'Gros porteur'),
	(4, 'Cargo');

/*==============================================================*/
/* Table : COMPANY                                              */
/*==============================================================*/
create table COMPANY
(
   ID			        int not null auto_increment,
   COMPANY_NAME         varchar(255) not null,
   primary key (ID)
);

/*==============================================================*/
/* Table : CONTROLLER                                           */
/*==============================================================*/
create table CONTROLLER
(
   ID			        int not null auto_increment,
   CONT_FIRSTNAME       varchar(255) not null,
   CONT_LASTNAME        varchar(255) not null,
   CONT_ADDRESS         varchar(255),
   CONT_BIRTHDATE       date,
   CONT_NUMSECU         int not null,
   primary key (ID)
);

/*==============================================================*/
/* Table : LANDING                                              */
/*==============================================================*/
create table LANDING
(
   ID		            int not null auto_increment,
   CONTROLLER_ID        int not null,
   PLANE_ID             int not null,
   LANDINGPLATFORM_ID   int not null,
   LANDING_DATE         datetime not null,
   LANDING_PASSENGERS   int,
   primary key (ID)
);

/*==============================================================*/
/* Table : LANDINGPLATFORM                                      */
/*==============================================================*/
create table LANDINGPLATFORM
(
   ID          		    int not null auto_increment,
   LPLAT_NUMBER         int not null,
   primary key (ID)
);

insert into `landingplatform` (`lplat_number`) values
	(9),
	(27);

/*==============================================================*/
/* Table : PARKING                                              */
/*==============================================================*/
create table PARKING
(
   ID                   int not null auto_increment,
   CATEGORY_ID          int not null,
   PARKING_EMPTY        bool not null,
   PARKING_NUMBER       int not null,
   PARKING_NAME         varchar(255) not null,
   primary key (ID)
);

insert into `parking` (`category_id`, `parking_empty`, `parking_number`, `parking_name`) values
	(4, true, 1, "FOX-1"),
	(4, true, 2, "FOX-2"),
	(4, true, 3, "FOX-3"),
	(4, true, 4, "FOX-4"),
	(4, true, 5, "FOX-5"),
	(3, true, 6, "BRAVO-1"),
	(3, true, 7, "BRAVO-2"),
	(3, true, 8, "BRAVO-3"),
	(3, true, 9, "BRAVO-4"),
	(3, true, 10, "BRAVO-5"),
	(3, true, 11, "BRAVO-6"),
	(3, true, 12, "BRAVO-7"),
	(3, true, 13, "BRAVO-8"),
	(3, true, 14, "BRAVO-9"),
	(2, true, 15, "MIKE-1"),
	(2, true, 16, "MIKE-2"),
	(2, true, 17, "MIKE-3"),
	(2, true, 18, "MIKE-4"),
	(2, true, 19, "MIKE-5"),
	(2, true, 20, "MIKE-6"),
	(2, true, 21, "MIKE-7"),
	(2, true, 22, "MIKE-8"),
	(2, true, 23, "MIKE-9"),
	(2, true, 24, "MIKE-10"),
	(2, true, 25, "MIKE-11"),
	(2, true, 26, "MIKE-12"),
	(1, true, 27, "SIERRA-1"),
	(1, true, 28, "SIERRA-2"),
	(1, true, 29, "SIERRA-3"),
	(1, true, 30, "SIERRA-4"),
	(1, true, 31, "SIERRA-5"),
	(1, true, 32, "SIERRA-6"),
	(1, true, 33, "SIERRA-7"),
	(1, true, 34, "SIERRA-8"),
	(1, true, 35, "SIERRA-9");

/*==============================================================*/
/* Table : PARKPLANNING                                         */
/*==============================================================*/
create table PARKPLANNING
(
   ID                   int not null auto_increment,
   CONTROLLER_ID        int not null,
   PARKING_ID           int not null,
   PLANE_ID             int not null,
   PP_INDATE            datetime not null,
   PP_OUTDATE           datetime,
   PP_ACTION            varchar(255) not null,
   primary key (ID)
);

/*==============================================================*/
/* Table : PLANE                                                */
/*==============================================================*/
create table PLANE
(
   ID                   int not null auto_increment,
   CATEGORY_ID          int not null,
   COMPANY_ID           int not null,
   PLANE_IMMATRICULATION varchar(7) not null,
   PLANE_STATUS         varchar(255),
   PLANE_CURRENT_OP     varchar(255),
   primary key (ID)
);

/*==============================================================*/
/* Table : TAKEOFF                                              */
/*==============================================================*/
create table TAKEOFF
(
   ID                   int not null auto_increment,
   TAKEOFFPLATFORM_ID   int not null,
   CONTROLLER_ID        int not null,
   PLANE_ID             int not null,
   TAKEOFF_DATE         datetime not null,
   TAKEOFF_PASSENGERS   int,
   primary key (ID)
);

/*==============================================================*/
/* Table : TAKEOFFPLATFORM                                      */
/*==============================================================*/
create table TAKEOFFPLATFORM
(
   ID             int not null auto_increment,
   TPLAT_NUMBER         int not null,
   primary key (ID)
);

insert into `takeoffplatform` (`tplat_number`) values
	(8),
	(26);

alter table LANDING add constraint FK_CONTROLS_LANDING foreign key (CONTROLLER_ID)
      references CONTROLLER (ID) on delete restrict on update restrict;

alter table LANDING add constraint FK_LANDS foreign key (PLANE_ID)
      references PLANE (ID) on delete restrict on update restrict;

alter table LANDING add constraint FK_LANDS_ON foreign key (LANDINGPLATFORM_ID)
      references LANDINGPLATFORM (ID) on delete restrict on update restrict;

alter table PARKING add constraint FK_HAS_CAPACITY_FOR foreign key (CATEGORY_ID)
      references CATEGORY (ID) on delete restrict on update restrict;

alter table PARKPLANNING add constraint FK_CONCERNS foreign key (PLANE_ID)
      references PLANE (ID) on delete restrict on update restrict;

alter table PARKPLANNING add constraint FK_CONTROLS_PARK foreign key (CONTROLLER_ID)
      references CONTROLLER (ID) on delete restrict on update restrict;

alter table PARKPLANNING add constraint FK_STORES_IN foreign key (PARKING_ID)
      references PARKING (ID) on delete restrict on update restrict;

alter table PLANE add constraint FK_BELONGS_TO foreign key (COMPANY_ID)
      references COMPANY (ID) on delete restrict on update restrict;

alter table PLANE add constraint FK_IS_A foreign key (CATEGORY_ID)
      references CATEGORY (ID) on delete restrict on update restrict;

alter table TAKEOFF add constraint FK_CONTROLS_TAKE_OFF foreign key (CONTROLLER_ID)
      references CONTROLLER (ID) on delete restrict on update restrict;

alter table TAKEOFF add constraint FK_TAKES_OFF foreign key (PLANE_ID)
      references PLANE (ID) on delete restrict on update restrict;

alter table TAKEOFF add constraint FK_TAKES_OFF_ON foreign key (TAKEOFFPLATFORM_ID)
      references TAKEOFFPLATFORM (ID) on delete restrict on update restrict;

