import {Contactheader} from "./contactheader";
import Contact from "./contact";
import React from "react";
import doctorData from "./DoctorData";
import DoctorData from "./DoctorData";

export function Doctorlist() {
    const doctorElements = DoctorData.map(doctor => {
        return <Contact
            doctorId={doctor.doctorId}
            name={doctor.name}
            specialization={doctor.specialization}
            patientNum={doctor.patientNum} />
    })
    return(
        <div className="doctorList">
            <Contactheader />
            {doctorElements}
        </div>
    )
}
