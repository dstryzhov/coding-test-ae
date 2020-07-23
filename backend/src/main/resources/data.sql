insert into account (id, balance) values (1, 1000);

insert into transaction (type, amount) values ('credit', 100);
insert into transaction (type, amount) values ('credit', 100);
insert into transaction (type, amount) values ('debit', 100);
insert into transaction (type, amount) values ('debit', 100);
insert into transaction (type, amount) values ('credit', 100);

update account set balance = 900;
