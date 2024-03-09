create table TicketStatus(
    IdStatusTickets integer,
    Name text UNIQUE NOT NULL,
    Description text default null,
    PRIMARY KEY (IdStatusTickets)
);

create table TypeEvent(
    IdTypeEvent integer PRIMARY KEY,
    Name text UNIQUE NOT NULL
);

create table Place(
    Id_place integer PRIMARY KEY,
    NamePlace text UNIQUE NOT NULL, 
    NumberSeats integer NOT NULL,
    CouterRow integer NOT NULL,
    SeatsinRow integer NOT NULL,
    CONSTRAINT CheckNumberSeats CHECK (NumberSeats = (CouterRow * SeatsinRow))
);

create table Customer (
    IdCustomer integer PRIMARY KEY,
    Name text NOT NULL,
    email text NOT NULL UNIQUE,
    IsVerified boolean default false
);

create table Event(
    IdEvent integer PRIMARY KEY,
    DateEvent timestamp not null,
    NameEvent text,
    TypeEvent integer not null references TypeEvent(IdTypeEvent) ON DELETE RESTRICT,
    TicketsBeginSales date not null CONSTRAINT StartSales CHECK (DateEvent > TicketsBeginSales),
    TicketsEndSales date not null CONSTRAINT EndSales CHECK (DateEvent > TicketsEndSales),
    MaxNumberPayer integer not null,
    AvailableTickets integer not null,
    RemainingSeats integer not null,
    PlaceEvent integer not null references Place(Id_place) ON DELETE RESTRICT,
    CONSTRAINT StartAndEndSalesTicket CHECK (TicketsBeginSales < TicketsEndSales),
    CONSTRAINT RemainingTickets CHECK (AvailableTickets >= RemainingSeats)
);

create table Tickets(
    NumberTickets integer UNIQUE,
    DateCreateTicket timestamp not null,
    StatusTikects integer NOT NULL references TicketStatus(IdStatusTickets) ON DELETE RESTRICT,
    PriceTicket money CONSTRAINT PositivePrice CHECK (PriceTicket > 0::money), 
    IdEvent integer,
    UNIQUE (NumberTickets, DateCreateTicket),
    PRIMARY KEY (NumberTickets, DateCreateTicket)
);

create table Tickets_Customer(
    NumberTickets integer not null references Tickets(NumberTickets) ON DELETE RESTRICT,
    IdCustomer integer not null references Customer(IdCustomer) ON DELETE RESTRICT,
    PRIMARY KEY (NumberTickets, IdCustomer) 
);