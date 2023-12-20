import React, { useState } from "react";


export default function CityDisplay({id, name, onCityEdit }) {
    const [cityIdToDelete, setCityIdToDelete] = useState(null);
    const [isEditing, setIsEditing] = useState(false);
    const [editedCityName, setEditedCityName] = useState(name);

    const handleEditClick = () => {
        setIsEditing(true);
    };

    const handleCancelEdit = () => {
        setIsEditing(false);
        setEditedCityName(name); // Visszaállítjuk az eredeti nevet
    };

    const handleSaveEdit = () => {
        // Elküldjük az új nevet a szülő komponensnek
        onCityEdit(id, editedCityName);
        setIsEditing(false);
    };

    const handleRemoveClick = () => {
        if (cityIdToDelete) {
            fetch(`http://localhost:8080/api/cc/city/${cityIdToDelete}`, {
                method: "DELETE",
            })
                .then((response) => {
                    if (!response.ok) {
                        throw new Error("Couldn't delete city");
                    }
                    // Handle deletion in your parent component (CountryDetailList)
                })
                .catch((error) => {
                    console.error("Error deleting city", error);
                });
        }
    };

    return (
        <div className="cityTable">
            <div className="cityTableRow cityRowRow">
                <div className="tableCell">{id}</div>
                {isEditing ? (
                    <div className="tableCell">
                        <input
                            type="text"
                            value={editedCityName}
                            onChange={(e) => setEditedCityName(e.target.value)}
                        />
                    </div>
                ) : (
                    <div className="tableCell">{name}</div>
                )}
                <div className="tableCell">
                    {isEditing ? (
                        <>
                            <button onClick={handleSaveEdit}>Save</button>
                            <button onClick={handleCancelEdit}>Cancel</button>
                        </>
                    ) : (
                        <button onClick={handleEditClick}>Edit</button>
                    )}
                </div>
            </div>
        </div>
    );
}