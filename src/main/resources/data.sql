-- ==============================
-- ROLES
-- ============================
INSERT INTO roles (name, description, is_deleted) values ('admin', 'Management All Information', 0),
                                             ('customer', 'The only view and booking all product', 0);


-- ==============================
-- USERS
-- ==============================
INSERT INTO users (username, password, full_name, email, phone, gender, address, is_deleted)
VALUES
    ('john_doe', '123456', 'John Doe', 'john@example.com', '0909123456', 1, '123 Main Street, HCM', 0),
    ('jane_smith', '654321', 'Jane Smith', 'jane@example.com', '0912345678', 0, '45 Nguyen Trai, Hanoi', 0),
    ('david_nguyen', 'abc123', 'David Nguyen', 'david@example.com', '0987654321', 1, '789 Le Loi, Da Nang', 0);


-- ==============================
-- BRANDS
-- ==============================
INSERT INTO brands (name, description, logo_url, is_deleted)
VALUES
    ('Apple', 'Apple brand specializing in electronics', 'https://example.com/logo/apple.png', 0),
    ('Nike', 'Nike brand for sportswear', 'https://example.com/logo/nike.png', 0),
    ('Samsung', 'Samsung brand for electronics and appliances', 'https://example.com/logo/samsung.png', 0);


-- ==============================
-- CATEGORIES
-- ==============================
INSERT INTO categories (name, parent_id, is_deleted)
VALUES
    ('Electronics', NULL, 0),
    ('Clothing', NULL, 0);

-- ==============================
-- PRODUCTS
-- ==============================
INSERT INTO products (name, description, price, brand_id, category_id) VALUES
                                                                               ( 'Air Force 1', 'Classic Nike shoes', 120.0, 1, 2),
                                                                               ( 'Stan Smith', 'Adidas classic sneaker', 110.0, 2, 2),
                                                                               ('Uniqlo Oxford Shirt', 'Casual white shirt', 35.0, 1, 1),
                                                                               ('Puma Future Rider', 'Stylish running shoes', 95.0, 2, 2),
                                                                               ( 'Nike Cargo Pants', 'Comfortable pants for sports', 60.0, 1, 3);

-- ==============================
-- PRODUCT IMAGES
-- ==============================
INSERT INTO product_images ( image_url, product_id) VALUES
                                                           ( 'https://cdn.example.com/images/airforce1.jpg', 4),
                                                           ( 'https://cdn.example.com/images/stansmith.jpg', 5),
                                                           ( 'https://cdn.example.com/images/oxfordshirt.jpg', 6),
                                                           ( 'https://cdn.example.com/images/futurerider.jpg', 4),
                                                           ( 'https://cdn.example.com/images/cargopants.jpg', 5);

-- ==============================
-- PRODUCT VARIANTS
-- ==============================
INSERT INTO product_variants (color, size, stock, product_id) VALUES
                                                                      ( 'White', '42', 15, 1),
                                                                      ( 'Green', '40', 20, 2),
                                                                      ( 'White', 'L', 30, 3),
                                                                      ( 'Black', '41', 25, 4),
                                                                      ( 'Blue', 'M', 18, 5);

-- ==============================
-- COUPONS
-- ==============================
INSERT INTO coupons (code, discount_percent, expiration_date) VALUES
                                                                      ( 'WELCOME10', 10, '2026-01-01'),
                                                                      ('SUMMER15', 15, '2026-06-30'),
                                                                      ( 'BLACKFRIDAY', 30, '2025-11-30');

-- ==============================
-- USER COUPONS
-- ==============================
INSERT INTO user_coupons ( user_id, coupon_id, used) VALUES
                                                            ( 2, 1, FALSE),
                                                            ( 2, 2, FALSE),
                                                            ( 3, 1, TRUE);

-- ==============================
-- CARTS
-- ==============================
INSERT INTO carts (user_id, total_price) VALUES
                                                 ( 2, 155.0),
                                                 ( 3, 60.0);

-- ==============================
-- CART ITEMS
-- ==============================
INSERT INTO cart_items (cart_id, product_variant_id, quantity, price) VALUES
                                                                              ( 1, 1, 1, 120.0),
                                                                              (1, 3, 1, 35.0),
                                                                              ( 2, 5, 1, 60.0);

-- ==============================
-- ORDERS
-- ==============================
INSERT INTO orders ( user_id, total_price, status, created_at) VALUES
                                                                      ( 2, 230.0, 'PENDING', CURRENT_TIMESTAMP),
                                                                      ( 3, 120.0, 'DELIVERED', CURRENT_TIMESTAMP);

-- ==============================
-- ORDER ITEMS
-- ==============================
INSERT INTO order_items ( order_id, product_variant_id, quantity, price) VALUES
                                                                                ( 1, 1, 1, 120.0),
                                                                                ( 1, 3, 2, 35.0),
                                                                                (2, 2, 1, 120.0);

-- ==============================
-- ADDRESSES
-- ==============================
INSERT INTO addresses ( user_id, full_name, phone, address_line, city, country) VALUES
                                                                                       ( 2, 'John Doe', '0987654321', '123 Lê Lợi', 'Hà Nội', 'Việt Nam'),
                                                                                       ( 3, 'Jane Doe', '0987654322', '456 Nguyễn Huệ', 'TP.HCM', 'Việt Nam');

-- ==============================
-- REVIEWS
-- ==============================
INSERT INTO reviews ( user_id, product_id, rating, comment) VALUES
                                                                   ( 2, 1, 5, 'Great shoes, super comfortable!'),
                                                                   ( 3, 3, 4, 'Good quality shirt, nice fit.');

-- ==============================
-- NOTIFICATIONS
-- ==============================
INSERT INTO notifications ( user_id, message, is_read, created_at) VALUES
                                                                          ( 2, 'Your order #1 has been placed successfully!', FALSE, CURRENT_TIMESTAMP),
                                                                          ( 2, 'Coupon SUMMER15 is about to expire!', FALSE, CURRENT_TIMESTAMP),
                                                                          ( 3, 'Your order #2 has been delivered.', TRUE, CURRENT_TIMESTAMP);

-- ==============================
-- AUDIT LOGS
-- ==============================
INSERT INTO audit_logs (action, details, ip_address, timestamp) VALUES
                                                                        ( 'LOGIN', 'Admin logged in successfully', '127.0.0.1', CURRENT_TIMESTAMP),
                                                                        ( 'CREATE_PRODUCT', 'New product added: Nike Cargo Pants', '127.0.0.1', CURRENT_TIMESTAMP),
                                                                        ( 'ERROR_404', 'Product not found with ID=99', '127.0.0.1', CURRENT_TIMESTAMP);
