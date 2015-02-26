use restappdb;

insert into book (
	id,
	title,
    author,
    description,
    price,
    createAt,
    updateAt
) value (
	'1',
	'Inherit the Stars',
	'James Patrick Hogan',
    '',
    '750',
    '2015/01/15 10:00:00',
    '2015/01/15 10:00:00'
);

insert into book (
	id,
	title,
    author,
    description,
    price,
    createAt,
    updateAt
) value (
	'2',
	'The Gentle Giants of Ganymede',
	'James Patrick Hogan',
    '',
    '750',
    '2015/01/15 10:00:00',
    '2015/01/15 10:00:00'
);

select * from book;
