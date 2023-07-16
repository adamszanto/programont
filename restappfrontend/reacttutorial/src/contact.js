import React from "react"
import {useState} from "react"
import PatientContact from "./patient";
import {Patientheader} from "./patientheader";

export default function Contact({doctorId, name, specialization, patients, patientNum}) {

    return (
        <a href={`http://localhost:3000/doctor/${doctorId}`}>
        <div>
            <div className="tableRow" >
                <div className="tableCell">{doctorId}</div>
                <div className="tableCell">{name}</div>
                <div className="tableCell">{specialization}</div>
                <div className="tableCell">{patientNum}</div>
            </div>
        </div>
        </a>
    )
}