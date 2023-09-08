import React, { useState } from "react";


export default function CityDisplay({id, name }) {
    const [cityIdToDelete, setCityIdToDelete] = useState(null);

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
                <div className="tableCell">{name}</div>
                <div className="tableCell">
                    <button onClick={() => setCityIdToDelete(id)}>Remove</button>
                </div>
            </div>
        </div>
    );
}