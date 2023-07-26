import { ContactHeader } from "./ContactHeader";
import Contact from "./Contact";
import React, { useEffect, useState } from "react";
import DoctorData from "./MockDoctorData";
import { useLocation, useParams } from "react-router-dom";
import PatientContact from "./PatientContact";
import { Patientheader } from "./PatientHeader";
import {Footer} from "./Footer";
import BackTo from "./BackTo";

export default function DoctorCard({ doctorId, name, specialization, patients, patientNum }) {
    return(
        <div className="doctorCard">
            <div class="doctorCardLeft">
                <div className="doctorCardItem">
                    <span className="label">Doctor ID:</span>
                    <span className="value">{doctorId}</span>
                </div>
                <div className="doctorCardItem">
                    <span className="label">Name:</span>
                    <span className="value">{name}</span>
                </div>
                <div className="doctorCardItem">
                    <span className="label">Specialization:</span>
                    <span className="value">{specialization}</span>
                </div>
                <div className="doctorCardItem">
                    <span className="label">Number of Patients:</span>
                    <span className="value">{patientNum}</span>
                </div>
            </div>
            <div class="doctorCardRight">
                <img src="public/doctorpatient.png" alt=""/>
            </div>
        </div>
    )
}