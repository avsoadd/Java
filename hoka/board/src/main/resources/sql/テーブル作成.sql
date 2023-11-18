create table public.likes( 
    like_id bigserial not null
    , user_id integer not null
    , post_id bigint not null
    , created_date timestamp (6) without time zone default CURRENT_TIMESTAMP
    , primary key (like_id)
); 

create table public.posts( 
    post_id bigserial not null
    , user_id integer not null
    , vvox_id bigint
    , image1_path character varying (1000)
    , image2_path character varying (1000)
    , image3_path character varying (1000)
    , image4_path character varying (1000)
    , delete_flg boolean
    , message_text character varying (1000) not null
    , created_date timestamp (6) without time zone default CURRENT_TIMESTAMP
    , primary key (post_id)
); 
drop table public.posts;
create table public.users( 
    user_id serial not null
    , user_tag character varying (100) not null
    , user_name character varying (100) not null
    , email character varying (100) not null
    , password_hash character varying (255) not null
    , delete_flg boolean
    , create_user_tag character varying (100)
    , create_date timestamp (6) without time zone default CURRENT_TIMESTAMP
    , primary key (user_id)
); 


