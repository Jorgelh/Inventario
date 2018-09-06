/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     21/05/2018 11:30:44                          */
/*==============================================================*/


alter table ENTREGAS
   drop constraint FK_ENTREGAS_REFERENCE_TRABAJOS;

drop table ENTREGAS cascade constraints;

drop table PN cascade constraints;

drop table TRABAJOS cascade constraints;

/*==============================================================*/
/* Table: ENTREGAS                                              */
/*==============================================================*/
create table ENTREGAS 
(
   IDENTREGA            INTEGER              not null,
   IDTRABAJO            INTEGER,
   CODIGO               INTEGER,
   PO                   VARCHAR2(25),
   ESTADO               INTEGER,
   NOTAS                CLOB,
   constraint PK_ENTREGAS primary key (IDENTREGA)
);

/*==============================================================*/
/* Table: PN                                                    */
/*==============================================================*/
create table PN 
(
   IDPN                 INTEGER              not null,
   PN                   VARCHAR2(25),
   CODIGO               INTEGER,
   constraint PK_PN primary key (IDPN)
);

/*==============================================================*/
/* Table: TRABAJOS                                              */
/*==============================================================*/
create table TRABAJOS 
(
   IDTRABAJO            INTEGER              not null,
   PN                   VARCHAR2(25),
   JOB                  VARCHAR2(15),
   ESTANDAR             INTEGER,
   FECHARECIBIDO        DATE,
   FECHAENTREGA         DATE,
   FECHAVENCIMIENTO     DATE,
   LOTE                 INTEGER,
   ESTADO               INTEGER,
   constraint PK_TRABAJOS primary key (IDTRABAJO)
);

alter table ENTREGAS
   add constraint FK_ENTREGAS_REFERENCE_TRABAJOS foreign key (IDTRABAJO)
      references TRABAJOS (IDTRABAJO);

