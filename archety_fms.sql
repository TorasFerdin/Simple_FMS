-- DDL
CREATE DATABASE archety_fms;
USE archety_fms;

CREATE TABLE foods (
	id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    uuid CHAR(36) NOT NULL DEFAULT (UUID()) UNIQUE,
    food_name VARCHAR(100) NOT NULL,
    category VARCHAR(50) NOT NULL,
    calories INT,
    price DECIMAL(6,2),
    available BOOLEAN DEFAULT TRUE,
    expiration_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO foods (food_name, category, calories, price, available, expiration_date) VALUES
('Margherita Pizza Slice', 'Fast Food', 285, 3.50, TRUE, '2026-04-10'),
('Grilled Chicken Breast', 'Meat', 220, 6.90, TRUE, '2026-03-28'),
('Caesar Salad', 'Salad', 180, 5.40, TRUE, '2026-03-20'),
('Greek Yogurt', 'Dairy', 120, 1.80, TRUE, '2026-04-05'),
('Chocolate Muffin', 'Bakery', 410, 2.20, TRUE, '2026-03-18'),
('Whole Wheat Bread Loaf', 'Bakery', 250, 2.80, TRUE, '2026-04-15'),
('Orange Juice 250ml', 'Beverage', 110, 1.50, TRUE, '2026-04-01'),
('Beef Burger', 'Fast Food', 540, 7.50, TRUE, '2026-03-25'),
('Veggie Burger', 'Fast Food', 430, 6.80, TRUE, '2026-03-25'),
('Spaghetti Bolognese', 'Pasta', 620, 8.90, TRUE, '2026-03-30'),
('Chicken Noodle Soup', 'Soup', 190, 4.70, TRUE, '2026-03-22'),
('Tomato Basil Soup', 'Soup', 150, 4.10, TRUE, '2026-03-22'),
('Green Apple', 'Fruit', 80, 0.90, TRUE, '2026-03-19'),
('Banana', 'Fruit', 95, 0.70, TRUE, '2026-03-19'),
('Granola Bar', 'Snack', 210, 1.30, TRUE, '2026-09-01'),
('Potato Chips 50g', 'Snack', 270, 1.60, TRUE, '2027-01-15'),
('Latte Coffee 300ml', 'Beverage', 160, 2.90, TRUE, '2026-03-21'),
('Cappuccino 250ml', 'Beverage', 140, 2.70, TRUE, '2026-03-21'),
('Vanilla Ice Cream Cup', 'Dessert', 230, 2.40, TRUE, '2026-04-12'),
('Chocolate Brownie', 'Dessert', 320, 2.60, TRUE, '2026-03-26');

SELECT * FROM foods;





