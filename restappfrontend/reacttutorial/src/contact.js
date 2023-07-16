import React from "react"
import {useState} from "react"
import PatientContact from "./patient";
import {Patientheader} from "./patientheader";
import { Link } from 'react-router-dom';

export default function Contact({doctorId, name, specialization, patients, patientNum}) {

    return (
        <Link to={`/doctors/${doctorId}`}>
        <div>
            <div className="tableRow" >
                <div className="tableCell">{doctorId}</div>
                <div className="tableCell">{name}</div>
                <div className="tableCell">{specialization}</div>
                <div className="tableCell">{patientNum}</div>
            </div>
        </div>
        </Link>
    )
}