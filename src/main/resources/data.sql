-- Create tables based on DBML schema
CREATE TABLE clients (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255),
    password VARCHAR(255),
    created_at TIMESTAMP,
    status VARCHAR(50),
    stripe_account_id VARCHAR(255)
);

CREATE TABLE staff (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(255),
    password VARCHAR(255),
    type VARCHAR(50)
);
CREATE TABLE promo (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    type VARCHAR(50),
    discount VARCHAR(50),
    duration VARCHAR(50),
    code VARCHAR(50)
);

CREATE TABLE clubs (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    logo_url VARCHAR(255),
    client_id INTEGER,
    status VARCHAR(50),
    created_at TIMESTAMP,
    user_id INTEGER,
    club_tag VARCHAR(50) UNIQUE,
    staff_id INTEGER,
    FOREIGN KEY (client_id) REFERENCES clients(id),
    FOREIGN KEY (staff_id) REFERENCES staff(id)
);
CREATE TABLE membership (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    price VARCHAR(50) NOT NULL,
    charge_interval VARCHAR(50) NOT NULL,
    promo_id INTEGER,
    club_tag VARCHAR(50),
    FOREIGN KEY (promo_id) REFERENCES promo(id),
    FOREIGN KEY (club_tag) REFERENCES clubs(club_tag)
);



CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    pictureURL VARCHAR(255),
    waiverSignature VARCHAR(255),
    status VARCHAR(50),
    membership_id INTEGER,
    referral_id VARCHAR(50),
    club_id VARCHAR(50),
    qrcodeToken VARCHAR(255),
    FOREIGN KEY (membership_id) REFERENCES membership(id)
);


-- Insert sample data
INSERT INTO clients (email, password, created_at, status, stripe_account_id)
VALUES
        ('john@fitnessgym.com', 'password123', CURRENT_TIMESTAMP, 'active', 'stripe_001'),
    ('client2@example.com', 'password456', CURRENT_TIMESTAMP, 'inactive', 'stripe_002');

INSERT INTO staff (email, password, type)
VALUES
    ('staff1@example.com', 'staffpass1', 'manager'),
    ('staff2@example.com', 'staffpass2', 'trainer');

INSERT INTO promo (title, type, discount, duration, code)
VALUES
    ('Summer Discount', 'percentage', '20', '3 months', 'SUMMER20'),
    ('Annual Promo', 'fixed', '50', '12 months', 'ANNUAL50');
INSERT INTO clubs (title, logo_url, client_id, status, created_at, user_id, club_tag, staff_id)
VALUES
    ('Fitness Club A', 'http://example.com/logoA.png', 1, 'active', CURRENT_TIMESTAMP, 1, 'CLUB001', 1),
    ('Fitness Club B', 'http://example.com/logoB.png', 1, 'active', CURRENT_TIMESTAMP, 2, 'CLUB002', 2);
INSERT INTO membership (title, price, charge_interval, promo_id, club_tag)
VALUES
    ('Basic Plan', '29.99', 'monthly', NULL, 'CLUB001'),
    ('Premium Plan', '59.99', 'monthly', 1, 'CLUB001'),
    ('Annual Plan', '499.99', 'yearly', 2, 'CLUB002');

INSERT INTO users (first_name, last_name, email, password, pictureURL, waiverSignature, status, membership_id, referral_id, club_id, qrcodeToken)
VALUES
    ('John', 'Doe', 'john.doe@example.com', 'userpass1', 'http://example.com/john.jpg', 'JohnD2025', 'active', 1, 'REF001', 'CLUB001', 'QR001'),
    ('Jane', 'Smith', 'jane.smith@example.com', 'userpass2', 'http://example.com/jane.jpg', 'JaneS2025', 'inactive', 1, 'REF002', 'CLUB001', 'QR002'),
    ('Jane', 'Smith', 'jane.smith@example.com', 'userpass2', 'http://example.com/jane.jpg', 'JaneS2025', 'suspended', 1, 'REF002', 'CLUB001', 'QR003'),
    ('Jane', 'Smith', 'jane.smith@example.com', 'userpass2', 'http://example.com/jane.jpg', 'JaneS2025', 'active', 1, 'REF002', 'CLUB002', 'QR004'),
    ('Jane', 'Smith', 'jane.smith@example.com', 'userpass2', 'http://example.com/jane.jpg', 'JaneS2025', 'active', 1, 'REF002', 'CLUB002', 'QR005'),
    ('Jane', 'Smith', 'jane.smith@example.com', 'userpass2', 'http://example.com/jane.jpg', 'JaneS2025', 'active', 2, 'REF002', 'CLUB002', 'QR006'),
    ('Jane', 'Smith', 'jane.smith@example.com', 'userpass2', 'http://example.com/jane.jpg', 'JaneS2025', 'active', 2, 'REF002', 'CLUB002', 'QR007');

