CREATE TABLE traits
(
    id          bigint       NOT NULL PRIMARY KEY,
    name        varchar(500) NOT NULL,
    description text
);


CREATE TABLE character_abilities
(
    id                   bigint NOT NULL PRIMARY KEY,
    value                bigint NOT NULL,
    ability_id           bigint NOT NULL,
    session_character_id bigint NOT NULL
);


CREATE TABLE characters
(
    id                 bigint       NOT NULL PRIMARY KEY,
    name               varchar(500) NOT NULL,
    background         text,
    ideals             text,
    bonds              text,
    flaws              text,
    personality_traits text,
    alignment_id       bigint       NOT NULL,
    class_id           bigint       NOT NULL,
    race_id            bigint       NOT NULL,
    ability_bonus_id   bigint       NOT NULL
);


CREATE TABLE creature_types
(
    id   bigint       NOT NULL PRIMARY KEY,
    name varchar(500) NOT NULL
);


CREATE TABLE races
(
    id          bigint       NOT NULL PRIMARY KEY,
    name        varchar(500) NOT NULL,
    description text,
    type_id     bigint       NOT NULL,
    size        smallint     NOT NULL
);


CREATE TABLE abilities
(
    id          bigint       NOT NULL PRIMARY KEY,
    name        varchar(500) NOT NULL,
    description text
);


CREATE TABLE classes
(
    id            bigint       NOT NULL PRIMARY KEY,
    name          varchar(500) NOT NULL,
    description   text,
    hit_point_die smallint     NOT NULL
);


CREATE TABLE sessions
(
    id           bigint       NOT NULL PRIMARY KEY,
    name         varchar(500) NOT NULL,
    start        timestamp    NOT NULL,
    last_updated timestamp
);


CREATE TABLE race_ability_bonus
(
    id         bigint   NOT NULL PRIMARY KEY,
    ability_id bigint   NOT NULL,
    race_id    bigint   NOT NULL,
    bonus      smallint NOT NULL
);


CREATE TABLE race_traits
(
    trait_id bigint NOT NULL,
    race_id  bigint NOT NULL,
    PRIMARY KEY (trait_id, race_id)
);


CREATE TABLE character_inventory
(
    id           bigint NOT NULL PRIMARY KEY,
    amount       bigint NOT NULL,
    character_id bigint NOT NULL,
    equipment_id bigint NOT NULL
);


CREATE TABLE equipment
(
    id                 bigint       NOT NULL PRIMARY KEY,
    name               varchar(500) NOT NULL,
    description        varchar(500) NOT NULL,
    suggested_price_gp smallint     NOT NULL,
    weight             decimal      NOT NULL
);


CREATE TABLE money
(
    id               bigint       NOT NULL PRIMARY KEY,
    currency         varchar(500) NOT NULL,
    exchange_rate_cp decimal      NOT NULL,
    exchange_rate_sp decimal      NOT NULL,
    exchange_rate_ep decimal      NOT NULL,
    exchange_rate_gp decimal      NOT NULL,
    exchange_rate_pp decimal      NOT NULL
);


CREATE TABLE alignment
(
    id   bigint       NOT NULL PRIMARY KEY,
    name varchar(500) NOT NULL
);


CREATE TABLE sessions_character
(
    session_id   bigint   NOT NULL,
    character_id bigint   NOT NULL,
    inventory_id bigint   NOT NULL,
    money_id     bigint   NOT NULL,
    abilities_id bigint   NOT NULL,
    level        smallint NOT NULL,
    experience   smallint NOT NULL,
    health       smallint NOT NULL,
    PRIMARY KEY (session_id, character_id)
);


CREATE TABLE locations
(
    id          bigint       NOT NULL PRIMARY KEY,
    session_id  bigint       NOT NULL,
    name        varchar(500) NOT NULL,
    description text
);


CREATE TABLE npc
(
    id           bigint       NOT NULL PRIMARY KEY,
    name         varchar(500) NOT NULL,
    description  text         NOT NULL,
    health       smallint     NOT NULL,
    alignment_id bigint       NOT NULL,
    class_id     bigint       NOT NULL,
    race_id      bigint       NOT NULL,
    is_hostile   boolean      NOT NULL,
    role         varchar(500) NOT NULL,
    location_id  bigint
);


ALTER TABLE race_ability_bonus
    ADD CONSTRAINT race_ability_bonus_fk FOREIGN KEY (ability_id) REFERENCES abilities (id),
    ADD CONSTRAINT race_ability_bonus_race_fk FOREIGN KEY (race_id) REFERENCES races (id);

ALTER TABLE character_abilities
    ADD CONSTRAINT character_abilities_fk FOREIGN KEY (ability_id) REFERENCES abilities (id);

ALTER TABLE characters
    ADD CONSTRAINT characters_class_fk FOREIGN KEY (class_id) REFERENCES classes (id),
    ADD CONSTRAINT characters_race_fk FOREIGN KEY (race_id) REFERENCES races (id),
    ADD CONSTRAINT characters_ability_bonus_fk FOREIGN KEY (ability_bonus_id) REFERENCES race_ability_bonus (id),
    ADD CONSTRAINT characters_alignment_fk FOREIGN KEY (alignment_id) REFERENCES alignment (id);

ALTER TABLE race_traits
    ADD CONSTRAINT race_traits_fk FOREIGN KEY (race_id) REFERENCES races (id),
    ADD CONSTRAINT race_traits_trait_fk FOREIGN KEY (trait_id) REFERENCES traits (id);

ALTER TABLE races
    ADD CONSTRAINT races_type_fk FOREIGN KEY (type_id) REFERENCES creature_types (id);

ALTER TABLE character_inventory
    ADD CONSTRAINT character_inventory_fk FOREIGN KEY (equipment_id) REFERENCES equipment (id);

ALTER TABLE sessions_character
    ADD CONSTRAINT sessions_character_session_fk FOREIGN KEY (session_id) REFERENCES sessions (id),
    ADD CONSTRAINT sessions_character_character_fk FOREIGN KEY (character_id) REFERENCES characters (id),
    ADD CONSTRAINT sessions_character_inventory_fk FOREIGN KEY (inventory_id) REFERENCES character_inventory (id),
    ADD CONSTRAINT sessions_character_money_fk FOREIGN KEY (money_id) REFERENCES money (id),
    ADD CONSTRAINT sessions_character_abilities_fk FOREIGN KEY (abilities_id) REFERENCES character_abilities (id);

ALTER TABLE locations
    ADD CONSTRAINT locations_session_fk FOREIGN KEY (session_id) REFERENCES sessions (id);

ALTER TABLE npc
    ADD CONSTRAINT npc_alignment_fk FOREIGN KEY (alignment_id) REFERENCES alignment (id),
    ADD CONSTRAINT npc_class_fk FOREIGN KEY (class_id) REFERENCES classes (id),
    ADD CONSTRAINT npc_race_fk FOREIGN KEY (race_id) REFERENCES races (id),
    ADD CONSTRAINT npc_location_fk FOREIGN KEY (location_id) REFERENCES locations (id);