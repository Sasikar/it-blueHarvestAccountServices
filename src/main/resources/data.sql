
-- customer table inserts (existing customers)
insert into CUSTOMER
values(1111,'Kohli', 'Virat');

insert into CUSTOMER
values(2222,'Rohit', 'Sharma');

insert into CUSTOMER
values(3333,'Ganguly', 'Dada');

insert into CUSTOMER
values(4444,'Sachin', 'Tendulkar');

insert into CUSTOMER
values(5555,'Rahul', 'Dravid');



-- Existing default account( for existing customers)
insert into DefaultAccount
values(1111,100000);

insert into DefaultAccount
values(2222,100000);

insert into DefaultAccount
values(3333,100000);

insert into DefaultAccount
values(4444,100000);

insert into DefaultAccount
values(5555,100000);


---some default transactions on default account----
insert into DEFAULTACCOUNTTRANSACTION
values(1111,9999999987);


insert into DEFAULTACCOUNTTRANSACTION
values(2222,99999999765);

insert into DEFAULTACCOUNTTRANSACTION
values(3333,999999996353);


insert into DEFAULTACCOUNTTRANSACTION
values(4444,999999999234);

insert into DEFAULTACCOUNTTRANSACTION
values(5555,9999999910234);

