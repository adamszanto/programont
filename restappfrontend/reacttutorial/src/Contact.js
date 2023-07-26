import React from "react"
import { useState } from "react"
import PatientContact from "./PatientContact";
import { Patientheader } from "./PatientHeader";


import { Link } from "react-router-dom";
import {ContactTemplate} from "./ContactTemplate";


export default function Contact({ doctorId, name, specialization, patients, patientNum }) {

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
            <ContactTemplate
                doctorId={doctorId}
                name={name}
                specialization={specialization}
                patientNum={patientNum}
            />
        </Link>
    )
}