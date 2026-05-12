-- =========================================
-- DATABASE DELIVERY APP
-- =========================================

-- Criação do banco de dados
CREATE DATABASE delivery_db
WITH
OWNER = postgres
ENCODING = 'UTF8'
LC_COLLATE = 'Portuguese_Brazil.1252'
LC_CTYPE = 'Portuguese_Brazil.1252'
LOCALE_PROVIDER = 'libc'
TABLESPACE = pg_default
CONNECTION LIMIT = -1
IS_TEMPLATE = False;

-- =========================
-- TABELA RESTAURANTE
-- =========================
CREATE TABLE Restaurante (

                             id SERIAL PRIMARY KEY,

                             Nome VARCHAR(100) NOT NULL,

                             Endereco VARCHAR(200) NOT NULL,

                             CNPJ VARCHAR(14) NOT NULL,

                             Telefone VARCHAR(15) NOT NULL,

                             Categoria VARCHAR(55) NOT NULL,

                             Email VARCHAR(100) NOT NULL,

                             Senha VARCHAR(100) NOT NULL
);

-- =========================
-- TABELA CLIENTE
-- =========================
CREATE TABLE Cliente (

                         id SERIAL PRIMARY KEY,

                         Nome VARCHAR(100) NOT NULL,

                         CPF VARCHAR(11) NOT NULL,

                         Telefone VARCHAR(15) NOT NULL,

                         Email VARCHAR(100) NOT NULL,

                         Senha VARCHAR(100) NOT NULL
);

-- =========================
-- TABELA ENTREGADOR
-- =========================
CREATE TABLE Entregador (

                            id SERIAL PRIMARY KEY,

                            Nome VARCHAR(100) NOT NULL,

                            CPF VARCHAR(11) NOT NULL,

                            Telefone VARCHAR(15) NOT NULL,

                            Veiculo VARCHAR(30),

                            Status VARCHAR(20),

                            Email VARCHAR(100) NOT NULL,

                            Senha VARCHAR(100) NOT NULL
);

-- =========================
-- TABELA PRODUTO
-- =========================
CREATE TABLE Produto (

                         id SERIAL PRIMARY KEY,

                         Nome VARCHAR(100) NOT NULL,

                         Descricao VARCHAR(200),

                         Preco NUMERIC(10,2) NOT NULL,

                         Categoria VARCHAR(50) NOT NULL,

                         id_restaurante INTEGER NOT NULL,

                         CONSTRAINT fk_restaurante
                             FOREIGN KEY(id_restaurante)
                                 REFERENCES Restaurante(id)
);

-- =========================
-- TABELA PEDIDO
-- =========================
CREATE TABLE Pedido (

                        id SERIAL PRIMARY KEY,

                        Status VARCHAR(30) NOT NULL,

                        id_cliente INTEGER NOT NULL,

                        id_restaurante INTEGER NOT NULL,

                        id_entregador INTEGER,

                        CONSTRAINT fk_cliente
                            FOREIGN KEY(id_cliente)
                                REFERENCES Cliente(id),

                        CONSTRAINT fk_restaurante_pedido
                            FOREIGN KEY(id_restaurante)
                                REFERENCES Restaurante(id),

                        CONSTRAINT fk_entregador
                            FOREIGN KEY(id_entregador)
                                REFERENCES Entregador(id)
);

-- =========================
-- TABELA ITEM PEDIDO
-- =========================
CREATE TABLE ItemPedido (

                            id SERIAL PRIMARY KEY,

                            Quantidade INTEGER NOT NULL,

                            PrecoUnit NUMERIC(10,2) NOT NULL,

                            id_pedido INTEGER NOT NULL,

                            id_produto INTEGER NOT NULL,

                            CONSTRAINT fk_pedido
                                FOREIGN KEY(id_pedido)
                                    REFERENCES Pedido(id),

                            CONSTRAINT fk_produto
                                FOREIGN KEY(id_produto)
                                    REFERENCES Produto(id)
);