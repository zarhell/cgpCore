DROP TABLE IF EXISTS public.core_saved_document;

CREATE TABLE IF NOT EXISTS public.core_saved_document
(
    id integer NOT NULL,
    documental_serial character varying,
    document_type character varying,
    document_area character varying,
    documental_user character varying,
    correspondence_type character varying,
    document_priority character varying,
    printed_tag character varying,
    documental_dates character varying,
    document_name character varying,
    observations character varying,
    storage_id integer

);


CREATE SEQUENCE IF NOT EXISTS public.core_saved_document_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
    OWNED BY core_saved_document.id;

