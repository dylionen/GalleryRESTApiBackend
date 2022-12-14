--liquibase formatted sql
--changeset dylionen:1
CREATE TABLE IF NOT EXISTS public.role
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    description character varying(255),
    role_name character varying(255),
    CONSTRAINT role_pkey PRIMARY KEY (id)
);
--changeset dylionen:2
CREATE TABLE IF NOT EXISTS public.users
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    active boolean,
    created_date timestamp without time zone,
    first_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default",
    mail_address character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    user_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT uk_i2xbkry9lxp0htufwkoemnjt4 UNIQUE (mail_address),
    CONSTRAINT uk_k8d0f2n7n88w1a16yhua64onx UNIQUE (user_name)
);
--changeset dylionen:3
CREATE TABLE IF NOT EXISTS public.users_roles
(
    user_id bigint NOT NULL,
    role_id bigint NOT NULL,
    CONSTRAINT users_roles_pkey PRIMARY KEY (user_id, role_id),
    CONSTRAINT fk2o0jvgh89lemvvo17cbqvdxaa FOREIGN KEY (user_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkt4v0rrweyk393bdgt107vdx0x FOREIGN KEY (role_id)
        REFERENCES public.role (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);
--changeset dylionen:4

CREATE TABLE IF NOT EXISTS public.gallery
(
    id bigint NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    created_date timestamp without time zone,
    long_name character varying(255) COLLATE pg_catalog."default",
    short_name character varying(255) COLLATE pg_catalog."default",
    users_id bigint NOT NULL,
    CONSTRAINT gallery_pkey PRIMARY KEY (id),
    CONSTRAINT fkt4v0rrweyk393bdgt1dgfdfgx FOREIGN KEY (users_id)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

--changeset dylionen:5
insert into public.role(role_name, description) values ('ADMIN','Administrator'), ('USER','U??ytkownik');
