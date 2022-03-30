-- Table: public.users

-- DROP TABLE IF EXISTS public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    username character(255) COLLATE pg_catalog."default" NOT NULL,
    password character(255) COLLATE pg_catalog."default",
    enabled integer,
    CONSTRAINT users_pkey PRIMARY KEY (username)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;



-- Table: public.poll

-- DROP TABLE IF EXISTS public.poll;

CREATE TABLE IF NOT EXISTS public.poll
(
    id integer NOT NULL,
    name character(255) COLLATE pg_catalog."default",
    description character(255) COLLATE pg_catalog."default",
    start_point date,
    end_point date,
    CONSTRAINT poll_pkey PRIMARY KEY (id)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.poll
    OWNER to postgres;

-- Table: public.question

-- DROP TABLE IF EXISTS public.question;

CREATE TABLE IF NOT EXISTS public.question
(
    id integer NOT NULL,
    name character(255) COLLATE pg_catalog."default",
    type_of_question integer,
    poll_id integer,
    CONSTRAINT question_pkey PRIMARY KEY (id),
    CONSTRAINT poll_id FOREIGN KEY (poll_id)
        REFERENCES public.poll (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION

)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.question
    OWNER to postgres;

-- Table: public.interviewee

-- DROP TABLE IF EXISTS public.interviewee;

CREATE TABLE IF NOT EXISTS public.interviewee
(
    id integer NOT NULL,
    interviewee_name character(255) COLLATE pg_catalog."default",
    CONSTRAINT interviewee_pkey PRIMARY KEY (id),
    CONSTRAINT interviewee_name FOREIGN KEY (interviewee_name)
        REFERENCES public.users (username) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.interviewee
    OWNER to postgres;

-- Table: public.variant_of_answer_from_interviewee

-- DROP TABLE IF EXISTS public.variant_of_answer_from_interviewee;

CREATE TABLE IF NOT EXISTS public.variant_of_answer_from_interviewee
(
    id integer NOT NULL,
    interviewee_id integer,
    poll_id integer,
    question_id integer,
    CONSTRAINT answer_pkey PRIMARY KEY (id),
    CONSTRAINT interviewee_id FOREIGN KEY (interviewee_id)
        REFERENCES public.interviewee (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,

    CONSTRAINT poll_id FOREIGN KEY (poll_id)
        REFERENCES public.poll (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,

    CONSTRAINT question_id FOREIGN KEY (question_id)
        REFERENCES public.question (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION

)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.variant_of_answer_from_interviewee
    OWNER to postgres;

-- Table: public.answers_on_question

-- DROP TABLE IF EXISTS public.answers_on_question;

CREATE TABLE IF NOT EXISTS public.answers_on_question
(
    id integer NOT NULL,
    question_id integer,
    description character(255) COLLATE pg_catalog."default",
    CONSTRAINT variant_of_answer_pkey PRIMARY KEY (id),
    CONSTRAINT variant_of_answer_from_interviewee_question_id_fkey FOREIGN KEY (question_id)
        REFERENCES public.question (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.answers_on_question
    OWNER to postgres;

-- Table: public.variant_of_answer_from_interviewee_answers_on_question

-- DROP TABLE IF EXISTS public.variant_of_answer_from_interviewee_answers_on_question;

CREATE TABLE IF NOT EXISTS public.variant_of_answer_from_interviewee_answers_on_question
(
    answer_id integer,
    variant_of_answer_id integer,
    CONSTRAINT answer FOREIGN KEY (answer_id)
        REFERENCES public.variant_of_answer_from_interviewee (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT variant_of_answer FOREIGN KEY (variant_of_answer_id)
        REFERENCES public.answers_on_question (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.variant_of_answer_from_interviewee_answers_on_question
    OWNER to postgres;

-- Table: public.authorities

-- DROP TABLE IF EXISTS public.authorities;

CREATE TABLE IF NOT EXISTS public.authorities
(
    username character(255) COLLATE pg_catalog."default",
    authority character(255) COLLATE pg_catalog."default",
    CONSTRAINT username FOREIGN KEY (username)
        REFERENCES public.users (username) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.authorities
    OWNER to postgres;