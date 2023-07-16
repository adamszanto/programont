import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import './DoctorList.css';

const DoctorDetails = () => {
    const { id } = useParams();

    const [doctor, setDoctor] = useState(null);

    useEffect(() => {
        const fetchDoctor = async () => {
            try {
                const response = await fetch(`http://localhost:8080/api/doctors/${id}`);
                if (!response.ok) {
                    throw new Error("Couldn't process request");
                }
                const data = await response.json();
                setDoctor(data);
            } catch (error) {
                console.error("Error happened", error);
            }
        };

        fetchDoctor();
    }, [id]);

    if (!doctor) {
        return null;
    }

    return (
        <div className="doctor-details">
            <h2>Részletes adatok</h2>
            <div>
                <strong>ID:</strong> {doctor.id}
            </div>
            <div>
                <strong>Név:</strong> {doctor.name}
            </div>
            <div>
                <strong>Specializáció:</strong> {doctor.specialization}
            </div>
            <div>
                <strong>Páciensek száma:</strong> {doctor.patients.length}
            </div>
            <h3>Páciensek:</h3>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Név</th>
                    <th>Születési dátum</th>
                </tr>
                </thead>
                <tbody>
                {doctor.patients.map((patient) => (
                    <tr key={patient.id}>
                        <td>{patient.id}</td>
                        <td>{patient.name}</td>
                        <td>{patient.birthDate}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default DoctorDetails;
