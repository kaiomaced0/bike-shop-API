-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
 insert into usuario (id, nome, login, senha) values(17, 'kaio', 'kaio','123');
 insert into usuario (id, nome, login, senha) values(2, 'joao', 'joao','123');
 insert into usuario (id, nome, login, senha) values(3, 'antonio', 'antonio','123');
 insert into usuario (id, nome, login, senha) values(4, 'lucas', 'lucas','123');
 insert into usuario (id, nome, login, senha) values(5, 'janio', 'janio','123');
 insert into usuario (id, nome, login, senha) values(6, 'alberto', 'alberto','123');
 insert into usuario (id, nome, login, senha) values(7, 'maria', 'maria','123');
 insert into usuario (id, nome, login, senha) values(8, 'ana', 'ana','123');
 insert into usuario (id, nome, login, senha) values(9, 'joana', 'joana','123');
 insert into usuario (id, nome, login, senha) values(10, 'kamila', 'kamila','123');
 insert into usuario (id, nome, login, senha) values(11, 'amanda', 'amanda','123');
 insert into usuario (id, nome, login, senha) values(12, 'isabela', 'isabela','123');
 insert into usuario (id, nome, login, senha) values(13, 'gabriel', 'gabriel','123');
 insert into usuario (id, nome, login, senha) values(14, 'otavio', 'otavio','123');
 insert into usuario (id, nome, login, senha) values(15, 'rubens', 'rubens','123');
 insert into usuario (id, nome, login, senha) values(16, 'ordete', 'ordete','123');
 insert into usuario (id, nome, login, senha) values(1, 'teste', 'teste','123');

 insert into produto (id, nome, estoque, preco) values(1, 'bike 1', 50, 1020.0);
 insert into produto (id, nome, estoque, preco) values(2, 'bike 2', 30, 3040.0);
 insert into produto (id, nome, estoque, preco) values(3, 'bike 3', 20, 2300.0);
 insert into produto (id, nome, estoque, preco) values(4, 'bike 4', 20, 2300.0);
 insert into produto (id, nome, estoque, preco) values(5, 'bike 5', 20, 2300.0);

 insert into bike (id, tamanho) values((SELECT produto.id FROM produto WHERE produto.nome = 'bike 1'), 1);
 insert into bike (id, tamanho) values((SELECT produto.id FROM produto WHERE produto.nome = 'bike 2'), 2);
 insert into bike (id, tamanho) values((SELECT produto.id FROM produto WHERE produto.nome = 'bike 3'), 2);
 insert into bike (id, tamanho) values((SELECT produto.id FROM produto WHERE produto.nome = 'bike 4'), 3);
 insert into bike (id, tamanho) values((SELECT produto.id FROM produto WHERE produto.nome = 'bike 5'), 4);

 insert into cupom (id, quantidade, codigo, valordesconto) values(1, 50, '#desconto20', 20.0);
 insert into cupom (id, quantidade, codigo, valordesconto) values(2, 100, '#desconto10', 10.0);
 insert into cupom (id, quantidade, codigo, valordesconto) values(3, 80, '#desconto40', 40.0);

 insert into estado (id, sigla_estado, nome) values(1, 'TO', 'Tocantins');
 insert into estado (id, sigla_estado, nome) values(2, 'GO', 'Goias');
 insert into estado (id, sigla_estado, nome) values(3, 'PA', 'Para');
 insert into estado (id, sigla_estado, nome) values(4, 'MG', 'Minas Gerais');

 insert into cidade (id, nome, estado_id) values(1, 'Palmas', (SELECT estado.id FROM estado WHERE estado.nome = 'Tocantins'));
 insert into cidade (id, nome, estado_id) values(3, 'Goiania', (SELECT estado.id FROM estado WHERE estado.nome = 'Goias'));
 insert into cidade (id, nome, estado_id) values(2, 'belem', (SELECT estado.id FROM estado WHERE estado.nome = 'Para'));

 insert into endereco (id, usuario_dono_endereco, descricao) values(1, (SELECT usuario.id FROM usuario WHERE usuario.nome = 'kaio'), 'aaaaaaaaaakdkskdk endereco legal, perto daquele lugar la');
 insert into endereco (id, usuario_dono_endereco, descricao) values(2, (SELECT usuario.id FROM usuario WHERE usuario.nome = 'joao'), 'aaaaaaaaaakdkskdk endereco legal, perto daquele lugar la');
 insert into endereco (id, usuario_dono_endereco, descricao) values(nextval('hibernate_sequence'), (SELECT usuario.id FROM usuario WHERE usuario.nome = 'antonio'), 'aaaaaaaaaakdkskdk endereco legal, perto daquele lugar la');
 insert into endereco (id, usuario_dono_endereco, descricao) values(nextval('hibernate_sequence'), (SELECT usuario.id FROM usuario WHERE usuario.nome = 'lucas'), 'aaaaaaaaaakdkskdk endereco legal, perto daquele lugar la');
 insert into endereco (id, usuario_dono_endereco, descricao) values(nextval('hibernate_sequence'), (SELECT usuario.id FROM usuario WHERE usuario.nome = 'janio'), 'aaaaaaaaaakdkskdk endereco legal, perto daquele lugar la');

 insert into telefone (id, nome, proprietario_id) values(nextval('hibernate_sequence'), '63999727734', (SELECT usuario.id FROM usuario WHERE usuario.nome = 'kaio'));
 insert into telefone (id, nome, proprietario_id) values(nextval('hibernate_sequence'), '62978934834', (SELECT usuario.id FROM usuario WHERE usuario.nome = 'joao'));
 insert into telefone (id, nome, proprietario_id) values(nextval('hibernate_sequence'), '5563987504954', (SELECT usuario.id FROM usuario WHERE usuario.nome = 'antonio'));

 insert into compra (id, nome, usuario_id) values(1, 'teste', (SELECT usuario.id FROM usuario WHERE usuario.nome = 'kaio'));
 insert into compra (id, nome, usuario_id) values(2, 'teste', (SELECT usuario.id FROM usuario WHERE usuario.nome = 'kaio'));
 insert into compra (id, nome, usuario_id) values(3, 'teste', (SELECT usuario.id FROM usuario WHERE usuario.nome = 'janio'));
 insert into compra (id, nome, usuario_id) values(4, 'teste', (SELECT usuario.id FROM usuario WHERE usuario.nome = 'maria'));
 insert into compra (id, nome, usuario_id) values(5, 'teste', (SELECT usuario.id FROM usuario WHERE usuario.nome = 'otavio'));
 
 insert into itemcompra (id, produto_item_compra, quantidade, lista_itemcompra) values(1, (SELECT produto.id FROM produto WHERE produto.nome = 'bike1'), 5, 1);
 insert into itemcompra (id, produto_item_compra, quantidade, lista_itemcompra) values(2, (SELECT produto.id FROM produto WHERE produto.nome = 'bike2'), 2, 1);
 insert into itemcompra (id, produto_item_compra, quantidade, lista_itemcompra) values(3, (SELECT produto.id FROM produto WHERE produto.nome = 'bike3'), 1, 2);
 insert into itemcompra (id, produto_item_compra, quantidade) values(4, (SELECT produto.id FROM produto WHERE produto.nome = 'bike5'), 5);
 insert into itemcompra (id, produto_item_compra, quantidade) values(5, (SELECT produto.id FROM produto WHERE produto.nome = 'bike4'), 5);
 insert into itemcompra (id, produto_item_compra, quantidade) values(6, (SELECT produto.id FROM produto WHERE produto.nome = 'bike3'), 5);

