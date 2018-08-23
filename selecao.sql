-- SEQUENCE: public.seq_veiculo

-- DROP SEQUENCE public.seq_veiculo;

CREATE SEQUENCE public.seq_veiculo;

ALTER SEQUENCE public.seq_veiculo
    OWNER TO postgres;


-- Table: public.veiculo

-- DROP TABLE public.veiculo;

CREATE TABLE public.veiculo
(
    id bigint NOT NULL,
    modelo character varying(255) COLLATE pg_catalog."default" NOT NULL,
    fator_multiplicador numeric(15,2) NOT NULL,
    CONSTRAINT veiculo_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.veiculo
    OWNER to postgres;