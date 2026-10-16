-- Categories & Products (quan hệ OneToMany / ManyToOne)
CREATE TABLE IF NOT EXISTS catrgories (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS products (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    price DECIMAL(38, 2),
    status VARCHAR(255),
    category_id BIGINT,
    CONSTRAINT fk_products_category FOREIGN KEY (category_id) REFERENCES catrgories (id)
);
