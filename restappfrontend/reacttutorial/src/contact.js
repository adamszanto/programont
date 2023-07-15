import React from "react"

export default function Contact({doctorId, name, specialization, patientNum}) {
    return (
            <div className="tableRow">
                <div className="tableCell">{doctorId}</div>
                <div className="tableCell">{name}</div>
                <div className="tableCell">{specialization}</div>
                <div className="tableCell">{patientNum}</div>
            </div>
    )
}