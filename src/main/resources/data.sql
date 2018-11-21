
-- customer table inserts (existing customers)
insert into CUSTOMER
values(1111,'Ranga', 'kumar');

insert into CUSTOMER
values(2222,'Ravi', 'varma');


-- Existing default account( for existing customers)
insert into DefaultAccount
values(1111,100000);

insert into DefaultAccount
values(2222,100000);

---some default transactions on default account----
insert into DEFAULTACCOUNTTRANSACTION
values(1111,99999999999);


insert into DEFAULTACCOUNTTRANSACTION
values(2222,9999999999991);
