import React, { useState, useEffect } from 'react';
import './DoctorList.css';

const DoctorList = () => {
    const [doctors, setDoctors] = useState([]);
    const [selectedDoctor, setSelectedDoctor] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch('http://localhost:8080/api/doctors');
                if (!response.ok) {
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

    const handleDoctorClick = (doctor) => {
        setSelectedDoctor(doctor);
    };

    return (
        <div className="doctor-list">
            <h1>Orvosok</h1>
            <ul>
                {doctors.map((doctor) => (
                    <li
                        key={doctor.id}
                        className={selectedDoctor === doctor ? 'selected' : ''}
                        onClick={() => handleDoctorClick(doctor)}
                    >
                        <div>
                            <strong>ID:</strong> {doctor.id}
                        </div>
                        <div>
                            <strong>Name:</strong> {doctor.name}
                        </div>
                        <div>
                            <strong>Specialization:</strong> {doctor.specialization}
                        </div>
                        <div>
                            <strong>Páciensek száma:</strong> {doctor.patients.length}
                        </div>
                    </li>
                ))}
            </ul>
            {selectedDoctor && (
                <div className="doctor-details">
                    <h2>Részletes adatok</h2>
                    <div>
                        <strong>ID:</strong> {selectedDoctor.id}
                    </div>
                    <div>
                        <strong>Név:</strong> {selectedDoctor.name}
                    </div>
                    <div>
                        <strong>Specializáció:</strong> {selectedDoctor.specialization}
                    </div>
                    <div>
                        <strong>Páciensek száma:</strong> {selectedDoctor.patients.length}
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
                        {selectedDoctor.patients.map((patient) => (
                            <tr key={patient.id}>
                                <td>{patient.id}</td>
                                <td>{patient.name}</td>
                                <td>{patient.birthDate}</td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                </div>
            )}
        </div>
    );
};

export default DoctorList;
