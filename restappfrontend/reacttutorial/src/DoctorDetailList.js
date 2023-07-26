import { ContactHeader } from "./ContactHeader";
import Contact from "./Contact";
import React, { useEffect, useState } from "react";
import DoctorData from "./MockDoctorData";
import { useLocation, useParams } from "react-router-dom";
import PatientContact from "./PatientContact";
import { PatientHeader } from "./PatientHeader";
import {Footer} from "./Footer";
import BackTo from "./BackTo";
import DoctorCard from "./DoctorCard";
import {DoctorCardHeader} from "./DoctorCardHeader";

export function DoctorDetailList() {
    const params = useParams();
    const location = useLocation();
    const [doctor, setDoctor] = useState({ patients: [] });

    useEffect(() => {
        console.log('Doctor id: ', location.state.doctorId);
        console.log('Params: ', params)
        const fetchData = async () => {
            try {
                  const response = await fetch(`http://localhost:8080/api/doctors/${location.state.doctorId}`);
                if (!response.ok) {
                    throw new Error("Couldn't process request");
                }
                const data = await response.json();
                
                setDoctor(data);
            } catch (error) {
                console.error("Error happened", error);
            }
        };
        fetchData();
    }, []);

    return (
        <div className="main-div">
            <DoctorCardHeader />
            <DoctorCard
                key={doctor.id}
                doctorId={doctor.id}
                name={doctor.name}
                specialization={doctor.specialization}
                patientNum={doctor.patients.length}
            />
            <div>
            <PatientHeader />
            {doctor.patients.map((patient) => (
                <PatientContact
                    key={patient.id}
                    id={patient.id}
                    name={patient.name}
                    birthDate={patient.birthDate}
                />
            ))}
            </div>
            <BackTo />
            <Footer />
        </div>
    );
}