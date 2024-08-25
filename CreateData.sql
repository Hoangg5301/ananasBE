-- create gender
INSERT INTO public.gender(gender_name)
	VALUES ('male');
INSERT INTO public.gender(gender_name)
	VALUES ('female');

Select * From gender
--create role

INSERT INTO public.role(role_id, role_name)
	VALUES
		(1, 'Admin'),
		(2, 'Customer');

Select * From role
-- Create ACCOUNT
INSERT INTO public.account(
	gender_id, role_id, date_of_birth, address, email, password, phone_number, user_name)
	VALUES (1, 1, '05/03/2001', '347 Co Nhue, Bac Tu Liem, Ha Noi', 'hoangnguyen5301@gmail.com', 'hoang123', '0867608463', 'Hoang123');

INSERT INTO public.account(
	gender_id, role_id, date_of_birth, address, email, password, phone_number, user_name)
	VALUES (1, 2, '05/03/2001', '347 Co Nhue, Bac Tu Liem, Ha Noi', 'Tuan@gmail.com', 'Tuan012', '0867608463', 'Hoang123');
Select * from account 