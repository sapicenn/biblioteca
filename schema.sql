--Banco de dados: Biblioteca
--SGBD: PostgresSQL
--Criado por: Sarah Picenni

-- Table: public.autor
-- DROP TABLE IF EXISTS public.autor;

CREATE TABLE IF NOT EXISTS public.autor
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    nome character varying(150) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_autor PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.autor
    OWNER to postgres;

-- Table: public.editora
-- DROP TABLE IF EXISTS public.editora;

CREATE TABLE IF NOT EXISTS public.editora
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    nome character varying(150) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT pk_editora PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.editora
    OWNER to postgres;

-- Table: public.genero
-- DROP TABLE IF EXISTS public.genero;

CREATE TABLE IF NOT EXISTS public.genero
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    nome character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT pk_genero PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.genero
    OWNER to postgres;

-- Table: public.livro
-- DROP TABLE IF EXISTS public.livro;

CREATE TABLE IF NOT EXISTS public.livro
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    titulo text COLLATE pg_catalog."default" NOT NULL,
    ano_publicacao integer NOT NULL,
    edicao integer NOT NULL,
    num_paginas integer NOT NULL,
    editora_id integer,
    autor_id integer,
    genero_id integer,
    status character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT pk_livro PRIMARY KEY (id),
    CONSTRAINT livro_autor_fk FOREIGN KEY (autor_id)
        REFERENCES public.autor (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT livro_editora_fk FOREIGN KEY (editora_id)
        REFERENCES public.editora (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT livro_genero_fk FOREIGN KEY (genero_id)
        REFERENCES public.genero (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT livro_edicao_check CHECK (edicao > 0),
    CONSTRAINT livro_num_paginas_check CHECK (num_paginas > 0)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.livro
    OWNER to postgres;