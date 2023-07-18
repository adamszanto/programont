import React from "react"
import { useState } from "react"
import PatientContact from "./patient";
import { Patientheader } from "./patientheader";


import { Link } from "react-router-dom";


export default function ContactDetail({ doctorId, name, specialization, patients, patientNum }) {

    return (
        <Link
            to={`/doctor/${doctorId}`}
            state={{
                doctorId,
                name,
                specialization,
                patients,
                patientNum
            }}>
            <div className="card">
                <div className="cardContent">
                    <div className="cardField">
                        <div className="cardFieldLabel">Doctor ID:</div>
                        <div className="cardFieldValue">{doctorId}</div>
                    </div>
                    <div className="cardField">
                        <div className="cardFieldLabel">Name:</div>
                        <div className="cardFieldValue">{name}</div>
                    </div>
                    <div className="cardField">
                        <div className="cardFieldLabel">Specialization:</div>
                        <div className="cardFieldValue">{specialization}</div>
                    </div>
                    <div className="cardField">
                        <div className="cardFieldLabel">Number of Patients:</div>
                        <div className="cardFieldValue">{patientNum}</div>
                    </div>
                </div>
            </div>
        </Link>
    )
}