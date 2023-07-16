import {Contactheader} from "./contactheader";
import Contact from "./contact";
import React, {useEffect, useState} from "react";
import DoctorData from "./DoctorData";
import { useParams } from "react-router-dom";
import PatientContact from "./patient";
import {Patientheader} from "./patientheader";

export function DoctorDetailList() {
    const {id} = useParams();
    const [doctor, setDoctor] = useState({patients: []});

    useEffect(()=> {
        const fetchData = async () => {
            try {
                const response = await fetch(`http://localhost:8080/api/doctors/${id}`);
                if(!response.ok) {
                    throw new Error("Couldn't process request");
                }
                const data = await response.json();
                setDoctor(data.Doctor);
            } catch (error) {
                console.error("Error happened", error);
            }
        };
        fetchData();
    }, [id]);

    return (
        <div className="doctorList">
            <Contactheader />
            <Contact
            key={doctor.id}
            doctorId={doctor.id}
            name={doctor.name}
            specialization={doctor.specialization}
            patientNum={doctor.patients.length}
            />
                <Patientheader />
                {doctor.patients.map((patient) => (
                    <PatientContact
                        key={patient.id}
                        name={patient.name}
                        birthDate={patient.birthDate}
                    />
                ))}
            </div>
    );
}