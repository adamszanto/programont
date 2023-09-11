import React, { useState } from "react";


export default function CityDisplay({id, name, onCityEdit, onCityRemove }) {
    const [cityIdToDelete, setCityIdToDelete] = useState(null);
    const [isEditing, setIsEditing] = useState(false);
    const [editedCityName, setEditedCityName] = useState(name);

    const handleEditClick = () => {
        setIsEditing(true);
    };

    const handleCancelEdit = () => {
        setIsEditing(false);
        setEditedCityName(name);
    };

    const handleSaveEdit = () => {
        onCityEdit(id, editedCityName);
        setIsEditing(false);
    };

    const handleRemoveClick = () => {
        onCityRemove(id);
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
                <div className="tableCell">
                    <button onClick={handleRemoveClick}>Remove</button>
                </div>
            </div>
        </div>
    );
}