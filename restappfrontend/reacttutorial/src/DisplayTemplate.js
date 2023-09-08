import React from "react"

export function DisplayTemplate({countryId, name, cityNum, onDelete, onView }) {

    const handleViewClick = () => {
        onView(countryId);
        console.log("DisplayTemplate countryId: " + countryId);
    };

    return (
        <div className="tableRow">
            <div className="tableCell">{countryId}</div>
            <div className="tableCell">{name}</div>
            <div className="tableCell">{cityNum}</div>
            <div className="tableCell">
                <div className="tableCell">
                    <button onClick={handleViewClick}>View</button>
                </div>
            </div>
            <div className="tableCell">
                <div className="tableCell">
                    <button onClick={onDelete}>Remove</button>
                </div>
            </div>
        </div>
    );
}