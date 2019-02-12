CREATE TABLE treino
(
  id serial NOT NULL,
  nomeexercicio character varying,
  tipotreinamento character varying,
  duracao integer,
  series character varying,
  CONSTRAINT treino_pkey PRIMARY KEY (id)
)

CREATE TABLE usuario
(
  idusuario serial NOT NULL,
  senha character varying,
  perfilacesso character varying(20),
  login character varying,
  email character varying,
  CONSTRAINT login_pkey PRIMARY KEY (idusuario)
)

CREATE TABLE examefisico
(
  idexame serial NOT NULL,
  altura double precision,
  peso double precision,
  peito double precision,
  cintura double precision,
  panturrilhaesquerda double precision,
  panturrilhadireita double precision,
  bracoesquerdo double precision,
  bracodireito double precision,
  antebracoesquerdo double precision,
  antebracodireito double precision,
  gluteo character varying,
  CONSTRAINT examefisico_pkey PRIMARY KEY (idexame)
)


create extension pgcrypto;