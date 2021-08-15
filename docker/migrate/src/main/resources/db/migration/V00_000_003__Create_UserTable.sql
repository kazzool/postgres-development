create table sample_schema.t_user (
  user_id character varying(30) not null
  , display_name character varying(50) not null
  , created_at timestamp(6) without time zone
  , created_by character varying(30) default NULL
  , updated_at timestamp(6) without time zone
  , updated_by character varying(30) default NULL
  , primary key (user_id)
);
ALTER TABLE sample_schema.t_user OWNER TO sample_user;