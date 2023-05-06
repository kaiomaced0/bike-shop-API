-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
 insert into usuario (id, nome, login, senha) values(17, 'kaio', 'kaio','123');
 insert into usuario (id, nome, login, senha) values(2, 'joao', 'joao','123');
 insert into usuario (id, nome, login, senha) values(3, 'antonio', 'antonio','123');
 insert into usuario (id, nome, login, senha) values(4, 'lucas', 'lucas','123');
 insert into usuario (id, nome, login, senha) values(5, 'kuba event', 'janio','123');
 insert into usuario (id, nome, login, senha) values(6, 'imports imports', 'alberto','123');
 insert into usuario (id, nome, login, senha) values(7, 'al', 'maria','123');
 insert into usuario (id, nome, login, senha) values(8, 'AEDAO', 'ana','123');
 insert into usuario (id, nome, login, senha) values(9, 'joana', 'joana','123');
 insert into usuario (id, nome, login, senha) values(10, 'kamila', 'kamila','123');
 insert into usuario (id, nome, login, senha) values(11, 'amanda', 'amanda','123');
 insert into usuario (id, nome, login, senha) values(12, 'isabela', 'isabela','123');
 insert into usuario (id, nome, login, senha) values(13, 'gabriel', 'gabriel','123');
 insert into usuario (id, nome, login, senha) values(14, 'otavio', 'otavio','123');
 insert into usuario (id, nome, login, senha) values(15, 'rubens', 'rubens','123');
 insert into usuario (id, nome, login, senha) values(16, 'ordete', 'ordete','123');
 insert into usuario (id, nome, login, senha) values(1, 'teste', 'teste','123');
 
 insert into pessoafisica (id, cpf, sobrenome, data_nascimento) values(1, '000000', 'hilowisck', '00/00/2121');
 insert into pessoafisica (id, cpf, sobrenome, data_nascimento) values(2, '020323082', 'hilowisck', '04/12/2002');
 insert into pessoafisica (id, cpf, sobrenome, data_nascimento) values(3, '988734434', 'hilowisck', '27/11/2002');
 insert into pessoafisica (id, cpf, sobrenome, data_nascimento) values(4, '971922434', 'hilowisck', '08/12/1978');

 insert into pessoajuridica (id, cnpj, nomefantasia) values(5, '00.000.000.0001/00', 'EMPRESA 1');
 insert into pessoajuridica (id, cnpj, nomefantasia) values(6, '0032301870001/02', 'EMPRESA 2');
 insert into pessoajuridica (id, cnpj, nomefantasia) values(7, '0990023123/00', 'EMPRESA 3');
 insert into pessoajuridica (id, cnpj, nomefantasia) values(8, '123927321732','EMPRESA 4');

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

 insert into endereco (id, usuario_dono_endereco, descricao) values(1, 1, 'aaaaaaaaaakdkskdk endereco legal, perto daquele lugar la');
 insert into endereco (id, usuario_dono_endereco, descricao) values(2, 2, 'aaaaaaaaaakdkskdk endereco legal, perto daquele lugar la');
 insert into endereco (id, usuario_dono_endereco, descricao) values(nextval('hibernate_sequence'), 3, 'aaaaaaaaaakdkskdk endereco legal, perto daquele lugar la');
 insert into endereco (id, usuario_dono_endereco, descricao) values(nextval('hibernate_sequence'), 4, 'aaaaaaaaaakdkskdk endereco legal, perto daquele lugar la');
 insert into endereco (id, usuario_dono_endereco, descricao) values(nextval('hibernate_sequence'), 5, 'aaaaaaaaaakdkskdk endereco legal, perto daquele lugar la');

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

 insert into avaliacao (id, usuario_id, produto_id, estrelas, comentario) values(1, 1, 1, 5, 'Bom');