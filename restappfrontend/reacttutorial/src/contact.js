import React from "react"
import {useState} from "react"
import PatientContact from "./patient";

export default function Contact({doctorId, name, specialization, patients, patientNum}) {
    const [isShown, setIsShown] = useState(false);
    const handleClick = event => {
        setIsShown(current => !current);
    };


    return (
        <div>


            <div className="tableRow" onClick={handleClick}>
                <div className="tableCell">{doctorId}</div>
                <div className="tableCell">{name}</div>
                <div className="tableCell">{specialization}</div>
                <div className="tableCell">{patientNum}</div>
            </div>
            {isShown && (
                <div className="patientRow">
                    {patients.map((patient) => (
                        <div key={patient.id} className="tableRow">
                        <PatientContact
                            name={patient.name}
                            birthDate={patient.birthDate}
                        />
                        </div>
                    ))}
                </div>
            )}
        </div>
    )
}