-- =========================================
-- POVOAMENTO COMPLETO DATABASE DELIVERY
-- =========================================

-- =========================================
-- RESTAURANTES
-- =========================================

INSERT INTO Restaurante
(Nome, Endereco, CNPJ, Telefone, Categoria, Email, Senha)
VALUES
    ('Burger Palace', 'Rua das Burgers 100', '11111111111111', '11999990001', 'Hamburgueria', 'burger@delivery.com', '123'),

    ('Pizza Express', 'Av Paulista 200', '22222222222222', '11999990002', 'Pizzaria', 'pizza@delivery.com', '123'),

    ('Sushi House', 'Rua Japão 300', '33333333333333', '11999990003', 'Japonesa', 'sushi@delivery.com', '123'),

    ('Açaí Mania', 'Rua Tropical 400', '44444444444444', '11999990004', 'Açaí', 'acai@delivery.com', '123'),

    ('Churras Grill', 'Rua do Fogo 500', '55555555555555', '11999990005', 'Churrascaria', 'churras@delivery.com', '123');

-- =========================================
-- CLIENTES
-- =========================================

INSERT INTO Cliente
(Nome, CPF, Telefone, Email, Senha)
VALUES
    ('João Silva', '11111111111', '11988880001', 'joao@gmail.com', '123'),

    ('Maria Souza', '22222222222', '11988880002', 'maria@gmail.com', '123'),

    ('Carlos Lima', '33333333333', '11988880003', 'carlos@gmail.com', '123'),

    ('Ana Paula', '44444444444', '11988880004', 'ana@gmail.com', '123'),

    ('Fernanda Costa', '55555555555', '11988880005', 'fernanda@gmail.com', '123');

-- =========================================
-- ENTREGADORES
-- =========================================

INSERT INTO Entregador
(Nome, CPF, Telefone, Veiculo, Status, Email, Senha)
VALUES
    ('Lucas Moto', '99999999991', '11977770001', 'Moto', 'DISPONIVEL', 'lucas@delivery.com', '123'),

    ('Pedro Bike', '99999999992', '11977770002', 'Bike', 'DISPONIVEL', 'pedro@delivery.com', '123'),

    ('Marcos Carro', '99999999993', '11977770003', 'Carro', 'EM_ENTREGA', 'marcos@delivery.com', '123'),

    ('Juliana Flash', '99999999994', '11977770004', 'Moto', 'DISPONIVEL', 'juliana@delivery.com', '123');

-- =========================================
-- PRODUTOS
-- =========================================

INSERT INTO Produto
(Nome, Descricao, Preco, Categoria, id_restaurante)
VALUES

-- Burger Palace
('X-Burguer', 'Hamburguer artesanal com queijo', 25.90, 'Lanche', 1),

('Batata Frita', 'Porção grande', 18.00, 'Porção', 1),

('Refrigerante Cola', 'Lata 350ml', 6.50, 'Bebida', 1),

-- Pizza Express
('Pizza Calabresa', 'Pizza grande de calabresa', 45.90, 'Pizza', 2),

('Pizza Mussarela', 'Pizza grande de mussarela', 42.50, 'Pizza', 2),

('Pizza Portuguesa', 'Pizza portuguesa especial', 49.90, 'Pizza', 2),

-- Sushi House
('Combo Sushi 20 peças', 'Combo variado', 59.90, 'Japonesa', 3),

('Temaki Salmão', 'Temaki grande', 28.00, 'Japonesa', 3),

('Hot Roll', 'Porção hot roll', 32.00, 'Japonesa', 3),

-- Açaí Mania
('Açaí 500ml', 'Açaí com banana', 22.00, 'Açaí', 4),

('Açaí 700ml', 'Açaí completo', 30.00, 'Açaí', 4),

('Vitamina Banana', 'Banana e leite', 14.50, 'Bebida', 4),

-- Churras Grill
('Picanha Completa', 'Picanha + arroz + fritas', 79.90, 'Churrasco', 5),

('Costela BBQ', 'Costela barbecue', 69.90, 'Churrasco', 5),

('Coca-Cola 2L', 'Refrigerante 2 litros', 14.00, 'Bebida', 5);

-- =========================================
-- PEDIDOS
-- =========================================

INSERT INTO Pedido
(Status, id_cliente, id_restaurante, id_entregador)
VALUES

    ('RECEBIDO', 1, 2, NULL),

    ('EM_PREPARO', 2, 1, NULL),

    ('PRONTO', 3, 3, NULL),

    ('EM_ENTREGA', 4, 5, 1),

    ('ENTREGUE', 5, 4, 2),

    ('CANCELADO', 1, 1, NULL);

-- =========================================
-- ITENS DOS PEDIDOS
-- =========================================

INSERT INTO ItemPedido
(Quantidade, PrecoUnit, id_pedido, id_produto)
VALUES

-- Pedido 1
(2, 45.90, 1, 4),
(1, 6.50, 1, 3),

-- Pedido 2
(1, 25.90, 2, 1),
(1, 18.00, 2, 2),

-- Pedido 3
(1, 59.90, 3, 7),
(2, 28.00, 3, 8),

-- Pedido 4
(1, 79.90, 4, 13),
(1, 14.00, 4, 15),

-- Pedido 5
(2, 22.00, 5, 10),

-- Pedido 6
(1, 25.90, 6, 1);

-- =========================================
-- CONSULTAS TESTE
-- =========================================

-- Ver restaurantes
SELECT * FROM Restaurante;

-- Ver clientes
SELECT * FROM Cliente;

-- Ver entregadores
SELECT * FROM Entregador;

-- Ver produtos
SELECT * FROM Produto;

-- Ver pedidos
SELECT * FROM Pedido;

-- Ver itens dos pedidos
SELECT * FROM ItemPedido;