import React, { useState, useEffect } from 'react';

const DoctorTable = ({ onSelectDoctor }) => {
    const [doctors, setDoctors] = useState([]);

    useEffect(() => {
        // Az orvosok lekérése a backendről
        fetch('localhost:8080/api/doctors')
            .then(response => response.json())
            .then(data => setDoctors(data))
            .catch(error => console.log(error));
    }, []);

    return (
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Number of patients</th>
            </tr>
            </thead>
            <tbody>
            {doctors.map(doctor => (
                <tr key={doctor.id} onClick={() => onSelectDoctor(doctor)}>
                    <td>{doctor.id}</td>
                    <td>{doctor.name}</td>
                </tr>
            ))}
            </tbody>
        </table>
    );
};

export default DoctorTable;
