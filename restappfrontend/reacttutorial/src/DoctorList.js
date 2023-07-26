import {ContactHeader} from "./ContactHeader";
import Contact from "./Contact";
import React, {useEffect, useState} from "react";
import DoctorData from "./MockDoctorData";

export function DoctorList() {
    const [doctors, setDoctors] = useState([]);

    useEffect(()=> {
        console.log(DoctorData)
        const fetchData = async () => {
            try {
                const response = await fetch("http://localhost:8080/api/doctors");
                if(!response.ok) {
                    throw new Error("Couldn't process request");
                }
                const data = await response.json();
                setDoctors(data);
            } catch (error) {
                console.error("Error happened", error);
            }
        };
        fetchData();
    }, []);

    return(
        <div className="doctorList">
            <ContactHeader />
            {doctors.map((doctor) => (
                <Contact
                    key={doctor.id}
                    doctorId={doctor.id}
                    name={doctor.name}
                    specialization={doctor.specialization}
                    patientNum={doctor.patients.length}
                />
            ))}
        </div>
    );
}
