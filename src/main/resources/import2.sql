 insert into usuario (email, nome, ativo, id, login, senha) values('kaiomacedo@unitins.br','kaio', true, 101, 'kaio','cBz32i3RfBAIaqKNkTfdDZLrqih7z94jKllRAMiOW+U+b3GTkGAVUJhWsP6LK8KfVkkei6cekKUJpS2bU7VqvQ==');
 insert into pessoafisica (id, cpf, sobrenome) values(101, '05562849259', 'hilowisck');

 insert into usuario_perfil (perfil, id_usuario) values (1, 101);
 insert into usuario_perfil (perfil, id_usuario) values (2, 101);

 insert into homeconfig (id, ativo) values (1, true);

 insert into carrossel (nome, ativo, lista_carrossel, id, link, image) values ('Promoção 1', true, 1, 1, '/detail/102', 'https://firebasestorage.googleapis.com/v0/b/bike-shop-830cf.appspot.com/o/2024_24_a_31_maio_Orgulho_Nerd_1920x450.jpg?alt=media&token=c96b7dab-cdf4-4fa6-a0e5-d1e9c7c8f25b');
 insert into carrossel (nome, ativo, lista_carrossel, id, link, image) values ('Promoção 2', true, 1, 2, '/detail/100', 'https://firebasestorage.googleapis.com/v0/b/bike-shop-830cf.appspot.com/o/carrossel%20promocao.png?alt=media&token=64a3a45b-9eba-4d15-adc9-ffcdaf3d29c8');
 insert into carrossel (nome, ativo, lista_carrossel, id, link, image) values ('Promoção 3', true, 1, 3, '/detail/101', 'https://firebasestorage.googleapis.com/v0/b/bike-shop-830cf.appspot.com/o/Captura%20de%20tela%202024-06-03%20235813.png?alt=media&token=3e3f099d-0c92-4e1e-a5fb-14a6bc5d9034');

insert into telefone (ativo, id, lista_telefones_usuario, proprietario_id, codigoArea, numero) values (true, 103, 101, 101, '63', '984142999');
insert into telefone (ativo, id, lista_telefones_usuario, proprietario_id, codigoArea, numero) values (true, 104, 101, 101, '63', '9841429349');
insert into telefone (ativo, id, lista_telefones_usuario, proprietario_id, codigoArea, numero) values (true, 105, 101, 101, '63', '982222900');