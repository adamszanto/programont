import React, { useState } from "react";

export default function CityAddForm({ onCityAdd }) {
    const [newCityName, setNewCityName] = useState("");

    const handleCityNameChange = (e) => {
        setNewCityName(e.target.value);
    };

    const handleAddCity = () => {
        onCityAdd(newCityName);
        setNewCityName("");
    };

    return (
        <div className="countryAddForm">
            <input
                type="text"
                placeholder="Add city"
                value={newCityName}
                onChange={handleCityNameChange}
                className="countryInput"
            />
            <button onClick={handleAddCity}>Add</button>
        </div>
    );
}
