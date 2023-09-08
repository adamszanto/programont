import React, { useState } from "react";

export default function CountryAddForm({ onCountryAdd }) {
    const [newCountryName, setNewCountryName] = useState("");

    const handleCountryNameChange = (e) => {
        setNewCountryName(e.target.value);
    };

    const handleAddCountry = () => {
        // Továbbítsd az új ország nevét az onCountryAdd callback függvénynek
        onCountryAdd(newCountryName);
        // Töröld a mező tartalmát
        setNewCountryName("");
    };

    return (
        <div className="countryAddForm">
            <input
                type="text"
                placeholder="Add Country"
                value={newCountryName}
                onChange={handleCountryNameChange}
            />
            <button onClick={handleAddCountry}>Add</button>
        </div>
    );
}