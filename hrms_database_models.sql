-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public.cities
(
    city_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    city_name character varying NOT NULL,
    PRIMARY KEY (city_id)
);

CREATE TABLE public.cvs
(
    cv_id integer NOT NULL,
    cover_letter character varying(255),
    github_link character varying(255),
    linkedin_link character varying(255),
    photo_link character varying(255),
    id integer,
    PRIMARY KEY (cv_id)
);

CREATE TABLE public.educationinfos
(
    education_info_id integer NOT NULL,
    end_date date,
    start_date date,
    cv_id integer,
    university_id integer,
    university_department_id integer,
    PRIMARY KEY (education_info_id)
);

CREATE TABLE public.employers
(
    id integer NOT NULL,
    company_name character varying(50),
    phone character varying(12),
    website character varying(50),
    PRIMARY KEY (id)
);

CREATE TABLE public.jobadvertisements
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    job_description character varying,
    min_salary integer NOT NULL,
    max_salary integer NOT NULL,
    open_position_count integer,
    is_active boolean,
    employer_id integer,
    job_position_id integer,
    city_id integer,
    last_date date,
    creation_date date,
    PRIMARY KEY (id)
);

CREATE TABLE public.jobpositions
(
    id integer NOT NULL,
    job_name character varying(20),
    PRIMARY KEY (id)
);

CREATE TABLE public.jobseekers
(
    id integer NOT NULL,
    first_name character varying(20),
    last_name character varying(20),
    birth_year integer,
    national_identity character varying(11),
    cv_id integer,
    PRIMARY KEY (id)
);

CREATE TABLE public.languages
(
    language_id integer NOT NULL,
    language_level integer,
    language_name character varying(255),
    cv_id integer,
    PRIMARY KEY (language_id)
);

CREATE TABLE public.systempersonnels
(
    id integer NOT NULL,
    first_name character varying,
    last_name character varying,
    PRIMARY KEY (id)
);

CREATE TABLE public.technologies
(
    technology_id integer NOT NULL,
    tech_name character varying(255),
    cv_id integer,
    PRIMARY KEY (technology_id)
);

CREATE TABLE public.universities
(
    university_id integer NOT NULL,
    university_name character varying(255),
    PRIMARY KEY (university_id)
);

CREATE TABLE public.university_departments
(
    university_department_id integer NOT NULL,
    department_name character varying(255),
    PRIMARY KEY (university_department_id)
);

CREATE TABLE public.users
(
    id integer NOT NULL,
    mail character varying(50),
    password character varying(50),
    PRIMARY KEY (id)
);

CREATE TABLE public.workexperiences
(
    work_experience_id integer NOT NULL,
    company_name character varying(255),
    end_date date,
    start_date date,
    work_position character varying(255),
    cv_id integer,
    PRIMARY KEY (work_experience_id)
);

ALTER TABLE public.cvs
    ADD FOREIGN KEY (id)
    REFERENCES public.jobseekers (id)
    NOT VALID;


ALTER TABLE public.educationinfos
    ADD FOREIGN KEY (university_department_id)
    REFERENCES public.university_departments (university_department_id)
    NOT VALID;


ALTER TABLE public.educationinfos
    ADD FOREIGN KEY (cv_id)
    REFERENCES public.cvs (cv_id)
    NOT VALID;


ALTER TABLE public.educationinfos
    ADD FOREIGN KEY (university_id)
    REFERENCES public.universities (university_id)
    NOT VALID;


ALTER TABLE public.employers
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.jobadvertisements
    ADD FOREIGN KEY (city_id)
    REFERENCES public.cities (city_id)
    NOT VALID;


ALTER TABLE public.jobadvertisements
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (id)
    NOT VALID;


ALTER TABLE public.jobadvertisements
    ADD FOREIGN KEY (job_position_id)
    REFERENCES public.jobpositions (id)
    NOT VALID;


ALTER TABLE public.jobseekers
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.languages
    ADD FOREIGN KEY (cv_id)
    REFERENCES public.cvs (cv_id)
    NOT VALID;


ALTER TABLE public.systempersonnels
    ADD FOREIGN KEY (id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.technologies
    ADD FOREIGN KEY (cv_id)
    REFERENCES public.cvs (cv_id)
    NOT VALID;


ALTER TABLE public.workexperiences
    ADD FOREIGN KEY (cv_id)
    REFERENCES public.cvs (cv_id)
    NOT VALID;

END;