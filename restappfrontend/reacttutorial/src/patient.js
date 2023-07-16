import React from "react"

export default function PatientContact({ name, birthDate }) {
    return (
        <div>
            <div className="patienttableRow">
                <div className="tableCell">{name}</div>
                <div className="tableCell">{birthDate}</div>
            </div>
        </div>
    );
}
