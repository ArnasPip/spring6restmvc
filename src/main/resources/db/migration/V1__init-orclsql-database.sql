
--    drop table beer cascade constraints;

    create table beer (
       id varchar(36) not null,
        beer_name varchar2(50 char) not null,
        beer_style number(5,0) not null,
        created_date timestamp(6),
        price number(38,2) not null,
        quantity_on_hand number(10,0),
        upc varchar2(255 char) not null,
        update_date timestamp(6),
        version number(10,0),
        primary key (id)
    );
