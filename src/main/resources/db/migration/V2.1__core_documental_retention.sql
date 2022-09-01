DROP TABLE IF EXISTS public.core_documental_retention;

CREATE TABLE IF NOT EXISTS public.core_documental_retention
(
    id integer NOT NULL,
    organitation character varying,
    dependency_code character varying,
    specification_features character varying,
    years_retention character varying,
    support_type character varying,
    final_disposition character varying,
    procedure character varying
);


CREATE SEQUENCE IF NOT EXISTS public.core_documental_retention_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
    OWNED BY core_documental_retention.id;