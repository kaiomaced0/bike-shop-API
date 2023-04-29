-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
 insert into usuario (id, nome, login, senha) values(nextval('hibernate_sequence'), 'kaio', 'kaio','123');
 insert into usuario (id, nome, login, senha) values(nextval('hibernate_sequence'), 'joao', 'joao','123');
 insert into usuario (id, nome, login, senha) values(nextval('hibernate_sequence'), 'antonio', 'antonio','123');
 insert into usuario (id, nome, login, senha) values(nextval('hibernate_sequence'), 'lucas', 'lucas','123');
 insert into usuario (id, nome, login, senha) values(nextval('hibernate_sequence'), 'janio', 'janio','123');
 insert into usuario (id, nome, login, senha) values(nextval('hibernate_sequence'), 'alberto', 'alberto','123');
 insert into usuario (id, nome, login, senha) values(nextval('hibernate_sequence'), 'maria', 'maria','123');
 insert into usuario (id, nome, login, senha) values(nextval('hibernate_sequence'), 'ana', 'ana','123');
 insert into usuario (id, nome, login, senha) values(nextval('hibernate_sequence'), 'joana', 'joana','123');
 insert into usuario (id, nome, login, senha) values(nextval('hibernate_sequence'), 'kamila', 'kamila','123');
 insert into usuario (id, nome, login, senha) values(nextval('hibernate_sequence'), 'amanda', 'amanda','123');
 insert into usuario (id, nome, login, senha) values(nextval('hibernate_sequence'), 'isabela', 'isabela','123');
 insert into usuario (id, nome, login, senha) values(nextval('hibernate_sequence'), 'gabriel', 'gabriel','123');
 insert into usuario (id, nome, login, senha) values(nextval('hibernate_sequence'), 'otavio', 'otavio','123');
 insert into usuario (id, nome, login, senha) values(nextval('hibernate_sequence'), 'rubens', 'rubens','123');
 insert into usuario (id, nome, login, senha) values(nextval('hibernate_sequence'), 'ordete', 'ordete','123');
 insert into usuario (id, nome, login, senha) values(1, 'teste', 'teste','123');

 insert into produto (id, nome, estoque, preco) values(nextval('hibernate_sequence'), 'bike 1', 50, 1020.0);
 insert into produto (id, nome, estoque, preco) values(nextval('hibernate_sequence'), 'bike 2', 30, 3040.0);
 insert into produto (id, nome, estoque, preco) values(nextval('hibernate_sequence'), 'bike 3', 20, 2300.0);

 insert into cupom (id, quantidade, codigo, valordesconto) values(nextval('hibernate_sequence'), 50, '#desconto20', 20.0);
 insert into cupom (id, quantidade, codigo, valordesconto) values(nextval('hibernate_sequence'), 100, '#desconto10', 10.0);
 insert into cupom (id, quantidade, codigo, valordesconto) values(nextval('hibernate_sequence'), 80, '#desconto40', 40.0);

 insert into estado (id, sigla_estado, nome) values(nextval('hibernate_sequence'), 'TO', 'Tocantins');
 insert into estado (id, sigla_estado, nome) values(nextval('hibernate_sequence'), 'GO', 'Goias');
 insert into estado (id, sigla_estado, nome) values(nextval('hibernate_sequence'), 'PA', 'Para');
 insert into estado (id, sigla_estado, nome) values(nextval('hibernate_sequence'), 'MG', 'Minas Gerais');

 insert into cidade (id, nome, estado_id) values(nextval('hibernate_sequence'), 'Palmas', (SELECT estado.id FROM estado WHERE estado.nome = 'Tocantins'));
 insert into cidade (id, nome, estado_id) values(nextval('hibernate_sequence'), 'Goiania', (SELECT estado.id FROM estado WHERE estado.nome = 'Goias'));
 insert into cidade (id, nome, estado_id) values(nextval('hibernate_sequence'), 'belem', (SELECT estado.id FROM estado WHERE estado.nome = 'Para'));

 insert into endereco (id, usuario_dono_endereco, descricao) values(nextval('hibernate_sequence'), (SELECT usuario.id FROM usuario WHERE usuario.nome = 'kaio'), 'aaaaaaaaaakdkskdk endereco legal, perto daquele lugar la');
 insert into endereco (id, usuario_dono_endereco, descricao) values(nextval('hibernate_sequence'), (SELECT usuario.id FROM usuario WHERE usuario.nome = 'kaio'), 'aaaaaaaaaakdkskdk endereco legal, perto daquele lugar la');
 insert into endereco (id, usuario_dono_endereco, descricao) values(nextval('hibernate_sequence'), (SELECT usuario.id FROM usuario WHERE usuario.nome = 'kaio'), 'aaaaaaaaaakdkskdk endereco legal, perto daquele lugar la');
 insert into endereco (id, usuario_dono_endereco, descricao) values(nextval('hibernate_sequence'), (SELECT usuario.id FROM usuario WHERE usuario.nome = 'kaio'), 'aaaaaaaaaakdkskdk endereco legal, perto daquele lugar la');
 insert into endereco (id, usuario_dono_endereco, descricao) values(nextval('hibernate_sequence'), (SELECT usuario.id FROM usuario WHERE usuario.nome = 'kaio'), 'aaaaaaaaaakdkskdk endereco legal, perto daquele lugar la');

 insert into telefone (id, nome) values(nextval('hibernate_sequence'), 'teste');
 insert into compra (id, nome) values(nextval('hibernate_sequence'), 'teste');