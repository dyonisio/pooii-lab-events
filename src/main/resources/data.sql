INSERT INTO TB_BASE_USER (name, email) VALUES ('Antonio', 'antonio@email.com')
INSERT INTO TB_BASE_USER (name, email) VALUES ('Valdir', 'valdir@email.com')
INSERT INTO TB_BASE_USER (name, email) VALUES ('Kleber', 'kleber@email.com')
INSERT INTO TB_BASE_USER (name, email) VALUES ('Vinicius', 'vinicius@email.com')
INSERT INTO TB_BASE_USER (name, email) VALUES ('Rodrigo', 'rodrigo@email.com')
INSERT INTO TB_BASE_USER (name, email) VALUES ('Zé', 'ze@email.com')

INSERT INTO TB_ADMIN (base_user_id, phone_number) VALUES (1, '(30) 94143-3522')
INSERT INTO TB_ADMIN (base_user_id, phone_number) VALUES (2, '(17) 93285-6760')
INSERT INTO TB_ADMIN (base_user_id, phone_number) VALUES (3, '(54) 90084-2819')

INSERT INTO TB_ATTEND (base_user_id, balance) VALUES (1, 55.00)
INSERT INTO TB_ATTEND (base_user_id, balance) VALUES (2, 100.00)
INSERT INTO TB_ATTEND (base_user_id, balance) VALUES (3, 0.00)

INSERT INTO TB_EVENT (name, description, start_date, end_date, start_time, end_time, email_contact, amount_free_tickets, amount_payed_tickets, price_ticket, admin_base_user_id) VALUES ('Carnaval', 'Todo mundo pulando fantasiado!', '2022-02-26', '2022-03-01', '00:00', '23:59', 'prefeitura@sp.gov.br', 100, 50, 20, 1)
INSERT INTO TB_EVENT (name, description, start_date, end_date, start_time, end_time, email_contact, amount_free_tickets, amount_payed_tickets, price_ticket, admin_base_user_id) VALUES ('Festa Junina', 'Doces, quadrilha e muito mais!', '2022-06-01', '2022-06-03', '19:00', '23:59', 'condominio@sp.gov.br', 50, 75, 10, 2)
INSERT INTO TB_EVENT (name, description, start_date, end_date, start_time, end_time, email_contact, amount_free_tickets, amount_payed_tickets, price_ticket, admin_base_user_id) VALUES ('Ano Novo', 'O seu ano atual + 1!', '2023-01-01', '2023-01-01', '00:00', '23:59', 'carinha@sp.gov.br', 0, 200, 100, 3)

INSERT INTO TB_PLACE (name, address) VALUES ('Parque Ibirapuera', 'Avenida Pedro Álvares Cabral, Sao Paulo, SP, 04094-050')
INSERT INTO TB_PLACE (name, address) VALUES ('Museu de Arte de São Paulo', 'Avenida Paulista, 1578, Sao Paulo, SP, 01310-000')
INSERT INTO TB_PLACE (name, address) VALUES ('Centro Cultural Banco do Brasil', 'Rua Álvares Penteado, 112, Sao Paulo, SP, 01012-000')

