-- Sequence: public.cliente_id_seq

-- DROP SEQUENCE public.cliente_id_seq;

CREATE SEQUENCE public.cliente_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 3
  CACHE 1;
ALTER TABLE public.cliente_id_seq
  OWNER TO icomp;

-- Sequence: public.conta_id_seq

-- DROP SEQUENCE public.conta_id_seq;

CREATE SEQUENCE public.conta_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 6
  CACHE 1;
ALTER TABLE public.conta_id_seq
  OWNER TO icomp;

-- Sequence: public.lancamentos_id_seq

-- DROP SEQUENCE public.lancamentos_id_seq;

CREATE SEQUENCE public.lancamentos_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 2
  CACHE 1;
ALTER TABLE public.lancamentos_id_seq
  OWNER TO icomp;


-- Table: public.cliente

-- DROP TABLE public.cliente;

CREATE TABLE public.cliente
(
  id integer NOT NULL DEFAULT nextval('cliente_id_seq'::regclass),
  c_nome character varying(100),
  c_pessoa character varying(1),
  c_status character varying(1),
  c_endereco character varying(150),
  c_email character varying(80),
  c_telefone character varying(14),
  c_celular character varying(14),
  c_cgccpf character varying(14)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.cliente
  OWNER TO icomp;

-- Table: public.conta

-- DROP TABLE public.conta;

CREATE TABLE public.conta
(
  id integer NOT NULL DEFAULT nextval('conta_id_seq'::regclass),
  c_idcliente integer NOT NULL,
  c_numagencia character varying(10) NOT NULL,
  c_nomeagencia character varying(100),
  c_numconta character varying(15) NOT NULL,
  c_nomeconta character varying(100),
  c_saldoinicial numeric(13,2),
  CONSTRAINT naorepetir PRIMARY KEY (c_idcliente, c_numagencia, c_numconta)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.conta
  OWNER TO icomp;

-- Trigger: tg_lancamentos on public.conta

-- DROP TRIGGER tg_lancamentos ON public.conta;

CREATE TRIGGER tg_lancamentos
  AFTER INSERT
  ON public.conta
  FOR EACH ROW
  EXECUTE PROCEDURE public.lancamentos();

-- Table: public.lancamentos

-- DROP TABLE public.lancamentos;

CREATE TABLE public.lancamentos
(
  id integer NOT NULL DEFAULT nextval('lancamentos_id_seq'::regclass),
  c_idcliente integer,
  c_idconta integer,
  c_tipo character varying(1),
  c_motivo character varying(100),
  c_valor numeric(13,2),
  c_dataevento character varying(10)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.lancamentos
  OWNER TO icomp;

-- Function: public.lancamentos()

-- DROP FUNCTION public.lancamentos();

CREATE OR REPLACE FUNCTION public.lancamentos()
  RETURNS trigger AS
$BODY$    
  

   BEGIN    
  
   	if upper(TG_OP) in ('INSERT') then   
  
      INSERT INTO lancamentos
            (c_idcliente,
             c_idconta,
             c_tipo,
             c_motivo,
             c_valor,
             c_dataevento)
VALUES      
            (new.c_idcliente,
             new.id,
             'C',
             'Saldo Inicial',
             new.c_saldoinicial,
             CURRENT_DATE);  

	END IF;  
   	RETURN NEW;    
  
  
   END;    
  
   $BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION public.lancamentos()
  OWNER TO icomp;
