import React from 'react';

const DoctorDetails = ({ doctor }) => {
    return (
        <div>
            <h2>Details</h2>
            <p>ID: {doctor.id}</p>
            <p>Név: {doctor.name}</p>
            <p>Specialization: {doctor.specialization}</p>
            <h3>Patients:</h3>
            <ul>
                {doctor.patients.map(patient => (
                    <li key={patient.id}>
                        {patient.name} (Date of birth: {patient.birthDate})
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default DoctorDetails;
