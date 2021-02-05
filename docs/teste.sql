create table filial (
id serial primary key,
nome varchar(50),
cnpj varchar(20)
);

create table produto (
id serial primary key,
nome varchar(50)
);

create table estoque (
id serial primary key,
quantidade integer,
filial_id integer,
produto_id integer,
foreign key (filial_id) references filial(id),
foreign key (produto_id) references produto(id)
);

create table pedidoestoque (
id serial primary key,
tipo varchar(20),
filial_id integer,
foreign key (filial_id) references filial(id)
);

create table itempedidoestoque (
id serial primary key,
quantidade integer,
produto_id integer,
pedido_estoque_id integer,
foreign key (produto_id) references produto(id),
foreign key (pedido_estoque_id) references pedidoestoque(id)
);

--filial
insert into filial (id, nome, cnpj) values (1, 'Emmis Communications Corporation', '203.196.44.7/19');
insert into filial (id, nome, cnpj) values (2, 'First Trust Dorsey Wright', '126.138.68.121/21');
insert into filial (id, nome, cnpj) values (3, 'Ctrip.com International, Ltd.', '67.234.92.143/20');
--produto
insert into produto (id, nome) values (1, 'Pasta - Lasagna, Dry');
insert into produto (id, nome) values (2, 'Carbonated Water - Blackcherry');
insert into produto (id, nome) values (3, 'Club Soda - Schweppes, 355 Ml');
--estoque
insert into estoque (id, filial_id, produto_id) values (1, 1, 1);
insert into estoque (id, filial_id, produto_id) values (2, 3, 2);
insert into estoque (id, filial_id, produto_id) values (3, 2, 3);
insert into estoque (id, filial_id, produto_id) values (4, 1, 1);
insert into estoque (id, filial_id, produto_id) values (5, 2, 2);
insert into estoque (id, filial_id, produto_id) values (6, 3, 3);
--pedidoestoque 
insert into pedidoestoque (id, tipo, filial_id) values (1, 'entrada', 1);
insert into pedidoestoque (id, tipo, filial_id) values (2, 'entrada', 3);
insert into pedidoestoque (id, tipo, filial_id) values (3, 'entrada', 2);
insert into pedidoestoque (id, tipo, filial_id) values (4, 'saida', 1);
insert into pedidoestoque (id, tipo, filial_id) values (5, 'saida', 2);
insert into pedidoestoque (id, tipo, filial_id) values (6, 'saida', 3);
--itempedidoestoque 
insert into itempedidoestoque (id, quantidade, produto_id, pedido_estoque_id) values (7, 150, 1, 1);
insert into itempedidoestoque (id, quantidade, produto_id, pedido_estoque_id) values (8, 230, 2, 2);
insert into itempedidoestoque (id, quantidade, produto_id, pedido_estoque_id) values (9, 330, 3, 3);
insert into itempedidoestoque (id, quantidade, produto_id, pedido_estoque_id) values (10, 450, 1, 4);
insert into itempedidoestoque (id, quantidade, produto_id, pedido_estoque_id) values (11, 530, 2, 5);
insert into itempedidoestoque (id, quantidade, produto_id, pedido_estoque_id) values (12, 130, 3, 6);

--
select * from produto where quantidade >= 100;
--
select p.id, p.nome, p.quantidade from produto p inner join estoque e on e.produto_id = p.id where e.filial_id = 2;
--
select i.id, i.quantidade, i.produto_id, i.pedido_estoque_id, p.filial_id, p.tipo from itempedidoestoque i
inner join pedidoestoque p on i.pedido_estoque_id  = p.id 
where i.produto_id = 1;

select * from itempedidoestoque i where i.produto_id = 1;

select i.id, i.quantidade, i.produto_id, i.pedido_estoque_id, p.filial_id, p.tipo, pr.nome, pr.quantidade, f.nome, f.cnpj
        from itempedidoestoque i
        inner join pedidoestoque p on i.pedido_estoque_id  = p.id
        inner join produto pr on i.produto_id = pr.id
        inner join filial f on p.filial_id = f.id
        where i.produto_id = 1;
       
       
ALTER TABLE public.pedidoestoque ALTER COLUMN id TYPE serial;

