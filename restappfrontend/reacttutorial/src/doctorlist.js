import {Contactheader} from "./contactheader";
import Contact from "./contact";
import React from "react";

export function Doctorlist() {
    return(
        <div className="doctorList">
            <Contactheader />
            <Contact
                doctorId="1"
                name="Petőfi Doktor"
                specialization="Surgeon"
                patientNum="2"
            />
            <Contact
                doctorId="2"
                name="Arany Doktor"
                specialization="General Practitioner"
                patientNum="1"
            />
        </div>
    )
}
