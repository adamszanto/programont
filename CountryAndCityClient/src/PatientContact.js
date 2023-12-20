import React from "react"

export default function PatientContact({id, name, birthDate }) {
    return (
        <div className="patientTable">
            <div className="patienttableRow patientRow">
                <div className="tableCell">{id}</div>
                <div className="tableCell">{name}</div>
                <div className="tableCell">{birthDate}</div>
            </div>
        </div>
    );
}
