import React, { useState } from 'react';
import './components/GameCard.css'; // Itt lehet definiálni az alap CSS-t
import axios from 'axios';

function GameCard({ game, onRent }) {
    const [email, setEmail] = useState('');
    const [renting, setRenting] = useState(false);

    const handleRent = () => {
        setRenting(true);
    };

    const handleConfirmRent = () => {
        axios
            .post(`http://localhost:8080/api/games/rent/${game.id}`, { email })
            .then((response) => {
                if (response.data.success) {
                    onRent(game.id);
                    setRenting(false);
                    setEmail('');
                }
            })
            .catch((error) => console.error('Error renting game:', error));
    };

    return (
        <div className={`game-card ${game.rented ? 'rented' : ''}`}>
            <img src={game.coverImageURL} alt={game.name} />
            <h2>{game.name}</h2>
            <p>Year: {game.year}</p>
            <p>Platform: {game.releasedPlatform}</p>
            {game.rented ? (
                <p className="rent-status">Rented</p>
            ) : (
                <div>
                    {!renting ? (
                        <button onClick={handleRent}>Rent it</button>
                    ) : (
                        <div>
                            <input
                                type="email"
                                placeholder="Email address"
                                value={email}
                                onChange={(e) => setEmail(e.target.value)}
                            />
                            <button onClick={handleConfirmRent}>Rent it</button>
                        </div>
                    )}
                </div>
            )}
        </div>
    );
}

export default GameCard;
