CREATE TABLE IF NOT EXISTS Advises(
    id SERIAL,
    date_match DATE NOT NULL,
    matches INT NOT NULL,
    color_card VARCHAR(100) NOT NULL,
    player_id INT NOT null,
    PRIMARY KEY(id),
    FOREIGN KEY(player_id) REFERENCES player(id)

    );