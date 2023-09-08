import React, { useState } from "react";

export default function CountryAddForm({ onCountryAdd }) {
    const [newCountryName, setNewCountryName] = useState("");

    const handleCountryNameChange = (e) => {
        setNewCountryName(e.target.value);
    };

    const handleAddCountry = () => {
        onCountryAdd(newCountryName);
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