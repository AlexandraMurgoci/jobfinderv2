INSERT INTO users(user_id, email, username, password, enabled)
VALUES (
       nextval('sequence_users'),
       'alexa.murgoci@gmail.com',
       'AlexaAdmin',
       '$2a$12$n8rEkxdS4UNkexHCCLvQZuQVPh70PnFooS1vF0l/2XYFHHAqfjMwi',
       't'
       )
;

INSERT INTO user_roles(user_id, role)
VALUES (
        (SELECT user_id FROM users where username = 'AlexaAdmin'),
        'ROLE_ADMIN'
       )
;