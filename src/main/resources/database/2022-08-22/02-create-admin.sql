--changeset dylionen:1
INSERT INTO public.users (active, created_date, mail_address, password, user_name)
values (true, NOW(), 'test@page.pl', '$2a$12$6QD2M6c09FHJYv.iyfHjUO.MNzJ9u3pANF3gaxiaYxJJl7hdmKXOq',
        'admin');
-- login: admin, password: admin

--changeset dylionen:2
INSERT INTO public.users_roles (user_id, role_id)
values ((select id from public.users where user_name = 'admin'), (select id from public.role where role_name = 'USER')),
       ((select id from public.users where user_name = 'admin'), (select id from public.role where role_name = 'ADMIN'));
