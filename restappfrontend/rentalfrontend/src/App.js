import React, { useState, useEffect } from 'react';
import GameCard from './GameCard';
import axios from 'axios';

function App() {
    const [games, setGames] = useState([]);
    const [selectedGame, setSelectedGame] = useState(null);
    const [email, setEmail] = useState('');
    const [rentedGames, setRentedGames] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/games/all')
            .then((response) => setGames(response.data))
            .catch((error) => console.error('Error fetching data:', error));
    }, []);

    const handleRent = (gameId) => {
        setSelectedGame(gameId);
    };

    const handleConfirmRent = () => {
        axios.post(`http://localhost:8080/api/games/rent/${selectedGame}`, { email })
            .then((response) => {
                if (response.data.success) {
                    const updatedRentedGames = [...rentedGames, selectedGame];
                    setRentedGames(updatedRentedGames);
                    setSelectedGame(null);
                    setEmail('');
                }
            })
            .catch((error) => console.error('Error renting game:', error));
    };

    return (
        <div className="game-app">
            <h1>Retro Rental List</h1>
            <div className="game-card-grid">
                {games.map((game) => (
                    <GameCard
                        key={game.id}
                        game={game}
                        onRent={handleRent}
                        rented={rentedGames.includes(game.id)}
                    />
                ))}
            </div>
            {selectedGame !== null && (
                <div className="rent-form">
                    <h2>Renting: {games.find(game => game.id === selectedGame).name}</h2>
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
    );
}

export default App;
