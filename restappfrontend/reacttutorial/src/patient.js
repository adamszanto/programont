import React from "react"

export default function PatientContact({ name, birthDate }) {
    return (
        <div>
            <div className="patienttableRow">
                <div className="tableCell">Name: {name}</div>
                <div className="tableCell">Date of birth: {birthDate}</div>
            </div>
        </div>
    );
}
