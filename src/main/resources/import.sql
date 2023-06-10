his file allow to e SQL commands that will be emitted in test and dev.
-- The commands are coted as their support dependf the database
 insert into usuario (id, nome, login, senha) values(101, 'kaio', 'kaio','cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==');
 insert into usuario (nome, login, senha) values('joao', 'joao','cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==');
 insert into usuario (nome, login, senha) values('antonio', 'antonio','cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==');
 insert into usuario (nome, login, senha) values('lucas', 'lucas','cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==');
 insert into usuario (nome, login, senha) values('kuba event', 'janio','cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==');
 insert into usuario (nome, login, senha) values('imports imports', 'alberto','cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==');
 insert into usuario (nome, login, senha) values('al', 'maria','cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==');
 insert into usuario (nome, login, senha) values('AEDAO', 'ana','cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==');
 insert into usuario (nome, login, senha) values('joana', 'joana','cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==');
 insert into usuario (nome, login, senha) values( 'kamila', 'kamila','cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==');
 insert into usuario (nome, login, senha) values( 'amanda', 'amanda','cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==');
 insert into usuario (nome, login, senha) values( 'isabela', 'isabela','cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==');
 insert into usuario (nome, login, senha) values( 'gabriel', 'gabriel','cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==');
 insert into usuario (nome, login, senha) values( 'otavio', 'otavio','cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==');
 insert into usuario (nome, login, senha) values( 'rubens', 'rubens','cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==');
 insert into usuario (nome, login, senha) values( 'ordete', 'ordete','cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==');
 insert into usuario (id, nome, login, senha) values(100, 'teste', 'teste','cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==');
 insert into pessoafisica (id, cpf, sobrenome, data_nascimento) values((SELECT usuario.id FROM usuario WHERE usuario.nome = 'teste'), '000000', 'hilowisck', '00/00/2121');
 insert into pessoafisica (id, cpf, sobrenome, data_nascimento) values(2, '020323082', 'hilowisck', '04/12/2002');
 insert into pessoafisica (id, cpf, sobrenome, data_nascimento) values(3, '988734434', 'hilowisck', '27/11/2002');
 insert into pessoafisica (id, cpf, sobrenome, data_nascimento) values(4, '971922434', 'hilowisck', '08/12/1978');

 insert into pessoajuridica (id, cnpj, nomefantasia) values((SELECT usuario.id FROM usuario WHERE usuario.nome = 'kaio'), '00.000.000.0001/00', 'EMPRESA 1');
 insert into pessoajuridica (id, cnpj, nomefantasia) values(6, '0032301870001/02', 'EMPRESA 2');
 insert into pessoajuridica (id, cnpj, nomefantasia) values(7, '0990023123/00', 'EMPRESA 3');
 insert into pessoajuridica (id, cnpj, nomefantasia) values(8, '123927321732','EMPRESA 4');

 insert into produto (id,nome, estoque, preco) values(100, 'bike 1', 50, 1020.0);
 insert into produto (id,nome, estoque, preco) values(101, 'bike 2', 30, 3040.0);
 insert into produto (id,nome, estoque, preco) values(102, 'bike 3', 20, 2300.0);
 insert into produto (id,nome, estoque, preco) values(103, 'bike 4', 20, 2300.0);
 insert into produto (id,nome, estoque, preco) values(104, 'bike 5', 20, 2300.0);

 insert into bike (id, tamanho) values((SELECT produto.id FROM produto WHERE produto.nome = 'bike 1'), 1);
 insert into bike (id, tamanho) values((SELECT produto.id FROM produto WHERE produto.nome = 'bike 2'), 2);
 insert into bike (id, tamanho) values((SELECT produto.id FROM produto WHERE produto.nome = 'bike 3'), 2);
 insert into bike (id, tamanho) values((SELECT produto.id FROM produto WHERE produto.nome = 'bike 4'), 3);
 insert into bike (id, tamanho) values((SELECT produto.id FROM produto WHERE produto.nome = 'bike 5'), 4);

 insert into cupom (id, quantidade, codigo, valordesconto) values(100, 50, '#desconto20', 20.0);
 insert into cupom (quantidade, codigo, valordesconto) values(100, '#desconto10', 10.0);
 insert into cupom (quantidade, codigo, valordesconto) values(80, '#desconto40', 40.0);

 insert into estado (id, sigla_estado, nome) values(100, 'TO', 'Tocantins');
 insert into estado (id, sigla_estado, nome) values(102, 'GO', 'Goias');
 insert into estado (id, sigla_estado, nome) values(102, 'PA', 'Para');
 insert into estado (id, sigla_estado, nome) values(103, 'MG', 'Minas Gerais');

 insert into cidade (id, nome, estado_id) values(100, 'Palmas', (SELECT estado.id FROM estado WHERE estado.nome = 'Tocantins'));
 insert into cidade (id, nome, estado_id) values(101, 'Goiania', (SELECT estado.id FROM estado WHERE estado.nome = 'Goias'));
 insert into cidade (id, nome, estado_id) values(102, 'belem', (SELECT estado.id FROM estado WHERE estado.nome = 'Para'));

 insert into endereco (id, usuario_dono_endereco, descricao) values(100, 1, 'aaaaaaaaaakdkskdk endereco legal, perto daquele lugar la');
 insert into endereco (id, usuario_dono_endereco, descricao) values(102, 2, 'aaaaaaaaaakdkskdk endereco legal, perto daquele lugar la');
 insert into endereco (id, usuario_dono_endereco, descricao) values(103, 3, 'aaaaaaaaaakdkskdk endereco legal, perto daquele lugar la');
 insert into endereco (id, usuario_dono_endereco, descricao) values(4, 4, 'aaaaaaaaaakdkskdk endereco legal, perto daquele lugar la');
 insert into endereco (id, usuario_dono_endereco, descricao) values(5, 5, 'aaaaaaaaaakdkskdk endereco legal, perto daquele lugar la');

 insert into telefone (id, codigoarea, numero, proprietario_id) values(100, '63', '999727734', (SELECT usuario.id FROM usuario WHERE usuario.nome = 'kaio'));
 insert into telefone (id, codigoarea, numero, proprietario_id) values(101, '62', '978934834', (SELECT usuario.id FROM usuario WHERE usuario.nome = 'joao'));
 insert into telefone (id, codigoarea, numero, proprietario_id) values(102, '63', '987504954', (SELECT usuario.id FROM usuario WHERE usuario.nome = 'antonio'));

 insert into compra (id, nome, usuario_id) values(100, 'teste', (SELECT usuario.id FROM usuario WHERE usuario.nome = 'kaio'));
 insert into compra (id, nome, usuario_id) values(102, 'teste', (SELECT usuario.id FROM usuario WHERE usuario.nome = 'kaio'));
 insert into compra (id, nome, usuario_id) values(103, 'teste', (SELECT usuario.id FROM usuario WHERE usuario.nome = 'janio'));
 insert into compra (id, nome, usuario_id) values(104, 'teste', (SELECT usuario.id FROM usuario WHERE usuario.nome = 'maria'));
 insert into compra (id, nome, usuario_id) values(105, 'teste', (SELECT usuario.id FROM usuario WHERE usuario.nome = 'otavio'));
 
 insert into itemcompra (id, produto_item_compra, quantidade, lista_itemcompra) values(100, (SELECT produto.id FROM produto WHERE produto.nome = 'bike1'), 5, 100);
 insert into itemcompra (id, produto_item_compra, quantidade, lista_itemcompra) values(101, (SELECT produto.id FROM produto WHERE produto.nome = 'bike2'), 2, 100);
 insert into itemcompra (id, produto_item_compra, quantidade, lista_itemcompra) values(102, (SELECT produto.id FROM produto WHERE produto.nome = 'bike3'), 1, 102);
 insert into itemcompra (id, produto_item_compra, quantidade) values(103, (SELECT produto.id FROM produto WHERE produto.nome = 'bike5'), 5);
 insert into itemcompra (id, produto_item_compra, quantidade) values(104, (SELECT produto.id FROM produto WHERE produto.nome = 'bike4'), 5);
 insert into itemcompra (id, produto_item_compra, quantidade) values(105, (SELECT produto.id FROM produto WHERE produto.nome = 'bike3'), 5);

 insert into avaliacao (id, usuario_id, produto_id, estrelas, comentario) values(100, 1, 101, 5, 'Bom');
 insert into avaliacao (id, usuario_id, produto_id, estrelas, comentario) values(102, 1, 102, 5, 'Legal');
 insert into avaliacao (id, usuario_id, produto_id, estrelas, comentario) values(103, 1, 102, 5, 'asdasdsdads');
 insert into avaliacao (id, usuario_id, produto_id, estrelas, comentario) values(104, 1, 101, 5, 'aslsldlsdl 213213j jj');

 insert into usuario_perfil (perfil, id_usuario) values (1, (SELECT usuario.id FROM usuario WHERE usuario.nome = 'teste'));
 insert into usuario_perfil (perfil, id_usuario) values (1, (SELECT usuario.id FROM usuario WHERE usuario.nome = 'kaio'));
 insert into usuario_perfil (perfil, id_usuario) values (2, (SELECT usuario.id FROM usuario WHERE usuario.nome = 'kaio'));
 insert into usuario_perfil (perfil, id_usuario) values (2, (SELECT usuario.id FROM usuario WHERE usuario.nome = 'teste'));

 insert into cartao (id, usuario_id) values (100, 100);